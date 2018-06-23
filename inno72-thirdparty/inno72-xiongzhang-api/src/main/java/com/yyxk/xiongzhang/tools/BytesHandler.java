package com.inno72.xiongzhang.tools;

import java.util.Formatter;

public class BytesHandler {

	public static String byteArrayToHex(byte[] hash) {

		Formatter formatter = new Formatter();
		for (byte b : hash) {
			formatter.format("%02x", b);
		}
		String result = formatter.toString();
		formatter.close();
		return result;
	}

}
