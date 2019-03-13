package com.qetch.designpattern.strategy.v2;

/**
 * 微信标题
 * @ClassName: WechatTitle
 * @Description: TODO(这里用一句话描述这个类的作用)
 * @author zcw
 * @date: 2019年3月14日 上午12:38:21
 */
public class WechatTitle implements ShareTitle {

	@Override
	public String showTitle() {
		return BundleUtil.getResult("share.wechat.title");
	}
}
