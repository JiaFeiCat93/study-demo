package com.qetch.designpattern.strategy.v2.qq;

import com.qetch.designpattern.strategy.v2.BundleUtil;
import com.qetch.designpattern.strategy.v2.interfaces.ShareLink;

public class QQLink implements ShareLink {

	@Override
	public String getShareLink(String platform, String userToken) {
		return BundleUtil.getResult("share.qq.link." + platform) + userToken;
	}
}
