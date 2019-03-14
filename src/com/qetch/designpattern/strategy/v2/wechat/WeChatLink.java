package com.qetch.designpattern.strategy.v2.wechat;

import com.qetch.designpattern.strategy.v2.BundleUtil;
import com.qetch.designpattern.strategy.v2.interfaces.ShareLink;

/**
 * 微信分享链接
 * @ClassName: WeChatLink
 * @Description: TODO(这里用一句话描述这个类的作用)
 * @author zcw
 * @date: 2019年3月14日 上午12:41:53
 */
public class WeChatLink implements ShareLink {

	@Override
	public String getShareLink(String platform, String userToken) {
		return BundleUtil.getResult("share.wechat.link." + platform) + userToken;
	}
}
