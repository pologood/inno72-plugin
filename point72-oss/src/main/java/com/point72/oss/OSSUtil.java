package com.point72.oss;

import java.io.BufferedInputStream;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.net.URL;
import java.text.MessageFormat;
import java.util.Map;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.aliyun.oss.OSSClient;
import com.aliyun.oss.model.GetObjectRequest;
import com.point72.oss.config.OSSProperties;
import com.point72.plugin.http.HttpClient;
import com.point72.plugin.http.HttpClient.Response_Type;

/**
 * 引入插件后需在application.properties文件中添加配置spring.profiles.include=oss
 * 
 * @author Houkm
 *
 *         2017年7月7日
 */
@Component
public class OSSUtil {

	@Autowired
	private OSSClient client;

	@Autowired
	OSSProperties prop;

	private static OSSClient $client;
	private static String bucketName;

	@SuppressWarnings("static-access")
	@PostConstruct
	public void init() {
		this.$client = client;
		this.bucketName = prop.getBucketName();
	}

	/**
	 * 上传文件
	 * 
	 * @param bytes
	 * @param targarPath
	 * @author Houkm 2017年6月8日
	 */
	public static void uploadImgByBytes(byte[] bytes, String targarPath) {
		$client.putObject(bucketName, targarPath, new ByteArrayInputStream(bytes));
	}

	/**
	 * 上传文件
	 * 
	 * @param inputStream
	 * @param targetPath
	 * @throws Exception
	 * @author Houkm 2017年6月8日
	 */
	public static void uploadByStream(InputStream inputStream, String targetPath) throws Exception {
		$client.putObject(bucketName, targetPath, inputStream);
		inputStream.close();
	}

	/**
	 * 下载文件
	 * 
	 * @param filePath
	 * @param targetPath
	 * @throws Exception
	 * @author Houkm 2017年6月8日
	 */
	public static void downloadFile(String filePath, String targetPath) throws Exception {
		$client.getObject(new GetObjectRequest(bucketName, filePath), new File(targetPath));
	}

	/**
	 * 上传网络文件
	 * 
	 * @param url
	 * @param targetPath
	 * @throws Exception
	 * @author Houkm 2017年6月8日
	 */
	public static void uploadNetFile(String url, String targetPath) throws Exception {
		InputStream inputStream = new URL(url).openStream();
		$client.putObject(bucketName, targetPath, inputStream);
		inputStream.close();
	}

	/**
	 * 上传本地文件
	 * 
	 * @param filePath
	 * @param targetPath
	 * @throws Exception
	 * @author Houkm 2017年6月8日
	 */
	public static void uploadLocalFile(String filePath, String targetPath) throws Exception {
		InputStream inputStream = new FileInputStream(filePath);
		$client.putObject(bucketName, targetPath, inputStream);
		inputStream.close();
	}

	/**
	 * 下载微信企业号临时图片并上传至阿里OSS
	 * 
	 * @param path
	 * @param token
	 * @param ids
	 */
	public static void uploadFromQyh(String token, Map<String, String> id$path) {

		ExecutorService pool = Executors.newFixedThreadPool(10);

		id$path.forEach((id, path) -> {
			try {
				Callable<InputStream> ca = new Download(token, id);
				Future<InputStream> future = pool.submit(ca);
				InputStream stream = future.get();
				$client.putObject(bucketName, path, stream);
				stream.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		});

	}

	/**
	 * 上传文件并压缩文件
	 * 
	 * @param inputStream
	 * @param targetPath
	 * @param hight
	 * @param weight
	 * @return 压缩后文件字节大小
	 * @Date 2017年3月1日
	 * @Author Houkm
	 */
	public static int uploadAndResize(InputStream inputStream, String targetPath, int hight, int weight) {
		String large = "l/" + targetPath;
		String small = "s/" + targetPath;
		int size = 0;
		try {
			uploadByStream(inputStream, large);

			String resizeUrl = "http://nblow.oss-cn-beijing.aliyuncs.com/" + large
					+ "?x-oss-process=image/resize,m_pad,h_" + hight + ",w_" + weight;

			byte[] newFile = HttpClient.getBytes(resizeUrl);
			uploadImgByBytes(newFile, small);
			size = newFile.length;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return size;
	}

}

class Download implements Callable<InputStream> {
	private String id;
	private String accessToken;

	public Download(String accessToken, String id) {
		this.accessToken = accessToken;
		this.id = id;
	}

	@Override
	public InputStream call() throws Exception {
		String api = MessageFormat.format("http://api.weixin.qq.com/cgi-bin/media/get?access_token={0}&media_id={1}",
				accessToken, id);
		byte[] bs = (byte[]) HttpClient.get(api, Response_Type.Byte);
		InputStream stream = new BufferedInputStream(new ByteArrayInputStream(bs));
		return stream;
	}
}