package com.inno72.wechat.event;

public enum Event {
	subscribe, unsubscribe, SCAN, LOCATION, CLICK, VIEW,

	/**
	 * 推送群发结果
	 */
	MASSSENDJOBFINISH,

	/**
	 * 模版消息发送任务完成
	 */
	TEMPLATESENDJOBFINISH,

	/**
	 * 扫码事件推送
	 */
	scancode_push,

	/**
	 * 扫码推事件且弹出“消息接收中”提示框的事件推送
	 */
	scancode_waitmsg,

	/**
	 * 弹出系统拍照发图的事件推送
	 */
	pic_sysphoto,

	/**
	 * 弹出拍照或者相册发图的事件推送
	 */
	pic_photo_or_album,

	/**
	 * 弹出微信相册发图器的事件推送
	 */
	pic_weixin,

	/**
	 * 弹出地理位置选择器的事件推送
	 */
	location_select,

	/**
	 * 资质认证成功（此时立即获得接口权限）
	 */
	qualification_verify_success,

	/**
	 * 资质认证失败
	 */
	qualification_verify_fail,

	/**
	 * 名称认证成功（即命名成功）
	 */
	naming_verify_success,

	/**
	 * 名称认证失败（这时虽然客户端不打勾，但仍有接口权限）
	 */
	naming_verify_fail,

	/**
	 * 年审通知
	 */
	annual_renew,

	/**
	 * 认证过期失效通知
	 */
	verify_expired

	;
}
