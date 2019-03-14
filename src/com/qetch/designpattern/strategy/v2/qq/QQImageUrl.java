package com.qetch.designpattern.strategy.v2.qq;

import com.qetch.designpattern.strategy.v2.BundleUtil;
import com.qetch.designpattern.strategy.v2.interfaces.ShareImageUrl;

/**
 * QQ分享缩略图
 * @author ZCW
 *
 */
public class QQImageUrl implements ShareImageUrl {

	@Override
	public String shareImageUrl(String platform) {
		return BundleUtil.getResult("share.qq.image.url." + platform);
	}
}
