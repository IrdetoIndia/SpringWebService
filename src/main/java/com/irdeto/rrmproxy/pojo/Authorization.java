package com.irdeto.rrmproxy.pojo;

import java.util.Date;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "Authorization")
public class Authorization {

	String accountId;
	Long categoryId;
	Date begin;
	Date end;
	int optionId;
	String tickets;
	String duration;

	@XmlAttribute(name = "AccountId")
	public String getAccountId() {
		return accountId;
	}

	public void setAccountId(String accountId) {
		this.accountId = accountId;
	}

	@XmlAttribute(name = "CategoryId")
	public Long getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(Long categoryId) {
		this.categoryId = categoryId;
	}

	@XmlAttribute(name = "Begin")
	public Date getBegin() {
		return begin;
	}

	public void setBegin(Date begin) {
		this.begin = begin;
	}

	@XmlAttribute(name = "End")
	public Date getEnd() {
		return end;
	}

	public void setEnd(Date end) {
		this.end = end;
	}

	@XmlAttribute(name = "OptionId")
	public int getOptionId() {
		return optionId;
	}

	public void setOptionId(int optionId) {
		this.optionId = optionId;
	}

	@XmlAttribute(name = "Tickets")
	public String getTickets() {
		return tickets;
	}

	public void setTickets(String tickets) {
		this.tickets = tickets;
	}

	@XmlAttribute(name = "Duration")
	public String getDuration() {
		return duration;
	}

	public void setDuration(String duration) {
		this.duration = duration;
	}
}
