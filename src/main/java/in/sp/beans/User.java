package in.sp.beans;

public class User {
private String username;
private String city;
private int birthyear;
private String highEdu;
private String gender;
private String password;

public String getPassword() {
	return password;
}
public void setPassword(String password) {
	this.password = password;
}
public String getUsername() {
	return username;
}
public void setUsername(String username) {
	this.username = username;
}
public String getCity() {
	return city;
}
public void setCity(String city) {
	this.city = city;
}
public int getBirthyear() {
	return birthyear;
}
public void setBirthyear(int birthyear) {
	this.birthyear = birthyear;
}
public String getHighEdu() {
	return highEdu;
}
public void setHighEdu(String highEdu) {
	this.highEdu = highEdu;
}
public String getGender() {
	return gender;
}
public void setGender(String gender) {
	this.gender = gender;
}

}
