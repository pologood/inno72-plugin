package com.inno72.ddtalk.chat.model;

public class FileMsgModel extends AbstractModel {

	private File file;

	@Override
	public void setMsgtype() {
		super.msgtype = "file";
	}

	public FileMsgModel(String mediaId, String chatid) {
		super();
		setChatid(chatid);
		this.file = this.new File(mediaId);
	}

	public File getFile() {
		return file;
	}

	public void setFile(File file) {
		this.file = file;
	}

	class File {
		private String media_id;

		File(String media_id) {
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
