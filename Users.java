package OOP;

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
		if(userType.equals("person")) {
			listOfPerson.addSorted(userID,user);
			numberOfPerson++;
		}
		else if(userType.equals("salesPerson")) {
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
	public boolean search(User user) {
		boolean flag=false;
		this.user=user;
		userID=user.getUserIdNumber();
		userType=user.getUserType();
		if(userType.equals("person")) {
			flag=listOfPerson.search(userID);
		}
		else if(userType.equals("salesPerson")) {
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
	
}
