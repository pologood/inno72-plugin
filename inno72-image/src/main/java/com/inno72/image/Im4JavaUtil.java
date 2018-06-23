package com.inno72.image;

import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.math.RoundingMode;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import javax.imageio.ImageIO;

import org.im4java.core.CompositeCmd;
import org.im4java.core.ConvertCmd;
import org.im4java.core.IM4JavaException;
import org.im4java.core.IMOperation;
import org.im4java.core.IdentifyCmd;
import org.im4java.core.ImageCommand;
import org.im4java.process.ArrayListOutputConsumer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.FileCopyUtils;

import com.inno72.oss.OSSUtil;

/**
 * 引入插件后需在application.properties文件中添加配置spring.profiles.include=oss
 * 
 *
 */
public class Im4JavaUtil {

	private Im4JavaUtil() {
	}

	private static final Logger logger = LoggerFactory.getLogger(Im4JavaUtil.class);

	private static final String TEMP = "/tmp/"; // 临时目录
	private static final int WIDTH = 1400; // 像素宽度

	private static final int KB = 1024;

	private static ImageCommand convert = null;
	private static ImageCommand identify = null;
	private static ImageCommand composite = null;

	private static final String COMMAND_SEARCH_PATH = "/usr/local/opt/imagemagick/bin";

	static {
		convert = new ConvertCmd();
		identify = new IdentifyCmd();
		composite = new CompositeCmd();
		if (!System.getProperty("os.name").equals("Linux")) {
			convert.setSearchPath(COMMAND_SEARCH_PATH);
			identify.setSearchPath(COMMAND_SEARCH_PATH);
			composite.setSearchPath(COMMAND_SEARCH_PATH);
		}
	}

	/**
	 * 获取图片信息
	 * 
	 * @param srcImagePath
	 *            图片路径
	 * @return Map {height=, filelength=, directory=, width=, filename=}
	 */
	public static Map<String, Object> getImageInfo(String srcImagePath) {
		IMOperation op = new IMOperation();
		op.format("%w,%h,%d,%f,%b");
		op.addImage(srcImagePath);
		ArrayListOutputConsumer output = new ArrayListOutputConsumer();
		identify.setOutputConsumer(output);
		run(identify, op);
		ArrayList<String> cmdOutput = output.getOutput();
		if (cmdOutput.size() != 1) {
			return null;
		}
		String line = cmdOutput.get(0);
		String[] arr = line.split(",");
		Map<String, Object> info = new HashMap<String, Object>();
		info.put("width", Integer.parseInt(arr[0]));
		info.put("height", Integer.parseInt(arr[1]));
		info.put("directory", arr[2]);
		info.put("filename", arr[3]);
		info.put("filelength", Integer.parseInt(arr[4]));
		return info;
	}

	/**
	 * 压缩图片
	 * 
	 * @param srcImagePath
	 *            源图片路径
	 * @param destImagePath
	 *            目标图片路径
	 * @param quality
	 *            压缩质量（0-100）
	 */
	public static void resize(String srcImagePath, String destImagePath, Double quality) {
		// 压缩-不加水印
		IMOperation op = new IMOperation();
		op.addImage(srcImagePath);
		op.quality(quality);
		op.addImage(createDirectory(destImagePath));
		run(convert, op);
	}

	/**
	 * 去除Exif信息，可减小文件大小
	 * 
	 * @param srcImagePath
	 *            源图片路径
	 * @param destImagePath
	 *            目标图片路径
	 */
	public static void removeProfile(String srcImagePath, String destImagePath) {
		IMOperation op = new IMOperation();
		op.addImage(srcImagePath);
		op.p_profile("*");
		op.addImage(createDirectory(destImagePath));
		run(convert, op);
	}

	/**
	 * 等比缩放图片（如果width为空，则按height缩放; 如果height为空，则按width缩放）
	 * 
	 * @param srcImagePath
	 *            源图片路径
	 * @param destImagePath
	 *            目标图片路径
	 * @param width
	 *            缩放后的宽度
	 * @param height
	 *            缩放后的高度
	 */
	public static void scaleResize(String srcImagePath, String destImagePath, Integer width, Integer height) {
		IMOperation op = new IMOperation();
		op.addImage(srcImagePath);
		op.sample(width, height);
		op.addImage(createDirectory(destImagePath));
		run(convert, op);
	}

	/**
	 * 从原图中裁剪出新图
	 * 
	 * @param srcImagePath
	 *            源图片路径
	 * @param destImagePath
	 *            目标图片路径
	 * @param x
	 *            原图左上角
	 * @param y
	 *            原图左上角
	 * @param width
	 *            新图片宽度
	 * @param height
	 *            新图片高度
	 */
	public static void crop(String srcImagePath, String destImagePath, int x, int y, int width, int height) {
		IMOperation op = new IMOperation();
		op.addImage(srcImagePath);
		op.crop(width, height, x, y);
		op.addImage(createDirectory(destImagePath));
		run(convert, op);
	}

	/**
	 * 将图片分割为若干小图
	 * 
	 * @param srcImagePath
	 *            源图片路径
	 * @param destImagePath
	 *            目标图片路径
	 * @param width
	 *            指定宽度（默认为完整宽度）
	 * @param height
	 *            指定高度（默认为完整高度）
	 * @return 小图路径
	 */
	@Deprecated
	public static List<String> subsection(String srcImagePath, String destImagePath, Integer width, Integer height) {
		IMOperation op = new IMOperation();
		op.addImage(srcImagePath);
		op.crop(width, height);
		op.addImage(createDirectory(destImagePath));
		run(convert, op);
		return getSubImages(destImagePath);
	}

	/**
	 * 旋转图片
	 * 
	 * @param srcImagePath
	 *            源图片路径
	 * @param destImagePath
	 *            目标图片路径
	 * @param angle
	 *            旋转的角度
	 */
	public static void rotate(String srcImagePath, String destImagePath, Double angle) {
		File sourceFile = new File(srcImagePath);
		if (!sourceFile.exists() || !sourceFile.canRead() || !sourceFile.isFile()) {
			return;
		}

		IMOperation operation = new IMOperation();
		operation.addImage(srcImagePath);
		operation.rotate(angle);
		operation.addImage(destImagePath);
		run(convert, operation);
	}

	/**
	 * 获取图片分割后的小图路径
	 * 
	 * @param destImagePath
	 *            目标图片路径
	 * @return 小图路径
	 */
	private static List<String> getSubImages(String destImagePath) {
		// 文件所在目录
		String fileDir = destImagePath.substring(0, destImagePath.lastIndexOf(File.separatorChar));
		// 文件名称
		String fileName = destImagePath.substring(destImagePath.lastIndexOf(File.separatorChar) + 1);
		// 文件名（无后缀）
		String n1 = fileName.substring(0, fileName.lastIndexOf("."));
		// 后缀
		String n2 = fileName.replace(n1, "");

		List<String> fileList = new ArrayList<String>();
		String path = null;
		for (int i = 0;; i++) {
			path = fileDir + File.separatorChar + n1 + "-" + i + n2;
			if (new File(path).exists())
				fileList.add(path);
			else
				break;
		}
		return fileList;
	}

	/**
	 * 创建目录
	 * 
	 * @param path
	 * @return path
	 */
	private static String createDirectory(String path) {
		File file = new File(path);
		if (!file.exists())
			file.getParentFile().mkdirs();
		return path;
	}

	/**
	 * 通过文件名获取文件类型
	 * 
	 * @param fileName
	 *            文件名
	 * @return 文件类型
	 */
	private static String getFileType(String fileName) {
		if (fileName == null || "".equals(fileName.trim()) || fileName.lastIndexOf(".") == -1) {
			return null;
		}
		String type = fileName.substring(fileName.lastIndexOf(".") + 1);
		if ("jpg".equals(type.toLowerCase()) || "jpeg".equals(type.toLowerCase()))
			return type.toLowerCase();
		else
			return "jpg";
	}

	/**
	 * 上传文件,按比例缩放和压缩图片
	 * 
	 * @param inputStream
	 * @param targetPath
	 *            保存到oss下的目录， 原图目录加前缀 l/test/test.jpg 压缩目录加前缀s/test/test.jpg
	 */
	public static void uploadAndResize(InputStream inputStream, String targetPath) {
		String large = "l/" + targetPath;
		String small = "s/" + targetPath;
		try {
			ByteArrayOutputStream baos = new ByteArrayOutputStream();
			byte[] buffer = new byte[1024];
			int len;
			while ((len = inputStream.read(buffer)) > -1) {
				baos.write(buffer, 0, len);
			}
			baos.flush();
			// 打开一个新的输入流
			InputStream is1 = new ByteArrayInputStream(baos.toByteArray());
			InputStream is2 = new ByteArrayInputStream(baos.toByteArray());
			OSSUtil.uploadByStream(is1, large); // 保存大图

			// 处理图片，并返回地址
			String tempImagePath = Im4JavaUtil.scaleResizeImage(is2, targetPath);
			File file = new File(tempImagePath);
			OSSUtil.uploadByStream(new FileInputStream(file), small);// 保存处理以后的图片
			file.delete(); // 删除文件

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * 上传文件,按比例缩放和压缩图片,没有前缀s
	 * 
	 * @param inputStream
	 * @param targetPath
	 *            保存到oss下的目录， 原图目录加前缀 l/test1/test1.jpg 压缩目录不变test1/test1.jpg
	 */
	public static void uploadAndResizeNoPrefix(InputStream inputStream, String targetPath) {
		String large = "l/" + targetPath;
		String small = targetPath;
		try {
			ByteArrayOutputStream baos = new ByteArrayOutputStream();
			byte[] buffer = new byte[1024];
			int len;
			while ((len = inputStream.read(buffer)) > -1) {
				baos.write(buffer, 0, len);
			}
			baos.flush();
			// 打开一个新的输入流
			InputStream is1 = new ByteArrayInputStream(baos.toByteArray());
			InputStream is2 = new ByteArrayInputStream(baos.toByteArray());
			OSSUtil.uploadByStream(is1, large); // 保存大图
			logger.info("上传源图的文件地址:" + large);

			// 处理图片，并返回地址
			String tempImagePath = Im4JavaUtil.scaleResizeImage(is2, targetPath);
			File file = new File(tempImagePath);
			OSSUtil.uploadByStream(new FileInputStream(file), small);// 保存处理以后的图片
			logger.info("压缩以后上传的文件地址:" + small);
			file.delete(); // 删除文件

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * 等比例缩放和压缩图片
	 * 
	 * @param inputStream
	 * @param targetPath
	 * @return 图片路径
	 */
	public static String scaleResizeImage(InputStream inputStream, String targetPath) {
		String srcImagePath = TEMP + UUID.randomUUID().toString().replaceAll("-", "") + "." + getFileType(targetPath); // 源文件
		File src = new File(srcImagePath);
		try {
			FileCopyUtils.copy(inputStream, new FileOutputStream(src));
		} catch (IOException e) {
			e.printStackTrace();
		} // 存放图片

		// 获取图片的宽度
		BufferedImage buffimg = null;
		try {
			buffimg = ImageIO.read(new File(srcImagePath));
		} catch (IOException e) {
			e.printStackTrace();
		}
		int w = buffimg.getWidth();
		int h = buffimg.getHeight();
		logger.info("src file width = {},height ={}", w, h);

		// 等比例缩放
		if (w > WIDTH) {
			w = WIDTH;
			scaleResize(srcImagePath, srcImagePath, w, h); // 按照宽度等比例缩放
		}
		try {
			resizeImage(srcImagePath);
		} catch (Exception e) {
			e.printStackTrace();
		} // 按大小缩放
		return srcImagePath;
	}

	private static void resizeImage(String destImagePath) throws Exception {
		File dest = new File(destImagePath);
		logger.info("dest file[{}], file size {} B", destImagePath, dest.length());
		if (dest.length() > 500 * KB) { // 如果文件还大于500k
			long num1 = 512000l; // 500k
			long num2 = dest.length();
			// 创建一个数值格式化对象
			NumberFormat numberFormat = NumberFormat.getInstance();
			// 设置精确到小数点后0位
			numberFormat.setMaximumFractionDigits(0);
			numberFormat.setRoundingMode(RoundingMode.DOWN); // 不用四舍五入
			float rt = (float) num1 / num2 * 100; // 计算压缩比例
			String result = numberFormat.format(rt);
			Double parseDouble = Double.valueOf(result);
			logger.info("源文件大小" + dest.length() + "B,压缩比例:" + parseDouble + "%");
			if (parseDouble != 0)
				resize(destImagePath, destImagePath, parseDouble); // 根据比例压缩
		}
	}

	private static void run(ImageCommand command, IMOperation operation) {
		try {
			command.run(operation);
		} catch (IOException | InterruptedException | IM4JavaException e) {
			e.printStackTrace();
		}
	}

}
