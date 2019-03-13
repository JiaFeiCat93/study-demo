package com.qetch.designpattern.strategy.v2;

public class ShareMainTest {

	public static void main(String[] args) {
		ShareContext context = ShareContext.getShareTarget(2);
		System.out.println(context.showTitle());
		System.out.println(context.showContent());
		System.out.println(context.displayImageUrl("android"));
		System.out.println(context.displayLink("ios", "?#"));
	}
}
