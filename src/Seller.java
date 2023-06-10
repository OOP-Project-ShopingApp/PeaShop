

public class Seller {
    private String name;
    private String surname;
    private String userName;
    private String phoneNumber;
    private String email;
    private double idNumber;

    // Constructor with all attributes
    public Seller(String name, String surname, String userName, String phoneNumber, String email, double idNumber) {
        this.name = name;
        this.surname = surname;
        this.userName = userName;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.idNumber = idNumber;
    }

    // Constructor without ID number
    public Seller(String name, String surname, String userName, String phoneNumber, String email) {
        this.name = name;
        this.surname = surname;
        this.userName = userName;
        this.phoneNumber = "";
        this.email = "";
        this.idNumber = 0;
    }

    // Getters and setters for the attributes (omitted for brevity)

    // toString() method to display the Seller information
    @Override
    public String toString() {
        return "Seller Information: \n" +
                "Name: " + name + "\n" +
                "Surname: " + surname + "\n" +
                "Username: " + userName + "\n" +
                "Phone Number: " + phoneNumber + "\n" +
                "Email: " + email + "\n" +
                "ID Number: " + idNumber;
    }

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSurname() {
		return surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public double getIdNumber() {
		return idNumber;
	}

	public void setIdNumber(double idNumber) {
		this.idNumber = idNumber;
	}
}

