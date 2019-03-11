package com.qetch.designpattern.factory.simplefactory;

public enum SenderTypeEnum {
	MAIL(1, "邮件"),
	SMS(2, "短信");
	
	private SenderTypeEnum(Integer type, String description) {
		this.description = description;
		this.type = type;
	}
	
	private Integer type;
	private String description;
	public Integer getType() {
		return type;
	}
	public void setType(Integer type) {
		this.type = type;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	
	public static SenderTypeEnum getByType(int type) {
		for (SenderTypeEnum sender : values()) {
			if (sender.getType() == type) {
				return sender;
			}
		}
		return null;
	}
}
