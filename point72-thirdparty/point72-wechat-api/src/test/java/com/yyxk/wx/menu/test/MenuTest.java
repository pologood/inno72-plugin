package com.point72.wx.menu.test;

import org.junit.Test;

import com.point72.wechat.menu.ClickButton;
import com.point72.wechat.menu.Menu;
import com.point72.wechat.menu.SubButton;
import com.point72.wechat.menu.ViewButton;

public class MenuTest {

	@Test
	public void menu() {
		ClickButton left = new ClickButton();
		left.setKey("aaa");
		left.setName("left");

		ViewButton middle = new ViewButton();
		middle.setUrl("http://www.baidu.com");
		middle.setName("middle");

		SubButton right = new SubButton();
		right.setName("right");

		ViewButton sub1 = new ViewButton();
		sub1.setUrl("http://www.baidu.com");
		sub1.setName("sub1");

		ClickButton sub2 = new ClickButton();
		sub2.setKey("aaa");
		sub2.setName("left");

		right.add(sub1);
		right.add(sub2);

		Menu menu = new Menu();
		menu.left(left);
		menu.middle(middle);
		menu.right(right);

		System.out.println(menu.json());

	}

}
