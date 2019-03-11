package com.qetch.designpattern.factory.abstractfactory;

/**
 * Access数据库访问——具体工厂1
 * @author ZCW
 *
 */
public class AccessFactory implements Factory {

	@Override
	public UserOperation createUser() {
		return new AccessUser();
	}

	@Override
	public DepartmentOperation createDepartment() {
		return new AccessDepartment();
	}

}
