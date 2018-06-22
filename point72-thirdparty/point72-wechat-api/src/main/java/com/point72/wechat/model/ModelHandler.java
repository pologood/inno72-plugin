package com.point72.wechat.model;

import java.io.UnsupportedEncodingException;
import java.lang.reflect.Field;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;

import com.point72.wechat.tools.BytesHandler;

public class ModelHandler<T> {
	public static String getMsgType(String xml) {
		String msgType = null;
		try {
			Document doc = DocumentHelper.parseText(xml);
			Element root = doc.getRootElement();
			msgType = root.elementText("MsgType");
		} catch (DocumentException e) {
			e.printStackTrace();
		}
		return msgType;
	}

	public static String getEventType(String xml) {
		String event = null;
		try {
			Document doc = DocumentHelper.parseText(xml);
			Element root = doc.getRootElement();
			event = root.elementText("Event");
		} catch (DocumentException e) {
			e.printStackTrace();
		}
		return event;
	}

	public String sign(Class<T> cls, T model, String keycode) {

		Map<String, String> map = new TreeMap<>();

		Arrays.asList(cls.getDeclaredFields()).forEach(f -> {
			String k = f.getName();

			try {
				Object obj = f.get(model);

				if (obj != null) {
					String v = String.valueOf(obj);
					map.put(k, v);
				}

			} catch (Exception e) {
				e.printStackTrace();
			}

		});

		StringBuffer sb = new StringBuffer();

		map.forEach((k, v) -> {
			sb.append(k).append("=").append(v).append("&");
		});

		sb.append("key=").append(keycode);

		String sign = sb.toString();

		System.out.println(sign);

		try {
			MessageDigest digest = MessageDigest.getInstance("MD5");
			digest.reset();
			digest.update(sign.getBytes("UTF-8"));
			sign = BytesHandler.byteArrayToHex(digest.digest());
		} catch (NoSuchAlgorithmException | UnsupportedEncodingException e) {
			e.printStackTrace();
		}

		return sign.toUpperCase();
	}

	public String toxml(Class<T> cls, T model) {

		Document doc = DocumentHelper.createDocument();

		Element root = DocumentHelper.createElement("xml");

		doc.setRootElement(root);

		Field[] fs = cls.getFields();
		Arrays.asList(fs).forEach(f -> {
			String k = f.getName();
			try {

				Object obj = f.get(model);

				if (obj != null) {
					String v = String.valueOf(obj);

					root.addElement(k).addText(v);
				}
			} catch (Exception e) {
				e.printStackTrace();
			}

		});

		return doc.asXML();
	}

	public T toModel(Class<T> cls, String xml, T model) {

		try {
			Document doc = DocumentHelper.parseText(xml);
			Element root = doc.getRootElement();

			@SuppressWarnings("unchecked")
			List<Element> list = root.elements();
			list.forEach(e -> {
				String name = e.getName();
				try {
					String v = new String(e.getText().getBytes("ISO-8859-1"), "UTF-8");
					cls.getField(name).set(model, v);
				} catch (Exception e1) {
					e1.printStackTrace();
				}
			});

		} catch (DocumentException e) {
			e.printStackTrace();
		}

		return model;
	}

}
