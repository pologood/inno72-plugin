package com.inno72.wechat.menu;

import java.util.ArrayList;
import java.util.List;

import com.inno72.wechat.common.BaseModel;

/**
 * 菜单
 * 
 * @author Houkm
 *
 *         2017年6月1日
 */
public class Menu extends BaseModel {

	// private AbstractButton[] button = new AbstractButton[3];
	private List<AbstractButton> button = new ArrayList<>();

	public void left(AbstractButton left) {
		if (button.size() < 1) {
			button.add(left);
		} else {
			button.add(0, left);
		}
	}

	public void middle(AbstractButton middle) {
		if (button.size() > 1) {
			button.add(1, middle);
		} else {
			button.add(middle);
		}
	}

	public void right(AbstractButton right) {
		button.add(right);
	}

	public AbstractButton showLeft() {
		return button.size() > 0 ? button.get(0) : null;
	}

	public AbstractButton showMiddle() {
		return button.size() > 1 ? button.get(1) : null;
	}

	public AbstractButton showRight() {
		return button.size() > 2 ? button.get(2) : null;

	}

	public List<AbstractButton> getButton() {
		return button;
	}

}
