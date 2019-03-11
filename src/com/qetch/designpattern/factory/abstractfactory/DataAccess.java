package com.qetch.designpattern.factory.abstractfactory;

/**
 * 借助简单工厂改进抽象工厂
 * @author ZCW
 *
 */
public class DataAccess {
//	private static final String DB = "Access";
	private static final String DB = "SqlServer";
	
	/**
	 * 根据db来决定实例化不同的类
	 * @return
	 */
	public static UserOperation createUser() {
		UserOperation operation = null;
		switch (DBTypeEnum.getByType(DB)) {
		case ACCESS:
			operation = new AccessUser();
			break;
		case SQLSERVER:
			operation = new SqlServerUser();
			break;
		default:
			break;
		}
		return operation;
	}
	
	public static DepartmentOperation createDepartment() {
		DepartmentOperation operation = null;
		switch (DBTypeEnum.getByType(DB)) {
		case ACCESS:
			operation = new AccessDepartment();
			break;
		case SQLSERVER:
			operation = new SqlServerDepartment();
			break;
		default:
			break;
		}
		return operation;
	}
}
