package com.inno72.ddtalk.file;

import java.io.File;
import java.text.MessageFormat;

import com.inno72.ddtalk.ApiUrl;
import com.inno72.plugin.http.HttpClient;
import com.inno72.plugin.http.HttpClient.Response_Type;

import okhttp3.Callback;

/**
 * 文件管理
 * 
 * @author Houkm
 *
 *         2017年9月11日
 */
public class FileHandler {

	public static enum FileType {
		image, voice, file;
	}

	/**
	 * 上传文件
	 * 
	 * @param token
	 * @param file
	 * @return
	 * @author Houkm 2017年9月11日
	 */
	public static String upload(String token, FileType fileType, String filePath) {
		File file = new File(filePath);
		Object obj = HttpClient.upload(MessageFormat.format(ApiUrl.File.Upload.url(), token, fileType), file,
				Response_Type.String);
		return obj == null ? null : (String) obj;
	}

	/**
	 * 异步上传文件
	 * 
	 * @param token
	 * @param file
	 * @return
	 * @author Houkm 2017年9月11日
	 */
	public static void upload(String token, FileType fileType, String filePath, Callback callback) {
		File file = new File(filePath);
		HttpClient.upload(MessageFormat.format(ApiUrl.File.Upload.url(), token, fileType), file, callback);
	}

	/**
	 * 获取文件字节
	 * 
	 * @param token
	 * @param mediaId
	 * @return
	 * @author Houkm 2017年9月11日
	 */
	public static byte[] getBytes(String token, String mediaId) {
		byte[] bytes = (byte[]) HttpClient.get(MessageFormat.format(ApiUrl.File.Download.url(), token, mediaId),
				Response_Type.Byte);
		return bytes;
	}

}
