package com.qetch.designpattern.factory.abstractfactory;

public enum DBTypeEnum {
	ACCESS("Access", "Access数据库"),
	SQLSERVER("SqlServer", "SqlServer数据库");
	
	private DBTypeEnum(String type, String description) {
		this.description = description;
		this.type = type;
	}
	
	private String type;
	private String description;
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	
	public static DBTypeEnum getByType(String type) {
		for (DBTypeEnum db : values()) {
			if (db.getType().equals(type)) {
				return db;
			}
		}
		return null;
	}
}
