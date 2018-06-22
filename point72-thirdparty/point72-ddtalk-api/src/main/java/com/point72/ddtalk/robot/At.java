package com.point72.ddtalk.robot;

import java.util.ArrayList;
import java.util.List;

import lombok.Data;

@Data
public class At {

	private List<String> atMobiles;
	private boolean isAtAll;

	public At(List<String> atMobiles, boolean isAtAll) {
		this.atMobiles = atMobiles;
		this.isAtAll = isAtAll;
	}

	public void add(String mobile) {
		if (this.atMobiles == null) {
			this.atMobiles = new ArrayList<>();
		}
		this.atMobiles.add(mobile);
	}

}
