package com.qetch.designpattern.strategy.v2.qq;

import com.qetch.designpattern.strategy.v2.BundleUtil;
import com.qetch.designpattern.strategy.v2.interfaces.ShareContent;

/**
 * QQ分享内容
 * @author ZCW
 *
 */
public class QQContent implements ShareContent {

	@Override
	public String shareContent() {
		return BundleUtil.getResult("share.qq.content");
	}
}
