package com.qetch.funning.xml2bean;

import javax.xml.bind.annotation.XmlElement;

public class DataEnvelope {
	private String ExternalApplicationId;
	@XmlElement(name="ExternalApplicationId")
	public String getExternalApplicationId() {
		return ExternalApplicationId;
	}

	public void setExternalApplicationId(String externalApplicationId) {
		ExternalApplicationId = externalApplicationId;
	}

	@Override
	public String toString() {
		return "DataEnvelope [ExternalApplicationId=" + ExternalApplicationId
				+ "]";
	}
}
