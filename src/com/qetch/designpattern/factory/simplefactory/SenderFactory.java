package com.qetch.designpattern.factory.simplefactory;

/**
 * 工厂类
 * @author ZCW
 *
 */
public class SenderFactory {
	
	public static Sender create(int type) {
		Sender sender = null;
		switch (SenderTypeEnum.getByType(type)) {
		case MAIL:
			sender = new MailSender();
			break;
		case SMS:
			sender = new SmsSender();
			break;
		default:
			break;
		}
		return sender;
	}
}
