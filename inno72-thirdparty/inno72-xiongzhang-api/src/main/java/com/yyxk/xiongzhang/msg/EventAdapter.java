package com.inno72.xiongzhang.msg;

import com.alibaba.fastjson.JSONObject;

/**
 * 事件消息处理适配器
 * 
 * @author Houkm
 *
 *         2018年4月3日
 */
public interface EventAdapter {

	String process(JSONObject jsonObj);

}
