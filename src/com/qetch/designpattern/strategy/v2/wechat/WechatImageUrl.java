package com.qetch.designpattern.strategy.v2.wechat;

import com.qetch.designpattern.strategy.v2.BundleUtil;
import com.qetch.designpattern.strategy.v2.interfaces.ShareImageUrl;

/**
 * 微信缩略图
 * @ClassName: WechatImageUrl
 * @Description: TODO(这里用一句话描述这个类的作用)
 * @author zcw
 * @date: 2019年3月14日 上午12:40:29
 */
public class WechatImageUrl implements ShareImageUrl {

	@Override
	public String shareImageUrl(String platform) {
		return BundleUtil.getResult("share.wechat.image.url." + platform);
	}
}
