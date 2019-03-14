package com.qetch.designpattern.strategy.v2.qq;

import com.qetch.designpattern.strategy.v2.BundleUtil;
import com.qetch.designpattern.strategy.v2.interfaces.ShareTitle;

/**
 * QQ分享标题
 * @author ZCW
 *
 */
public class QQTitle implements ShareTitle {

	@Override
	public String showTitle() {
		return BundleUtil.getResult("share.qq.title");
	}
}
