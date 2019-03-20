package com.qetch.funning.xml2bean;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "DCResponse")
public class DCResponse {
	private String Status;
	private Authentication Authentication;
	private ResponseInfo ResponseInfo;
	private ContextData ContextData;
	@XmlElement(name="Status")
	public String getStatus() {
		return Status;
	}
	public void setStatus(String status) {
		Status = status;
	}
	@XmlElement(name="Authentication", type = Authentication.class)
	public Authentication getAuthentication() {
		return Authentication;
	}
	public void setAuthentication(Authentication authentication) {
		Authentication = authentication;
	}
	@XmlElement(name="ResponseInfo", type = ResponseInfo.class)
	public ResponseInfo getResponseInfo() {
		return ResponseInfo;
	}
	public void setResponseInfo(ResponseInfo responseInfo) {
		ResponseInfo = responseInfo;
	}
	@XmlElement(name="ContextData", type = ContextData.class)
	public ContextData getContextData() {
		return ContextData;
	}
	public void setContextData(ContextData contextData) {
		ContextData = contextData;
	}
	@Override
	public String toString() {
		return "DCResponse [Status=" + Status + ", Authentication="
				+ Authentication + ", ResponseInfo=" + ResponseInfo
				+ ", ContextData=" + ContextData + "]";
	}
}
