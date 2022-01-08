package com.example.mail;



import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Mail {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
private int id;
private String fromMail;
private String toMail;
private String subject;
private String message;
public int getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
}
public String getFromMail() {
	return fromMail;
}
public void setFromMail(String fromMail) {
	this.fromMail = fromMail;
}
public String getToMail() {
	return toMail;
}
public void setToMail(String toMail) {
	this.toMail = toMail;
}
public String getSubject() {
	return subject;
}
public void setSubject(String subject) {
	this.subject = subject;
}
public String getMessage() {
	return message;
}
public void setMessage(String message) {
	this.message = message;
}
public Mail() {
	super();
}
public Mail(String fromMail, String toMail, String subject, String message) {
	super();
	this.fromMail = fromMail;
	this.toMail = toMail;
	this.subject = subject;
	this.message = message;
}

@Override
public String toString() {
	return "Mail [id=" + id + ", fromMail=" + fromMail + ", toMail=" + toMail + ", subject=" + subject + ", message="
			+ message + "]";
}

}
