package com.irdeto.androidtv.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="epg")
public class Epg {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="epg_id")
	private int epgId;
	
	@Column(name="title")
	private String title;

	@Column(name="service_id")
	private String serviceId;

	@Column(name="source_url")
	private String sourceUrl;
	
	@Column(name="license_url")
	private String licenseUrl;
	
	@Column(name="image_url")
	private String imageUrl;

	public int getEpgId() {
		return epgId;
	}

	public void setEpgId(int epgId) {
		this.epgId = epgId;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getSourceUrl() {
		return sourceUrl;
	}

	public void setSourceUrl(String sourceUrl) {
		this.sourceUrl = sourceUrl;
	}

	public String getLicenseUrl() {
		return licenseUrl;
	}

	public void setLicenseUrl(String licenseUrl) {
		this.licenseUrl = licenseUrl;
	}

	public String getImageUrl() {
		return imageUrl;
	}

	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}
	public String getServiceId() {
		return serviceId;
	}

	public void setServiceId(String serviceId) {
		this.serviceId = serviceId;
	}

}
