
import java.io.*;
import java.util.*;
public class Test {
	/**entries checking method*/
	public static String enterSystem(Users peopleDataBase) {
		Scanner readLine = new Scanner(System.in);
		String line="not entreies";
		int counter=0;
		System.out.println("you are Welcome\nare you registered?\nPlease enter yes or no");
		while(true) {
			line=readLine.nextLine();
			if(counter>=5) {
				System.out.println("you left from the system");
				break;
			} 
			else {
				if(line.equals("yes")) {
					System.out.println("you have entered to the system");
					break;
				}
				else if(line.equals("no")) {
					System.out.println("you have not entered to the system");
					break;
				}
				else {
					System.out.println("incorret entry! do you want to quick from the system?\n please enter q");
					line=readLine.nextLine();
					if(line.equals("q")) {
						System.out.println("you quicked from the system");
						break;
					}
					else {
						counter++;
						System.out.println("You have " +(5-counter)+ " entries left to log in");
						System.out.println("try again entries (yes or no)");
					}
				}
			}
	
		}
		counter=0;
		Users people=peopleDataBase;
		String typeOfEntries="";
		if(line.equals("yes")) {
			System.out.println("are you registered (yes or no)");
			line=readLine.nextLine();
			String name="",surname="",username="",phoneNumber="",email="",userID="",userType="";
			if(line.equals("no")) {
				System.out.println("you are redirected to the sales menu");
				System.out.println("please enter name");
				name=readLine.nextLine();
				System.out.println("please enter surname");
				surname=readLine.nextLine();
				System.out.println("please enter username");
				username=readLine.nextLine();
				System.out.println("please enter phone number");
				phoneNumber=readLine.nextLine();
				System.out.println("please enter e-mail");
				email=readLine.nextLine();
				System.out.println("please enter userID");
				userID=readLine.nextLine();
				System.out.println("please enter user type");
				userType=readLine.nextLine();
				/** user add method*/
				
			}
			
			while(true) {
				if(counter>=5) {
					System.out.println("you left from the system");
					break;
				} 
				else {
					System.out.println("please choose user type (for Seller s, for Customer c)");
					line=readLine.nextLine();
					if(line.equals("s")) {
						while(true) {
							System.out.println("please enter your userId");
							line=readLine.nextLine();
							System.out.println("check your entries");
							boolean flag=people.search(Double.parseDouble(line),"seller");
							if(flag==false) {
								System.out.println("User not found\tDo you want to quick from the system(please enter q)");
								line=readLine.nextLine();
								if(line.equals("q")) {
									break;
								}
							}
							else {
								System.out.println("you are log in");
								typeOfEntries="seller";
								break;
							}
						}
						break;
						
					}
					else if(line.equals("c")) {
						while(true) {
							System.out.println("please enter your userId");
							line=readLine.nextLine();
							System.out.println("check your entries");
							boolean flag=people.search(Double.parseDouble(line),"customer");
							if(flag==false) {
								System.out.println("User not found\tDo you want to quick from the system(please enter q)");
								line=readLine.nextLine();
								if(line.equals("q")) {
									break;
								}
							}
							else {
								System.out.println("you are log in");
								typeOfEntries="customer";
								break;
							}
						}
						break;
							
					}
					else {
						System.out.println("incorret entry! do you want to quick from the system?\n please enter q");
						line=readLine.nextLine();
						if(line.equals("q")) {
							System.out.println("you quicked from the system");
							break;
						}
						else {
							counter++;
							System.out.println("You have " +(5-counter)+ " entries left to log in");
							System.out.println("try again entries");
						}
					}	
				}
				}
				
		}
		return typeOfEntries;

	}
	/** for default customer information*/ 
	private static Users readCustomer(String filePath,Users peopleDataBase) throws IOException {
    
        File f1=new File(filePath);
     	FileReader freader=new FileReader(f1);
     	BufferedReader breader=new BufferedReader(freader);
     	String line="";
     
     	while((line=breader.readLine()) !=null) {
     		
     		String [] str= line.split(",");
     		
     		Customer customer=new Customer(str[0], str[1], str[2], str[3], str[4], Double.parseDouble(str[5]));
     		User user=new User("customer",customer);
     		peopleDataBase.addUser(user);
    	}
    	breader.close(); 
    	return peopleDataBase;
	}
	/** for default seller information*/
	private static Users readSeller(String filePath,Users peopleDataBase) throws IOException {
	    
        File f1=new File(filePath);
     	FileReader freader=new FileReader(f1);
     	BufferedReader breader=new BufferedReader(freader);
     	String line="";
     	
     
     	while((line=breader.readLine()) !=null) {
     		
     		String [] str= line.split(",");
     		
     		Seller seller=new Seller(str[0], str[1], str[2], str[3], str[4], Double.parseDouble(str[5]));
     		User user=new User("seller",seller);
     		peopleDataBase.addUser(user);
    	}
    	breader.close(); 
    	return peopleDataBase;
	}
	/** for default seller information*/
	private static Products readProducts(String filePath,Products productsList,Users peopleDataBase) throws IOException {
	    
        File f1=new File(filePath);
     	FileReader freader=new FileReader(f1);
     	BufferedReader breader=new BufferedReader(freader);
     	String line="";
     	while((line=breader.readLine()) !=null) {
     		
     		String [] str= line.split(",");
     		Product product=new Product(str[0],Double.parseDouble(str[1]), Double.parseDouble(str[2]), str[3], str[4], Double.parseDouble(str[5]),Double.parseDouble(str[6]));
     		productsList.add(product,peopleDataBase,product.getSellerID(),product.getMainCategoryType(),product.getSubCategoryType());
    	}
    	breader.close(); 
    	return productsList;
	}
        
	
	public static void printSalesMenu() {
		
	}


	public static void main(String[] args) throws IOException {
		/** */
		Users peopleDataBase=new Users();
		Products productsList=new Products();
		
		peopleDataBase=readCustomer("customer.txt", peopleDataBase);
		peopleDataBase=readSeller("seller.txt", peopleDataBase);
		productsList=readProducts("products.txt", productsList,peopleDataBase);
		
		String typeOfEntries=enterSystem(peopleDataBase);
		Scanner redRow = new Scanner(System.in);
		String row="",name="",ID="",price="",mainCategory="",subCategory="",sellerID="",amount="";
		if(typeOfEntries.equals("seller")) {
			System.out.println("Do you want to sell anything (yes or no)");
			row=redRow.nextLine();
			if(row.equals("yes")) {
				System.out.println("you are redirected to the sales menu");
				System.out.println("please enter product name");
				name=redRow.nextLine();
				System.out.println("please enter product ID");
				ID=redRow.nextLine();
				System.out.println("please enter product price");
				price=redRow.nextLine();
				System.out.println("please enter product main category");
				mainCategory=redRow.nextLine();
				System.out.println("please enter product subcategory");
				subCategory=redRow.nextLine();
				System.out.println("please enter product sellerID");
				sellerID=redRow.nextLine();
				System.out.println("please enter product amount");
				amount=redRow.nextLine();
				Product product=new Product(name,Double.parseDouble(ID), Double.parseDouble(price), mainCategory, subCategory, Double.parseDouble(sellerID),Double.parseDouble(amount));
	     		productsList.add(product,peopleDataBase,product.getSellerID(),product.getMainCategoryType(),product.getSubCategoryType());
	     		System.out.println("product was added");

			}
			else if(row.equals("no")) {
				System.out.println("You are redirected to the main menu of the products");
				System.out.println("You are redirected to the main menu of the products");
				productsList.printProducts();
				while(true) {
					System.out.println("can you enter maincategory");
					row=redRow.nextLine();
					productsList.getMainCategoryFilter(row);
					System.out.println("can you enter subcategory");
					productsList.getSubCategoryFilter(row,redRow.nextLine());
					System.out.println("do you want to buy anything (yes or no)");
					row=redRow.nextLine();
					if(row.equals("yes")){
						System.out.println("please enter product ID from list");
						row=redRow.nextLine();
						if(productsList.search(Double.parseDouble(row))) {
							System.out.println("you received the product");
							System.out.println("Your product has been shipped");
						}
						else
						{
							System.out.println("you did not receive the product");
						}
					}
					System.out.println("You are redirected to the main menu of the products");
					
							
				}

			}
			
		}
		else if(typeOfEntries.equals("customer")) {
			System.out.println("You are redirected to the main menu of the products");
			productsList.printProducts();
			while(true) {
				System.out.println("can you enter maincategory");
				row=redRow.nextLine();
				productsList.getMainCategoryFilter(row);
				System.out.println("can you enter subcategory");
				productsList.getSubCategoryFilter(row,redRow.nextLine());
				System.out.println("do you want to buy anything (yes or no)");
				row=redRow.nextLine();
				if(row.equals("yes")){
					System.out.println("please enter product ID from list");
					row=redRow.nextLine();
					if(productsList.search(Double.parseDouble(row))) {
						System.out.println("you received the product");
						System.out.println("Your product has been shipped");
					}
					else
					{
						System.out.println("you did not receive the product");
					}
				}
				System.out.println("You are redirected to the main menu of the products");
				
						
			}
			
		}
		
	}

}
