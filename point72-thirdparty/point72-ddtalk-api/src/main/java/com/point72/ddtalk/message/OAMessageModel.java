package com.point72.ddtalk.message;

import java.util.ArrayList;
import java.util.List;

import com.point72.ddtalk.MessageType;

import lombok.Data;

/**
 * OA消息对象 <br>
 * 
 * {@code 
		OAMessageModel model = OAMessageModel.Builder.builder()
			.addForm("姓名:", "张三")
			.addForm("年龄:", "25")
			.messageUrl("http://dingtalk.com")
			.headBgcolor("#FFFFFF")
			.headText("头部标题")
			.bodyTitle("正文标题")
			.bodyContent("大段文本大段文本大段文本大段文本大段文本大段文本大段文本大段文本大段文本大段文本大段文本大段文本")
			.bodyImage("@lADOADmaWMzazQKA")
			.bodyFileCount("10")
			.bodyAuthor("侯克冕")
			.richNum("1509")
			.richUnit("天")
			.build();
		}
 * 
 * @author Houkm
 *
 *         2017年9月8日
 */
public class OAMessageModel extends AbstractMessageModel {

	private OAMessageModel() {
		super(MessageType.oa);
	}

	private OA oa;

	public OA getOa() {
		return oa;
	}

	public static class Builder {

		private OA oa;

		private OAMessageModel model = new OAMessageModel();

		public static Builder builder() {
			Builder builder = new Builder();
			builder.oa = builder.model.new OA();
			builder.model.oa = builder.oa;
			return builder;
		}

		public OAMessageModel build() {
			return this.model;
		}

		public Builder messageUrl(String messageUrl) {
			oa.message_url = messageUrl;
			return this;
		}

		public Builder pcMessageUrl(String pcMessageUrl) {
			oa.pc_message_url = pcMessageUrl;
			return this;
		}

		public Builder headBgcolor(String bgcolor) {
			oa.head.bgcolor = bgcolor;
			return this;
		}

		public Builder headText(String text) {
			oa.head.text = text;
			return this;
		}

		public Builder bodyTitle(String title) {
			oa.body.title = title;
			return this;
		}

		public Builder bodyContent(String content) {
			oa.body.content = content;
			return this;
		}

		public Builder bodyImage(String image) {
			oa.body.image = image;
			return this;
		}

		public Builder bodyFileCount(String fileCount) {
			oa.body.file_count = fileCount;
			return this;
		}

		public Builder bodyAuthor(String author) {
			oa.body.author = author;
			return this;
		}

		public Builder addForm(String formKey, String formValue) {
			oa.body.form.add(oa.body.new Form(formKey, formValue));
			return this;
		}

		public Builder richNum(String num) {
			oa.body.rich.num = num;
			return this;
		}

		public Builder richUnit(String unit) {
			oa.body.rich.unit = unit;
			return this;
		}

	}

	@Data
	private class OA {
		private String message_url;
		private String pc_message_url;
		private Head head = new Head();
		private Body body = new Body();

		@Data
		private class Head {
			private String bgcolor;
			private String text;
		}

		@Data
		private class Body {
			private String title;
			private Rich rich = new Rich();
			private List<Form> form = new ArrayList<>();
			private String content;
			private String image;
			private String file_count;
			private String author;

			@Data
			private class Rich {
				private String num;
				private String unit;
			}

			@Data
			private class Form {
				private String key;
				private String value;

				public Form(String key, String value) {
					this.key = key;
					this.value = value;
				}
			}
		}

	}
}
