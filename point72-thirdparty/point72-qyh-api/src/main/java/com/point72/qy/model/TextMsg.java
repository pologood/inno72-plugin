package com.point72.qy.model;

public class TextMsg {

	public String touser;
	public String toparty;
	public String totag;
	public String agentid;
	public Text text;
	public int safe;
	public String msgtype = "text";

	public class Text {
		public String content;
	}

}
