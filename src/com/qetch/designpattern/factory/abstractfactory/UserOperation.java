package com.qetch.designpattern.factory.abstractfactory;

/**
 * 用户接口——抽象产品A
 * @author ZCW
 *
 */
public interface UserOperation {
	
	void saveUser(User user);
	
	User getUser(int id);
}
