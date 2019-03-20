package com.qetch.funning.xml2bean;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "ResponseInfo")
public class ResponseInfo {
	private String ApplicationId;
	private String SolutionSetInstanceId;
	private String CurrentQueue;
	@XmlElement(name="ApplicationId")
	public String getApplicationId() {
		return ApplicationId;
	}
	public void setApplicationId(String applicationId) {
		ApplicationId = applicationId;
	}
	@XmlElement(name="SolutionSetInstanceId")
	public String getSolutionSetInstanceId() {
		return SolutionSetInstanceId;
	}
	public void setSolutionSetInstanceId(String solutionSetInstanceId) {
		SolutionSetInstanceId = solutionSetInstanceId;
	}
	@XmlElement(name="CurrentQueue")
	public String getCurrentQueue() {
		return CurrentQueue;
	}
	public void setCurrentQueue(String currentQueue) {
		CurrentQueue = currentQueue;
	}
	@Override
	public String toString() {
		return "ResponseInfo [ApplicationId=" + ApplicationId
				+ ", SolutionSetInstanceId=" + SolutionSetInstanceId
				+ ", CurrentQueue=" + CurrentQueue + "]";
	}
}
