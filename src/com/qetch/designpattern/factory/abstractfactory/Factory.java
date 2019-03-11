package com.qetch.designpattern.factory.abstractfactory;

/**
 * 抽象工厂
 * @author ZCW
 *
 */
public interface Factory {
	
	UserOperation createUser();
	
	DepartmentOperation createDepartment();
}
