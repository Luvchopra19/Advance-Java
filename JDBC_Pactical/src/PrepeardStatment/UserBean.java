package PrepeardStatment;

import java.util.Date;

//UserBean contain attribute of st_user table  
public class UserBean {
	
	private int id;
	private String firstName;
	private String lastName;
	private String login;
	private String passward;
	private Date dob;
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getlastName() {
	return lastName;	
	}
	public void setlastName(String lastName) {
		this.lastName = lastName;
	}
	public String getlogin() {
		return login;
	}
	public void setlogin(String login) {
		this.login = login;
	}
	public String getPassward() {
		return passward;
	}
	public void setPassward(String passward) {
		this.passward = passward;
	}
	public Date getdob() {
		return dob;
	}
	public void setdob(Date dob) {
		this.dob = dob;
	}
}