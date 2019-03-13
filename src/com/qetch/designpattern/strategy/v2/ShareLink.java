package com.qetch.designpattern.strategy.v2;

/**
 * 分享链接
 * @ClassName: ShareLink
 * @Description: TODO(这里用一句话描述这个类的作用)
 * @author zcw
 * @date: 2019年3月14日 上午12:13:37
 */
public interface ShareLink {

	String getShareLink(final String platform, final String userToken);
}
