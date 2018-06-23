package com.inno72.ddtalk.chat.model;

public class ImageMsgModel extends AbstractModel {

	private Image image;

	@Override
	public void setMsgtype() {
		super.msgtype = "image";
	}

	public ImageMsgModel(String mediaId, String chatid) {
		super();
		setChatid(chatid);
		this.image = this.new Image(mediaId);
	}

	public Image getImage() {
		return image;
	}

	public void setImage(Image image) {
		this.image = image;
	}

	class Image {
		private String media_id;

		Image(String media_id) {
			this.media_id = media_id;
		}

		public String getMedia_id() {
			return media_id;
		}

		public void setMedia_id(String media_id) {
			this.media_id = media_id;
		}

	}

}
