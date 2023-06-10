

public class Users {
	private String userType;
	private User user;
	private double userID;
	private int numberOfPerson; 
	private int numberOfSalesPerson; 
	DoubleLinkList<Double,User> listOfPerson=new DoubleLinkList<Double,User>();
	DoubleLinkList<Double,User> listOfSalesPerson=new DoubleLinkList<Double,User>();
	public Users(){
		numberOfPerson=0;
		numberOfSalesPerson=0;
	}
	public void addUser(User user) {
		this.user=user;
		userID=user.getUserIdNumber();
		userType=user.getUserType();
		if(userType.equals("customer")) {
			listOfPerson.addSorted(userID,user);
			numberOfPerson++;
		}
		else if(userType.equals("seller")) {
			listOfSalesPerson.addSorted(userID,user);
			numberOfSalesPerson++;
		}	
	}
	public void removeUser(User user) {
		this.user=user;
		userID=user.getUserIdNumber();
		userType=user.getUserType();
		if(userType.equals("person")) {
			boolean flag=listOfPerson.remove(userID);
			if(flag==true) {
				numberOfPerson--;
			}
		}
		else if(userType.equals("salesPerson")) {
			boolean flag=listOfSalesPerson.remove(userID);
			if(flag==true) {
				numberOfSalesPerson--;
			}
		}	
	}
	public boolean search(double userID,String userType) {
		boolean flag=false;
		if(userType.equals("customer")) {
			flag=listOfPerson.search(userID);
		}
		else if(userType.equals("seller")) {
			flag=listOfSalesPerson.search(userID);
		}	
		return flag;
	}
	public int getNumberOfPerson() {
		return numberOfPerson;
	}
	public int getNumberOfSalesPerson() {
		return numberOfSalesPerson;
	}
	public void printCustomer() {
		listOfPerson.print();
	}
	public void printSeller() {
		listOfSalesPerson.print();
	}
	
}
