package com.point72.wechat.msg.model.reply;

import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.List;

import org.dom4j.Document;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;

import com.point72.wechat.msg.model.AbstractModel;

/**
 * 回复图文消息
 * 
 * @author Houkm
 *
 *         2017年6月2日
 */
public class NewsMsgModel extends AbstractModel {

	@Override
	public String toXml() {
		Document document = DocumentHelper.createDocument();
		Element root = DocumentHelper.createElement("xml");
		document.setRootElement(root);
		Field[] fs = this.getClass().getFields();
		Arrays.asList(fs).forEach(f -> {
			String k = f.getName();
			if (k.equals("Articles")) {
				return;
			}
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
		Element articles = root.addElement("Articles");
		if (Articles != null && Articles.size() > 0) {
			Articles.forEach(article -> {
				Element item = articles.addElement("Item");
				Field[] articleField = Item.class.getFields();

				Arrays.asList(articleField).forEach(f -> {
					String k = f.getName();
					try {

						Object obj = f.get(article);

						if (obj != null) {
							String v = String.valueOf(obj);

							item.addElement(k).addText(v);
						}
					} catch (Exception e) {
						e.printStackTrace();
					}

				});
			});
		}

		return document.asXML();
	}

	/**
	 * 图文消息个数，限制为8条以内
	 */
	public String ArticleCount;

	/**
	 * 多条图文消息信息，默认第一个item为大图,注意，如果图文数超过8，则将会无响应
	 */
	public List<Item> Articles;

	@Override
	protected void setMsgType() {
		MsgType = "news";
	}

	/**
	 * 图文消息信息
	 * 
	 * @author Houkm
	 *
	 *         2017年6月2日
	 */
	public class Item {
		public String Title;
		public String Description;
		public String PicUrl;
		public String Url;

		public String getTitle() {
			return Title;
		}

		public void setTitle(String title) {
			Title = title;
		}

		public String getDescription() {
			return Description;
		}

		public void setDescription(String description) {
			Description = description;
		}

		public String getPicUrl() {
			return PicUrl;
		}

		public void setPicUrl(String picUrl) {
			PicUrl = picUrl;
		}

		public String getUrl() {
			return Url;
		}

		public void setUrl(String url) {
			Url = url;
		}

	}

}
