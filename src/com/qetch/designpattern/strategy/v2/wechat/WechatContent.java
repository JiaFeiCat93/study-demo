package com.qetch.designpattern.strategy.v2.wechat;

import com.qetch.designpattern.strategy.v2.BundleUtil;
import com.qetch.designpattern.strategy.v2.interfaces.ShareContent;

/**
 * 微信分享内容
 * @ClassName: WechatContent
 * @Description: TODO(这里用一句话描述这个类的作用)
 * @author zcw
 * @date: 2019年3月14日 上午12:39:14
 */
public class WechatContent implements ShareContent {

	@Override
	public String shareContent() {
		return BundleUtil.getResult("share.wechat.content");
	}
}
