package com.qetch.designpattern.strategy.v2.qq;

import com.qetch.designpattern.strategy.v2.ShareContext;

public class QQShare extends ShareContext {
	
	public QQShare() {
		super.shareTitle = new QQTitle();
		super.shareContent = new QQContent();
		super.shareImageUrl = new QQImageUrl();
		super.shareLink = new QQLink();
	}
}
