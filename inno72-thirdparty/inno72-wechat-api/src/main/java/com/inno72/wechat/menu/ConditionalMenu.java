package com.inno72.wechat.menu;

import lombok.Data;

@Data
public class ConditionalMenu extends Menu {

	private MatchRule matchrule;

	public static class Builder {
		private Builder() {
		}

		public static Builder builder() {
			Builder builder = new Builder();
			builder.rule = new MatchRule();
			return builder;
		}

		private MatchRule rule;

		public Builder setTag(String tagId) {
			rule.setTag_id(tagId);
			return this;
		}

		public Builder onlyMale() {
			rule.setSex("1");
			return this;
		}

		public Builder onlyFmale() {
			rule.setSex("2");
			return this;
		}

		public Builder onlyIOS() {
			rule.setClient_platform_type("1");
			return this;
		}

		public Builder onlyAndroid() {
			rule.setClient_platform_type("2");
			return this;
		}

		public Builder notIOSAndAndroid() {
			rule.setClient_platform_type("3");
			return this;
		}

		public Builder setCountry(String country) {
			rule.setCountry(country);
			return this;
		}

		public Builder setCity(String city) {
			rule.setCity(city);
			return this;
		}

		public Builder setLanguage(String language) {
			rule.setLanguage(language);
			return this;
		}

		public ConditionalMenu build() {
			ConditionalMenu menu = new ConditionalMenu();
			menu.setMatchrule(rule);
			return menu;
		}
	}

	@Data
	private static class MatchRule {
		private String tag_id;
		private String sex;
		private String country;
		private String province;
		private String city;
		private String client_platform_type;
		private String language;
	}

}
