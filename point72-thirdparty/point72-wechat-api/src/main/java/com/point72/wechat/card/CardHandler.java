package com.point72.wechat.card;

import java.io.File;

import com.point72.wechat.common.Invoke;
import com.point72.wechat.common.UploadHandler;

/**
 * 创建卡券接口
 * 
 * @author Houkm
 *
 *         2017年6月5日
 */
public class CardHandler {

	/**
	 * 上传卡券logo
	 * 
	 * @param token
	 * @param file
	 * @return
	 * @author Houkm 2017年6月5日
	 */
	public static String uploadLogo(String token, File file) {
		return UploadHandler.uploadLogo(token, file);
	}

	/**
	 * 创建团购券
	 * 
	 * @param token
	 * @param card
	 * @return
	 * @author Houkm 2017年6月5日
	 */
	public static String createGroupon(String token, GrouponCard card) {
		return create(token, card.json());
	}

	/**
	 * 创建代金券
	 * 
	 * @param token
	 * @param card
	 * @return
	 * @author Houkm 2017年6月5日
	 */
	public static String createCash(String token, CashCard card) {
		return create(token, card.json());
	}

	/**
	 * 创建折扣券
	 * 
	 * @param token
	 * @param card
	 * @return
	 * @author Houkm 2017年6月5日
	 */
	public static String createDisCount(String token, DisCountCard card) {
		return create(token, card.json());
	}

	/**
	 * 创建兑换券
	 * 
	 * @param token
	 * @param card
	 * @return
	 * @author Houkm 2017年6月5日
	 */
	public static String createGift(String token, GiftCard card) {
		return create(token, card.json());
	}

	/**
	 * 创建优惠券
	 * 
	 * @param token
	 * @param card
	 * @return
	 * @author Houkm 2017年6月5日
	 */
	public static String createGeneralCoupon(String token, GeneralCouponCard card) {
		return create(token, card.json());
	}

	private static String create(String token, String json) {
		return Invoke.post("https://api.weixin.qq.com/card/create?access_token={0}", json, token);
	}

}
