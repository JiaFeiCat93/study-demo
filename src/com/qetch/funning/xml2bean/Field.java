package com.qetch.funning.xml2bean;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "Field")
public class Field {
	private String key;
	private DataEnvelope DataEnvelope;
	public String getKey() {
		return key;
	}
	@XmlAttribute(name="key")
	public void setKey(String key) {
		this.key = key;
	}
	@XmlElement(name="DataEnvelope")
	public DataEnvelope getDataEnvelope() {
		return DataEnvelope;
	}
	public void setDataEnvelope(DataEnvelope dataEnvelope) {
		DataEnvelope = dataEnvelope;
	}
	@Override
	public String toString() {
		return "Field [key=" + key + ", DataEnvelope=" + DataEnvelope + "]";
	}
}
