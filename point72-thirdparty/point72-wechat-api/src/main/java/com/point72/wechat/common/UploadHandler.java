package com.point72.wechat.common;

import java.io.File;
import java.text.MessageFormat;

import com.point72.plugin.http.HttpClient;
import com.point72.plugin.http.HttpClient.Response_Type;
import com.point72.wechat.ApiUrl.Material;

import okhttp3.Headers;
import okhttp3.MediaType;
import okhttp3.MultipartBody;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.ResponseBody;

/**
 * 上传接口
 * 
 * @author Houkm
 *
 *         2017年6月5日
 */
public class UploadHandler {
	public static String uploadLogo(String token, File file) {
		String api = Material.Upload_Image.url();
		api = MessageFormat.format(api, token);
		String fileName = file.getName();
		String fileType = fileName.substring(fileName.indexOf(".") + 1);
		RequestBody fileBody = RequestBody.create(MediaType.parse("application/octet-stream"), file);
		RequestBody requestBody = new MultipartBody.Builder().setType(MultipartBody.FORM)
				.addPart(Headers.of("Content-Disposition", "form-data; name=\"media\";filename=\"" + fileName
						+ "\";filelength=\"" + file.length() + "\";\"fileType=\"" + fileType + "\";"), fileBody)
				.build();

		Request request = new Request.Builder().url(api).post(requestBody).build();
		ResponseBody responseBody = HttpClient.async(request);
		String result = HttpClient.getResponse(responseBody, Response_Type.String).toString();
		ResultHandler handler = ResultHandler.create(result);
		if (handler.isSuccess()) {
			String url = handler.getString("url");
			return url;
		}
		return result;
	}
}
