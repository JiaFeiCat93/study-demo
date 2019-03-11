package com.qetch.designpattern.factory.abstractfactory;

public class AbstractFactoryMainTest_V2 {
	
	public static void main(String[] args) {
		/*UserOperation createUser = DataAccess.createUser();
		User user = new User();
		createUser.saveUser(user);
		createUser.getUser(1);
		
		DepartmentOperation createDepartment = DataAccess.createDepartment();
		Department department = new Department();
		createDepartment.saveDepartment(department);
		createDepartment.getDepartment(1);*/
		
		try {
			UserOperation createUser = DataAccess_V2.createUser();
			User user = new User();
			createUser.saveUser(user);
			createUser.getUser(1);
			
			DepartmentOperation createDepartment = DataAccess_V2.createDepartment();
			Department department = new Department();
			createDepartment.saveDepartment(department);
			createDepartment.getDepartment(1);
		} catch (InstantiationException | IllegalAccessException | ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
}
