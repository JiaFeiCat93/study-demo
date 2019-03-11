package com.qetch.designpattern.factory.simplefactory;

/**
 * 具体产品类
 * @author ZCW
 *
 */
public class MailSender implements Sender {

	@Override
	public void send() {
		System.out.println("发送邮件");
	}
}
