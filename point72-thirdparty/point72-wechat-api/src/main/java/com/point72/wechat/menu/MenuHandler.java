package com.point72.wechat.menu;

import com.point72.wechat.ApiUrl;
import com.point72.wechat.common.Invoke;

/**
 * 菜单接口
 * 
 * @author Houkm
 *
 *         2017年6月5日
 */
public class MenuHandler {

	/**
	 * 创建菜单
	 * 
	 * @param token
	 * @param menu
	 * @return
	 * @author Houkm 2017年6月5日
	 */
	public static String create(String token, Menu menu) {
		String result = Invoke.post(ApiUrl.Menu.Create.url(), menu.json(), token);
		return result;
	}

	/**
	 * 查询菜单
	 * 
	 * @param token
	 * @return
	 * @author Houkm 2017年6月5日
	 */
	public static String get(String token) {
		String result = Invoke.get(ApiUrl.Menu.Get.url(), token);
		return result;
	}

	/**
	 * 设置个性化菜单
	 * 
	 * @param token
	 * @param menu
	 * @return
	 * @author Houkm 2017年9月29日
	 */
	public static String addConditional(String token, ConditionalMenu menu) {
		return Invoke.post(ApiUrl.Menu.AddConditional.url(), menu.json(), token);
	}

}
