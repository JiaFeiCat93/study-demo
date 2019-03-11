package com.qetch.designpattern.factory.abstractfactory;

/**
 * SqlServer数据库访问——具体工厂2
 * @author ZCW
 *
 */
public class SqlServerFactory implements Factory {

	@Override
	public UserOperation createUser() {
		return new SqlServerUser();
	}

	@Override
	public DepartmentOperation createDepartment() {
		return new SqlServerDepartment();
	}
}
