package com.point72.wechat.media;

import java.io.File;
import java.text.MessageFormat;

import com.point72.plugin.http.HttpClient;
import com.point72.plugin.http.HttpClient.Response_Type;
import com.point72.wechat.ApiUrl.Media;
import com.point72.wechat.common.Invoke;

import okhttp3.MediaType;
import okhttp3.MultipartBody;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.ResponseBody;

/**
 * 临时素材接口
 * 
 * @author Houkm
 *
 *         2017年6月5日
 */
public class TempMediaHandler {

	/**
	 * 新增临时图片素材<br>
	 * 2M，支持PNG\JPEG\JPG\GIF格式<br>
	 * 
	 * @param token
	 * @param file
	 * @param fileName
	 * @return
	 * @author Houkm 2017年6月5日
	 */
	public static String addImage(String token, File file, String fileName) {
		return upload(token, "image", file, fileName);
	}

	/**
	 * 新增临时语音素材<br>
	 * 2M，播放长度不超过60s，支持AMR\MP3格式<br>
	 * 
	 * @param token
	 * @param file
	 * @param fileName
	 * @return
	 * @author Houkm 2017年6月5日
	 */
	public static String addVoice(String token, File file, String fileName) {
		return upload(token, "voice", file, fileName);
	}

	/**
	 * 新增临时视频素材<br>
	 * 10MB，支持MP4格式<br>
	 * 
	 * @param token
	 * @param file
	 * @param fileName
	 * @return
	 * @author Houkm 2017年6月5日
	 */
	public static String addVideo(String token, File file, String fileName) {
		return upload(token, "video", file, fileName);
	}

	/**
	 * 新增临时缩略图素材<br>
	 * 64KB，支持JPG格式<br>
	 * 
	 * @param token
	 * @param file
	 * @param fileName
	 * @return
	 * @author Houkm 2017年6月5日
	 */
	public static String addThumb(String token, File file, String fileName) {
		return upload(token, "thumb", file, fileName);
	}

	/**
	 * 获取image/voice/thumb临时素材
	 * 
	 * @param token
	 * @param mediaId
	 * @return
	 * @author Houkm 2017年6月5日
	 */
	public static byte[] get(String token, String mediaId) {
		String api = MessageFormat.format(Media.Get.url(), token, mediaId);
		byte[] bs = (byte[]) HttpClient.get(api, Response_Type.Byte);
		return bs;
	}

	/**
	 * 获取视频临时素材URL
	 * 
	 * @param token
	 * @param mediaId
	 * @return
	 * @author Houkm 2017年6月5日
	 */
	public static String getVideo(String token, String mediaId) {
		String result = Invoke.get(Media.Get.url(), token, mediaId);
		return result;
	}

	/**
	 * 高清语音素材获取接口<br>
	 * 使用本接口获取从JSSDK的uploadVoice接口上传的临时语音素材，格式为speex，16K采样率。该音频比上文的临时素材获取接口（格式为amr，8K采样率）更加清晰，适合用作语音识别等对音质要求较高的业务
	 * 
	 * @param token
	 * @param mediaId
	 * @return
	 * @author Houkm 2017年6月5日
	 */
	public static byte[] getHDVoice(String token, String mediaId) {
		String api = MessageFormat.format(Media.GetHDVoice.url(), token, mediaId);
		byte[] bs = (byte[]) HttpClient.get(api, Response_Type.Byte);
		return bs;
	}

	private static String upload(String token, String type, File file, String fileName) {
		String api = MessageFormat.format(Media.Upload.url(), token, type);
		MediaType mediaType = MediaType.parse("application/octet-stream");
		RequestBody requestBody = new MultipartBody.Builder().setType(MultipartBody.FORM)
				.addFormDataPart("Charset", "UTF-8").addFormDataPart("Connection", "Keep-Alive")
				.addFormDataPart("filelength", String.valueOf(file.length()))
				.addFormDataPart("filename", fileName, RequestBody.create(mediaType, file)).build();
		Request request = new Request.Builder().url(api).post(requestBody).build();
		ResponseBody responseBody = HttpClient.async(request);
		String result = HttpClient.getResponse(responseBody, Response_Type.String).toString();
		return result;
	}

}
