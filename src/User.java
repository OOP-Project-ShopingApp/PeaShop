

public class User {
	private String userType;
	private Seller seller;
	private Customer customer;
	
	public User(String userType,Seller seller) {
		this.userType=userType;
		this.seller=seller;
		this.customer=null;
	}
	public User(String userType,Customer customer) {
		this.userType=userType;
		this.customer=customer;
		this.seller=null;
	}
	public void printUserData() {
		if(customer!=null) {
			System.out.println(customer.toString());
		}
		if(seller!=null) {
			System.out.println(seller.toString());
		}
		
	}
	public String getUserData() {
		if(customer!=null) {
			return customer.toString();
		}
		if(seller!=null) {
			return seller.toString();
		}
		return null;
	}
	public String getUserType() {
		if(customer!=null) {
			return "customer";
		}
		if(seller!=null) {
			return "seller";
		}
		return null;
	}
	public String getUserName() {
		if(customer!=null) {
			return customer.getUserName();
		}
		if(seller!=null) {
			return seller.getUserName();
		}
		return null;
	}
	public double getUserIdNumber() {
		if(customer!=null) {
			return customer.getIdNumber();
		}
		if(seller!=null) {
			return seller.getIdNumber();
		}
		return 0;
	}
}
