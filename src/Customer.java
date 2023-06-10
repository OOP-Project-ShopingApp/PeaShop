

public class Customer {
    private String name;
    private String surname;
    private String userName;
    private String phoneNumber;
    private String email;
    private double idNumber;

    public Customer(String name, String surname, String userName, String phoneNumber, String email, double idNumber) {
        this.name = name;
        this.surname = surname;
        this.userName = userName;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.idNumber = idNumber;
    }

    public Customer(String name, String surname, String userName) {
        this.name = name;
        this.surname = surname;
        this.userName = userName;
        this.phoneNumber = "";
        this.email = "";
        this.idNumber = 0;
    }
    @Override
    public String toString() {
        return "Customer Information: \n" +
                "Name: " + name + "\n" +
                "Surname: " + surname + "\n" +
                "Username: " + userName + "\n" +
                "Phone Number: " + phoneNumber + "\n" +
                "Email: " + email + "\n" +
                "ID Number: " + idNumber;
    }

    // Getters and Setters
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

