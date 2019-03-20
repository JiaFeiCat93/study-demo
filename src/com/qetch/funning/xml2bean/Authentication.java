package com.qetch.funning.xml2bean;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "Authentication")
public class Authentication {
	private String Status;
	private String Token;
	@XmlElement(name="Status")
	public String getStatus() {
		return Status;
	}
	public void setStatus(String status) {
		Status = status;
	}
	@XmlElement(name="Token")
	public String getToken() {
		return Token;
	}
	public void setToken(String token) {
		Token = token;
	}
	@Override
	public String toString() {
		return "Authentication [Status=" + Status + ", Token=" + Token + "]";
	}
}
