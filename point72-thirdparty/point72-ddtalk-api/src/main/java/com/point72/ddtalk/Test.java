package com.point72.ddtalk;

import com.point72.ddtalk.robot.At;
import com.point72.ddtalk.robot.MarkdownMessageModel;
import com.point72.ddtalk.robot.RobotHandler;

public class Test {

	public static void main(String[] args) {
		At at = new At(null, true);
		at.add("18601968249");
		MarkdownMessageModel m = new MarkdownMessageModel("aaa",
				"#### 杭州天气 @156xxxx8827\n> 9度，西北风1级，空气良89，相对温度73%\n\n> ![screenshot](http://erp.pinwheelmedical.com/images/logo.png)\n> ###### 10点20分发布 [天气](http://www.thinkpage.cn/) \n",
				at);
		RobotHandler.sendMarkdown("8e1a7ceff7eb048b127277394e28a32034fd59c59415444173e5c00b77221750", m);
	}

}
