package com.qetch.designpattern.strategy.v2;

public class ShareContext {
	protected ShareTitle shareTitle;
	protected ShareContent shareContent;
	protected ShareImageUrl shareImageUrl;
	protected ShareLink shareLink;
	
	public static ShareContext getShareTarget(Integer type) {
		String className = BundleUtil.getResult(type.toString());
		System.out.println(className);
		Class clazz;
		try {
			clazz = Class.forName(className);
			return (ShareContext) clazz.newInstance();
		} catch (ClassNotFoundException | InstantiationException | IllegalAccessException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public final String showTitle() {
		return shareTitle.showTitle();
	}
	
	public final String showContent() {
		return shareContent.shareContent();
	}
	
	public final String displayImageUrl(final String platform) {
		return shareImageUrl.shareImageUrl(platform);
	}
	
	public final String displayLink(final String platform, final String userToken) {
		return shareLink.getShareLink(platform, userToken);
	}
	
	public static ShareInfo getShareInfo(ShareContext context, String platform, String userToken) {
		ShareInfo shareInfo = new ShareInfo();
		shareInfo.setTitle(context.showTitle());
		shareInfo.setContent(context.showContent());
		shareInfo.setImageUrl(context.displayImageUrl(platform));
		shareInfo.setLink(context.displayLink(platform, userToken));
		return shareInfo;
	}
}
