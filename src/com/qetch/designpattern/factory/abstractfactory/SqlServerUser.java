package com.qetch.designpattern.factory.abstractfactory;

/**
 * 具体产品类A
 * @author ZCW
 *
 */
public class SqlServerUser implements UserOperation {

	@Override
	public void saveUser(User user) {
		System.out.println("SqlServer中给User表添加一条记录");
	}

	@Override
	public User getUser(int id) {
		System.out.println("SqlServer中根据id得到User表中的一条记录");
		return null;
	}
}
