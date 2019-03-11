package com.qetch.designpattern.factory.abstractfactory;

/**
 * 部门接口——抽象产品B
 * @author ZCW
 *
 */
public interface DepartmentOperation {
	
	void saveDepartment(Department department);
	
	Department getDepartment(int id);
}
