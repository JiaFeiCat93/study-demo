package com.qetch.designpattern.factory.abstractfactory;

/**
 * 具体产品类B
 * @author ZCW
 *
 */
public class AccessDepartment implements DepartmentOperation {

	@Override
	public void saveDepartment(Department department) {
		System.out.println("Access中给Department表添加一条记录");
	}

	@Override
	public Department getDepartment(int id) {
		System.out.println("Access中根据id得到Department表中的一条记录");
		return null;
	}

}
