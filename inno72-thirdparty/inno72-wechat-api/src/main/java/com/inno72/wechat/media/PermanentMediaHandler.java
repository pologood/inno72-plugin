package com.inno72.wechat.media;

import java.io.File;
import java.text.MessageFormat;
import java.util.List;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.inno72.plugin.http.HttpClient;
import com.inno72.plugin.http.HttpClient.Request_Type;
import com.inno72.plugin.http.HttpClient.Response_Type;
import com.inno72.wechat.ApiUrl.Material;
import com.inno72.wechat.common.Invoke;

import okhttp3.Headers;
import okhttp3.MediaType;
import okhttp3.MultipartBody;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.ResponseBody;

/**
 * 永久素材接口
 * 
 * 
 * @author Houkm
 *
 *         2017年6月5日
 */
public class PermanentMediaHandler {

	/**
	 * 获取永久image/voice/thumb素材
	 * 
	 * @param token
	 * @param mediaId
	 * @return
	 * @author Houkm 2017年6月5日
	 */
	public static byte[] get(String token, String mediaId) {
		String api = MessageFormat.format(Material.Get.url(), token);
		JSONObject json = new JSONObject();
		json.put("media_id", mediaId);
		byte[] bs = (byte[]) HttpClient.post(api, MediaType.parse("application/json; charset=utf-8"),
				json.toJSONString(), Request_Type.String, Response_Type.Byte, null);
		return bs;
	}

	/**
	 * 获取永久图文/视频素材
	 * 
	 * @param token
	 * @param mediaId
	 * @return
	 * @author Houkm 2017年6月5日
	 */
	public static String getVideoOrNews(String token, String mediaId) {
		JSONObject json = new JSONObject();
		json.put("media_id", mediaId);
		String result = Invoke.post(Material.Get.url(), json.toJSONString(), token);
		return result;
	}

	/**
	 * 获取type类型的永久素材列表，用offset（0开始）开始获取count(1-20)条
	 * 
	 * @param token
	 * @param type
	 * @param offset
	 * @param count
	 * @return
	 * @author Houkm 2017年6月5日
	 */
	public static String get(String token, String type, int offset, int count) {
		JSONObject json = new JSONObject();
		json.put("type", type);
		json.put("offset", offset);
		json.put("count", count);
		String result = Invoke.post(Material.List.url(), json.toJSONString(), token);
		return result;
	}

	/**
	 * 获取永久素材总数
	 * 
	 * @param token
	 * @return
	 * @author Houkm 2017年6月5日
	 */
	public static String count(String token) {

		String result = Invoke.get(Material.Count.url(), token);

		return result;
	}

	/**
	 * 新增图片永久素材<br>
	 * 大小：2M<br>
	 * 支持bmp/png/jpeg/jpg/gif格式
	 * 
	 * @author Houkm 2017年6月5日
	 */
	public static String addImage(String token, File file, String fileName) {
		return upload(token, "image", file, fileName);
	}

	/**
	 * 新增语音永久素材<br>
	 * 大小：2M<br>
	 * 播放长度不超过60s<br>
	 * mp3/wma/wav/amr格式
	 * 
	 * @author Houkm 2017年6月5日
	 */
	public static String addVoice(String token, File file, String fileName) {
		return upload(token, "voice", file, fileName);
	}

	/**
	 * 新增缩略图永久素材<br>
	 * 大小：64K<br>
	 * 支持JPG格式<br>
	 * 
	 * @author Houkm 2017年6月5日
	 */
	public static String addThumb(String token, File file, String fileName) {
		return upload(token, "thumb", file, fileName);
	}

	/**
	 * 上传永久图文
	 * 
	 * @param token
	 * @param news
	 * @return
	 * @author Houkm 2017年6月5日
	 */
	public static String addNews(String token, List<News> news) {
		String result = Invoke.post(Material.Add_News.url(), JSON.toJSONString(news), token);
		return result;
	}

	/**
	 * 修改mediaId的图文消息的第index条文章,index从0开始
	 * 
	 * @param token
	 * @param mediaId
	 * @param index
	 * @param article
	 * @return
	 * @author Houkm 2017年6月5日
	 */
	public static String editNews(String token, String mediaId, int index, Article article) {
		JSONObject json = new JSONObject();
		json.put("media_id", mediaId);
		json.put("index", index);
		json.put("articles", article);
		String result = Invoke.post(Material.Update_News.url(), json.toJSONString(), token);
		return result;
	}

	@Deprecated
	public static String addVideo() {
		return null;
	}

	private static String upload(String token, String type, File file, String fileName) {
		String api = MessageFormat.format(Material.Add_Other.url(), token, type);
		RequestBody fileBody = RequestBody.create(MediaType.parse("application/octet-stream"), file);
		RequestBody requestBody = new MultipartBody.Builder().setType(MultipartBody.FORM)
				.addPart(Headers.of("Content-Disposition",
						"form-data; name=\"media\";filename=\"" + fileName + "\";filelength=\"" + file.length() + "\""),
						fileBody)
				.build();

		Request request = new Request.Builder().url(api).post(requestBody).build();
		ResponseBody responseBody = HttpClient.async(request);
		String result = HttpClient.getResponse(responseBody, Response_Type.String).toString();

		return result;
	}

}
