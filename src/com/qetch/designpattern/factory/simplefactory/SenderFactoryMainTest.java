package com.qetch.designpattern.factory.simplefactory;

/**
 * 测试类
 * @author ZCW
 *
 */
public class SenderFactoryMainTest {

	public static void main(String[] args) {
		Sender mailSender = SenderFactory.create(SenderTypeEnum.MAIL.getType());
		Sender smsSender = SenderFactory.create(SenderTypeEnum.SMS.getType());
		mailSender.send();
		smsSender.send();
	}
}
