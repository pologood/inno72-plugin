package com.inno72.ddtalk.cspace;

import java.io.File;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.text.MessageFormat;

import com.inno72.ddtalk.ApiUrl.CSpace;
import com.inno72.ddtalk.Invoke;
import com.inno72.plugin.http.HttpClient;
import com.inno72.plugin.http.HttpClient.Response_Type;

import okhttp3.Callback;

/**
 * 钉盘接口
 * 
 * @author Houkm
 *
 *         2017年9月11日
 */
public class CSpaceHandler {

	/**
	 * 发送文件给指定用户<br>
	 * 将文件发送给指定用户，用户将收到以微应用名义发送的一条文件消息。
	 * 
	 * @param token
	 * @param agentId
	 * @param userId
	 * @param mediaId
	 * @param fileName
	 * 
	 * @return
	 * @author Houkm 2017年9月11日
	 */
	public static String send2User(String token, String agentId, String userId, String mediaId, String fileName) {
		try {
			mediaId = URLEncoder.encode(mediaId, "UTF-8");
			fileName = URLEncoder.encode(fileName, "UTF-8");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		return Invoke.post(CSpace.Send_File2User.url(), "", token, agentId, userId, mediaId, fileName);
	}

	/**
	 * 新增文件到用户钉盘
	 * 
	 * @param token
	 * @param agentId
	 * @param code
	 *            如果是微应用，code值为微应用免登授权码,如果是服务窗应用，code值为服务窗免登授权码。code为临时授权码，只能消费一次，下次请求需要重新获取新的code。
	 * @param mediaId
	 * @param spaceId
	 *            调用云盘选择控件后获取的用户钉盘空间ID
	 * @param folder
	 *            调用云盘选择控件后获取的用户钉盘文件夹ID
	 * @param name
	 *            上传文件的名称，不能包含非法字符
	 * @param overwrite
	 *            遇到同名文件是否覆盖，若不覆盖，则会自动重命名本次新增的文件，默认为false
	 * @return
	 * @author Houkm 2017年9月11日
	 */
	public static String add2User(String token, String agentId, String code, String mediaId, String spaceId,
			String folder, String name, boolean overwrite) {
		try {
			name = URLEncoder.encode(name, "UTF-8");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		return Invoke.post(CSpace.Add_File2User.url(), "", token, agentId, code, mediaId, spaceId, folder, name,
				String.valueOf(overwrite));
	}

	/**
	 * 获取企业下的自定义空间
	 * 
	 * @param token
	 * @param domain
	 *            企业调用时传入，需要为10个字节以内的字符串，仅可包含字母和数字，大小写不敏感
	 * @param agentId
	 *            ISV调用时传入，微应用agentId
	 * @return
	 * @author Houkm 2017年9月11日
	 */
	public static String getCustomSpace(String token, String domain, String agentId) {
		return Invoke.get(CSpace.Get_Custom_Space.url(), token, domain, agentId);
	}

	/**
	 * 授权用户访问企业下的自定义空间
	 * 
	 * @param token
	 * @param domain
	 *            企业调用时传入，需要为10个字节以内的字符串，仅可包含字母和数字，大小写不敏感
	 * @param agentId
	 *            ISV调用时传入，微应用agentId
	 * @param type
	 *            权限类型，目前支持上传和下载，上传请传add，下载请传download
	 * @param userId
	 *            企业用户userid
	 * @param path
	 *            授权访问的路径，如授权访问所有文件传“/”，授权访问/doc文件夹传“/doc/”
	 * @param fileids
	 *            授权访问的文件id列表，id之间用英文逗号隔开，如“fileId1,fileId2”
	 * @param duration
	 *            权限有效时间，有效范围为0~3600秒，超出此范围或不传默认为30秒
	 * @return
	 * @author Houkm 2017年9月11日
	 */
	public static String grantCustomSpace(String token, String domain, String agentId, String type, String userId,
			String path, String fileids, int duration) {
		try {
			path = URLEncoder.encode(path, "UTF-8");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		return Invoke.get(CSpace.Grant_Custom_Space.url(), token, domain, agentId, type, userId, path, fileids,
				String.valueOf(duration));
	}

	/**
	 * 单步上传文件到钉盘 同步
	 * 
	 * @param token
	 * @param agentId
	 * @param path
	 * @return
	 * @author Houkm 2017年9月11日
	 */
	public static String upload(String token, String agentId, String path) {
		File file = new File(path);
		long size = file.length();
		return (String) HttpClient.upload(MessageFormat.format(CSpace.Upload.url(), token, agentId, size), file,
				Response_Type.String);
	}

	/**
	 * 单步上传文件到钉盘 异步
	 * 
	 * @param token
	 * @param agentId
	 * @param path
	 * @param callback
	 * @author Houkm 2017年9月11日
	 */
	public static void upload(String token, String agentId, String path, Callback callback) {
		File file = new File(path);
		long size = file.length();
		HttpClient.upload(MessageFormat.format(CSpace.Upload.url(), token, agentId, String.valueOf(size)), file,
				callback);
	}

}
