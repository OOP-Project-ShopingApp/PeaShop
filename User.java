package OOP;

public class User {
	protected String userName;
	protected String usersurName;
	protected double userPhoneNumber;
	protected String userEMail;
	protected double userIdNumber;
	protected String userType;
	
	public User(String userName, String usersurName, double userPhoneNumber, String userEMail, double userIdNumber,String userType) {
		this.userName = userName;
		this.usersurName = usersurName;
		this.userPhoneNumber=userPhoneNumber;
		this.userEMail=userEMail;
		this.userIdNumber=userIdNumber;
		this.userType=userType;
	}
	
	public User(String userName, String usersurName, double userIdNumber,String userType) {
		this.userName = userName;
		this.usersurName = usersurName;
		this.userIdNumber=userIdNumber;
		this.userType=userType;
	}
	
	public String getUserEMail() {
		return userEMail;
	}
	public void setUserEMail(String userEMail) {
		this.userEMail = userEMail;
	}
	public String getUserType() {
		return userType;
	}
	public void setUserType(String userType) {
		this.userType = userType;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getUsersurName() {
		return usersurName;
	}
	public void setUsersurName(String usersurName) {
		this.usersurName = usersurName;
	}
	public double getUserPhoneNumber() {
		return userPhoneNumber;
	}
	public void setUserPhoneNumber(double userPhoneNumber) {
		userPhoneNumber = userPhoneNumber;
	}
	public double getUserIdNumber() {
		return userIdNumber;
	}
	public void setUserIdNumber(double userIdNumber) {
		this.userIdNumber = userIdNumber;
	}
	
}
