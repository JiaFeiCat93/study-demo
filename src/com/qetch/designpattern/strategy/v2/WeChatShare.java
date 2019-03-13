package com.qetch.designpattern.strategy.v2;

public class WeChatShare extends ShareContext {

	public WeChatShare() {
		super.shareTitle = new WechatTitle();
		super.shareContent = new WechatContent();
		super.shareImageUrl = new WechatImageUrl();
		super.shareLink = new WeChatLink();
	}
}
