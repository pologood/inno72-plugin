package com.point72.image;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.io.OutputStream;
import java.nio.file.Paths;
import java.util.Hashtable;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.EncodeHintType;
import com.google.zxing.MultiFormatWriter;
import com.google.zxing.WriterException;
import com.google.zxing.client.j2se.MatrixToImageWriter;
import com.google.zxing.common.BitMatrix;

public class QrcodeUtil {

	/**
	 * 生成二维码
	 * 
	 * @param url
	 * @param size
	 *            {width, height}
	 * @return
	 * @author Houkm 2017年9月7日
	 */
	public static BufferedImage generate(String url, int... size) {
		BitMatrix matrix = encode(url, size);
		BufferedImage image = MatrixToImageWriter.toBufferedImage(matrix);
		return image;
	}

	/**
	 * 将二维码写到指定文件路径
	 * 
	 * @param url
	 * @param format
	 *            文件类型
	 * @param distFile
	 *            生成二维码文件
	 * @param size
	 *            {width, height}
	 * @author Houkm 2017年9月7日
	 */
	public static void generate(String url, String format, File distFile, int... size) {
		BitMatrix matrix = encode(url, size);
		try {
			MatrixToImageWriter.writeToPath(matrix, format, Paths.get(distFile.toURI()));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * 将二维码写到给定的流
	 * 
	 * @param url
	 * @param format
	 *            文件类型
	 * @param outputStream
	 *            二维码写入的流
	 * @param size
	 * @author Houkm 2017年9月7日
	 */
	public static void generate(String url, String format, OutputStream outputStream, int... size) {
		BitMatrix matrix = encode(url, size);
		try {
			MatrixToImageWriter.writeToStream(matrix, format, outputStream);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private static BitMatrix encode(String url, int... size) {
		int width = 430;
		int height = 430;

		if (size.length > 1) {
			width = size[0];
			height = size[1];
		} else if (size.length == 1) {
			width = height = size[0];
		}
		Hashtable<EncodeHintType, Object> hints = new Hashtable<>();
		hints.put(EncodeHintType.CHARACTER_SET, "UTF-8");
		hints.put(EncodeHintType.MARGIN, 1);
		BitMatrix matrix = null;
		try {
			matrix = new MultiFormatWriter().encode(url, BarcodeFormat.QR_CODE, width, height, hints);
		} catch (WriterException e) {
			e.printStackTrace();
		}
		return matrix;
	}

}
