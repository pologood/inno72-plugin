package com.inno72.wechat.menu;

import java.util.ArrayList;
import java.util.List;

/**
 * 二级菜单
 * 
 * @author Houkm
 *
 *         2017年6月1日
 */
public class SubButton extends AbstractButton {

	List<AbstractButton> sub_button;

	private String name;

	/**
	 * 添加子菜单，最后添加的在最下面
	 * 
	 * @param button
	 * @author Houkm 2017年6月1日
	 */
	public void add(AbstractButton button) {
		if (sub_button == null) {
			sub_button = new ArrayList<>();
		}
		if (sub_button.size() >= 5) {
			return;
		}
		sub_button.add(button);

	}

	public List<AbstractButton> getSub_button() {
		return sub_button;
	}

	public void setSub_button(List<AbstractButton> sub_button) {
		this.sub_button = sub_button;
	}

	@Override
	public String getName() {
		return name;
	}

	@Override
	public void setName(String name) {
		this.name = name;
	}

}
