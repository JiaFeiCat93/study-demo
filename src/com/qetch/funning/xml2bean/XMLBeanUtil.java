/**
 * 
 */
package com.qetch.funning.xml2bean;

import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

/**
 * @author Lijy
 */
public class XMLBeanUtil {

	public static <T> Object XML2Bean(String xml, Class<T> t) throws JAXBException, IOException {
		JAXBContext jaxbContext = JAXBContext.newInstance(t);
		Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();
		// String xmString = new String(xml.toString().getBytes("UTF-8"));
		// String xmlUTF8 = URLEncoder.encode(xmString, "UTF-8");

		BufferedReader in = new BufferedReader(new InputStreamReader(new ByteArrayInputStream(xml.getBytes())));
		// StringInputStream in= new StringInputStream(xml,"UTF8");
		// StringReader in =new StringReader(xmlUTF8);
		// Object res = unmarshaller.unmarshal(in);
		Object res = unmarshaller.unmarshal(in);
		in.close();
		return res;
	}

	public static <T> String Bean2XML(Object object, Class<T> t) throws JAXBException, IOException {
		JAXBContext jaxbContext = JAXBContext.newInstance(t);
		Marshaller marshaller = jaxbContext.createMarshaller();
		marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
		// marshaller.setProperty(Marshaller.JAXB_ENCODING, "UTF-8");
		ByteArrayOutputStream otps = new ByteArrayOutputStream();
		marshaller.marshal(object, otps);

		byte[] bystr = otps.toByteArray();
		String str = "";
		try {
			str = new String(bystr, "UTF-8");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		String resxml = new StringBuffer(
				str.replace("<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"yes\"?>", "")).toString();
		// String resxml = otps.toString();
		otps.flush();
		otps.close();
		return resxml;
	}

	public static String getElementRootName(String xmlString) {
		// 得到根节点的值
		SAXReader saxReader = new SAXReader();
		Document document = null;
		try {
			// 将String类型的字符串转换成XML文本对象
			document = saxReader.read(new ByteArrayInputStream(xmlString.getBytes()));
			// 得到根节点对象
			Element rootElements = document.getRootElement();
			// 得到根节点的节点名称
			return rootElements.getName();
		} catch (DocumentException e) {
			e.printStackTrace();
		}
		return null;
	}
}
