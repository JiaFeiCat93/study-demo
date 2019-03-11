package com.qetch.designpattern.factory.abstractfactory;

/**
 * 测试类
 * @author ZCW
 *
 */
public class AbstractFactoryMainTest {

	public static void main(String[] args) {
//		Factory factory = new AccessFactory();
		Factory factory = new SqlServerFactory();
		UserOperation createUser = factory.createUser();
		User user = new User();
		createUser.saveUser(user);
		createUser.getUser(1);
		
		DepartmentOperation createDepartment = factory.createDepartment();
		Department department = new Department();
		createDepartment.saveDepartment(department);
		createDepartment.getDepartment(1);
	}
}
