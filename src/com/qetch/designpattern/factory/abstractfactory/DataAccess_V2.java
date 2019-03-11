package com.qetch.designpattern.factory.abstractfactory;

public class DataAccess_V2 {
//	private static String DB = "Access";
	private static String DB = "SqlServer";
	private static String PACKAGE_NAME = "com.qetch.designpattern.factory.abstractfactory.";
	
	public static UserOperation createUser() throws InstantiationException, IllegalAccessException, ClassNotFoundException {
		UserOperation operation = null;
		operation = (UserOperation) Class.forName(PACKAGE_NAME + DB + "User").newInstance();
		return operation;
	}
	
	public static DepartmentOperation createDepartment() throws InstantiationException, IllegalAccessException, ClassNotFoundException {
		DepartmentOperation operation = null;
		operation = (DepartmentOperation) Class.forName(PACKAGE_NAME + DB + "Department").newInstance();
		return operation;
	}
}
