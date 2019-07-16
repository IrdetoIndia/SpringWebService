package com.irdeto.rrmproxy.pojo;

import java.util.List;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "AuthorizationList")
public class AuthorizationList {

	int version;
	List<Authorization> authorization;

	@XmlAttribute(name = "Version")
	public int getVersion() {
		return version;
	}

	public void setVersion(int version) {
		this.version = version;
	}

	@XmlElement(name = "Authorization")
	public List<Authorization> getAuthorization() {
		return authorization;
	}

	public void setAuthorization(List<Authorization> authorization) {
		this.authorization = authorization;
	}
	
}
