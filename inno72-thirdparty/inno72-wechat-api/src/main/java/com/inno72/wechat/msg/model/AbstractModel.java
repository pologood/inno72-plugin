package com.inno72.wechat.msg.model;

import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.List;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;

public abstract class AbstractModel {

	@SuppressWarnings("unchecked")
	public void toModel(String xml) {
		Document document = null;
		Class<?> clazz = this.getClass();
		try {
			document = DocumentHelper.parseText(xml);
		} catch (DocumentException e) {
			e.printStackTrace();
		}

		Element root = document.getRootElement();
		List<Element> list = root.elements();
		list.forEach(e -> {
			String name = e.getName();
			try {
				Field field = clazz.getField(name);
				if (field != null) {
					field.set(this, e.getText());
				}
			} catch (Exception e1) {
				e1.printStackTrace();
			}
		});
	}

	@SuppressWarnings("unchecked")
	public void toModel(Document document) {
		Class<?> clazz = this.getClass();

		Element root = document.getRootElement();
		List<Element> list = root.elements();
		list.forEach(e -> {
			String name = e.getName();
			try {
				Field field = clazz.getField(name);
				if (field != null) {
					field.set(this, e.getText());
				}
			} catch (Exception e1) {
				e1.printStackTrace();
			}
		});
	}

	public String toXml() {

		Document document = DocumentHelper.createDocument();
		Element root = DocumentHelper.createElement("xml");
		document.setRootElement(root);
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

		return document.asXML();

	}

	public AbstractModel() {
		setMsgType();
	}

	public String ToUserName;
	public String FromUserName;
	public String CreateTime;
	public String MsgType;

	public String getToUserName() {
		return ToUserName;
	}

	public void setToUserName(String toUserName) {
		ToUserName = toUserName;
	}

	public String getFromUserName() {
		return FromUserName;
	}

	public void setFromUserName(String fromUserName) {
		FromUserName = fromUserName;
	}

	public String getCreateTime() {
		return CreateTime;
	}

	public void setCreateTime(String createTime) {
		CreateTime = createTime;
	}

	public String getMsgType() {
		return MsgType;
	}

	protected abstract void setMsgType();

}
