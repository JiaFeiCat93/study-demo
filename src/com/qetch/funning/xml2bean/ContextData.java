package com.qetch.funning.xml2bean;

import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElements;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "ContextData")
public class ContextData {
	private List<Field> Field;

	@XmlElements(@XmlElement(name = "Field", type = Field.class))
	public List<Field> getField() {
		return Field;
	}

	public void setField(List<Field> field) {
		Field = field;
	}

	@Override
	public String toString() {
		return "ContextData [Field=" + Field + "]";
	}
}
