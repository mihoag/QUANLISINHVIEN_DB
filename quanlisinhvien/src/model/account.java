package model;

public class account {
private String username;
private String password;
public account(String username, String password) {
	super();
	this.username = username;
	this.password = password;
}
public account() {
	super();
	// TODO Auto-generated constructor stub
}
public String getUsername() {
	return username;
}
public void setUsername(String username) {
	this.username = username;
}
public String getPassword() {
	return password;
}
public void setPassword(String password) {
	this.password = password;
}
}
