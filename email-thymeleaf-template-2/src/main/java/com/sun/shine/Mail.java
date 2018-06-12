package com.sun.shine;

import java.util.Map;

public class Mail {

	private String from;
	private String to;
	private String subject;
	private Map<String, String> content;

	public Mail() {
	}

	public Mail(String from, String to, String subject, Map<String, String> content) {
		this.from = from;
		this.to = to;
		this.subject = subject;
		this.content = content;
	}

	public String getFrom() {
		return from;
	}

	public void setFrom(String from) {
		this.from = from;
	}

	public String getTo() {
		return to;
	}

	public void setTo(String to) {
		this.to = to;
	}

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	public Map<String, String> getContent() {
		return content;
	}

	public void setContent(Map<String, String> content) {
		this.content = content;
	}

	@Override
	public String toString() {
		return "Mail{" + "from='" + from + '\'' + ", to='" + to + '\'' + ", subject='" + subject + '\'' + ", content='"
				+ content + '\'' + '}';
	}
}
