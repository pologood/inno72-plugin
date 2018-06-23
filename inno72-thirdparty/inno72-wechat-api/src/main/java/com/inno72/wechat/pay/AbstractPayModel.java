package com.inno72.wechat.pay;

import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.inno72.wechat.tools.SignHelper;

public abstract class AbstractPayModel {

	private Logger logger = LoggerFactory.getLogger(AbstractPayModel.class);

	public AbstractPayModel() {
	}

	public AbstractPayModel(Document doc, String keycode) {
		toModel(doc);
	}

	public boolean success() {
		Class<?> cls = this.getClass();
		try {
			Field returnCode = cls.getField("return_code");
			if (returnCode == null) {
				logger.error("{}不支持的类型", cls.getClass().getName());
			} else {
				Object returnCodeObj = returnCode.get(this);
				if (returnCodeObj != null && returnCodeObj.toString().equals("SUCCESS")) {
					Field resultCode = cls.getField("result_code");
					if (resultCode == null) {
						logger.error("{}不支持的类型", cls.getClass().getName());
					}
					Object resultCodeObj = resultCode.get(this);
					if (resultCodeObj != null && resultCodeObj.toString().equals("SUCCESS")) {
						return true;
					} else {
						return false;
					}
				} else {
					return false;
				}
			}
		} catch (NoSuchFieldException | SecurityException | IllegalArgumentException | IllegalAccessException e) {
			e.printStackTrace();
		}
		return false;
	}

	public String toXml(String keycode) {
		logger.info("将{}转换为xml", this.getClass().getName());
		String sign = sign(keycode);
		try {
			Field signField = this.getClass().getField("sign");
			if (signField != null) {
				signField.set(this, sign);
			}
		} catch (NoSuchFieldException | SecurityException | IllegalArgumentException | IllegalAccessException e1) {
			e1.printStackTrace();
		}

		Document doc = DocumentHelper.createDocument();

		Element root = DocumentHelper.createElement("xml");

		doc.setRootElement(root);

		Field[] fs = this.getClass().getFields();
		Arrays.asList(fs).forEach(f -> {
			String k = f.getName();
			try {

				Object obj = f.get(this);

				if (obj != null) {
					String v = String.valueOf(obj);

					root.addElement(k).addText(v);
				}
			} catch (Exception e) {
				e.printStackTrace();
			}

		});
		String xml = doc.asXML();
		logger.info("xml转换结果: {}", xml);
		return xml;
	}

	public void toModel(String xml) {
		try {
			Document doc = DocumentHelper.parseText(xml);
			toModel(doc);
		} catch (DocumentException e) {
			e.printStackTrace();
		}
	}

	public void toModel(Document doc) {
		Class<?> cls = this.getClass();

		Element root = doc.getRootElement();

		@SuppressWarnings("unchecked")
		List<Element> list = root.elements();
		list.forEach(e -> {
			String name = e.getName();
			try {
				String v = new String(e.getText());
				cls.getField(name).set(this, v);
			} catch (Exception e1) {
				e1.printStackTrace();
			}
		});
	}

	protected String sign(String keycode) {

		Map<String, String> map = new TreeMap<>();
		Class<?> cls = this.getClass();
		Arrays.asList(cls.getDeclaredFields()).forEach(f -> {
			String k = f.getName();

			try {
				Object obj = f.get(this);

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

		sign = SignHelper.MD5(sign);

		return sign.toUpperCase();
	}

	/**
	 * 检查参数签名是否正确
	 * 
	 * @param keycode
	 * @return
	 * @author Houkm 2017年9月6日
	 */
	public boolean checkSign(String keycode) {
		Map<String, String> map = new TreeMap<>();
		Class<?> cls = this.getClass();
		Arrays.asList(cls.getDeclaredFields()).forEach(f -> {
			String k = f.getName();
			if (k.equals("sign")) {
				return;
			}
			try {
				Object obj = f.get(this);

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

		sign = SignHelper.MD5(sign);

		boolean legle = false;

		try {
			Field sf = cls.getDeclaredField("sign");
			if (sf != null) {
				Object outSignObj = sf.get(this);
				if (outSignObj != null) {
					if (outSignObj.toString().equals(sign.toUpperCase())) {
						legle = true;
					} else {
						legle = false;
					}
				} else {
					legle = false;
				}
			} else {
				legle = true;
			}
		} catch (NoSuchFieldException | SecurityException | IllegalArgumentException | IllegalAccessException e) {
			e.printStackTrace();
		}

		return legle;
	}

}
