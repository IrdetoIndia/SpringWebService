package com.irdeto.rrmproxy;

import java.io.IOException;
import java.io.StringWriter;
import java.net.URI;
import java.net.URISyntaxException;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;

import org.apache.http.HttpEntity;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;

import com.irdeto.rrmproxy.pojo.AuthorizationList;

public class Utility {

	public static boolean getAuthorizeResponse(String username, String password, String entity) throws URISyntaxException, ClientProtocolException, IOException {
		
		URI uri = new URIBuilder()
		        .setScheme("https")
		        .setHost("tatasky.stage.ott.irdeto.com")
		        .setPath("/services/Authorize")
		        .setParameter("CrmId", "tatasky")
		        .setParameter("UserId", "TEST")
		        .build();
		HttpPost httppost = new HttpPost(uri);
		httppost.addHeader("man-user-id", username);
		httppost.addHeader("man-user-password", password);
		httppost.addHeader("Content-Type", "application/xml");
		httppost.setEntity(new StringEntity(entity, "UTF-8"));
		
		CloseableHttpClient client = HttpClientBuilder.create().build();
		CloseableHttpResponse response = client.execute(httppost);
		
		return response.getStatusLine().getStatusCode() == 200 ? true : false;
	}
	
	public static String AuthorizeXmlData(AuthorizationList list) throws JAXBException {
		JAXBContext contextObj = JAXBContext.newInstance(AuthorizationList.class);
		Marshaller marshallerObj = contextObj.createMarshaller();  
		marshallerObj.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);  
		StringWriter stringWriter = new StringWriter();
		marshallerObj.marshal(list, stringWriter);
		return stringWriter.toString();
	}
	
	public static boolean response(String username, String password, AuthorizationList list) throws JAXBException, ClientProtocolException, URISyntaxException, IOException {
		String data = AuthorizeXmlData(list);
		return getAuthorizeResponse(username, password, data);
	}

}
