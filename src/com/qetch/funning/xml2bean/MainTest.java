package com.qetch.funning.xml2bean;

import java.io.IOException;

import javax.xml.bind.JAXBException;

import org.junit.Test;

public class MainTest {
	
	@Test
	public void xml2Bean() throws JAXBException, IOException {
		String xmlString = "<?xml version=\"1.0\"?>"
						+ "<DCResponse>"
						+ "    <Status>Success</Status>"
						+ "    <Authentication>"
						+ "        <Status>Success</Status>"
						+ "        <Token>a4e89acd-40a9-45f9-989d-07c59df163f8</Token>"
						+ "    </Authentication>"
						+ "    <ResponseInfo>"
						+ "        <ApplicationId>1126167</ApplicationId>"
						+ "        <SolutionSetInstanceId>fa1924e3-5509-40a6-a4f4-5e17390924d4</SolutionSetInstanceId>"
						+ "        <CurrentQueue>DocUpload_Queue</CurrentQueue>"
						+ "    </ResponseInfo>"
						+ "    <ContextData>"
						+ "        <Field key=\"DataEnvelope\">"
						+ "            <DataEnvelope>"
						+ "                <ExternalApplicationId>d1b7fd0d8f9b239f</ExternalApplicationId>"
						+ "            </DataEnvelope>"
						+ "        </Field>"
						+ "        <Field key=\"ReturnStatus\">Success</Field>"
						+ "        <Field key=\"ReturnMessage\"></Field>"
						+ "    </ContextData>"
						+ "</DCResponse> ";
		Object bean = XMLBeanUtil.XML2Bean(xmlString, DCResponse.class);
		DCResponse dcResponse = (DCResponse) bean;
		System.out.println(dcResponse.toString());
	}
}
