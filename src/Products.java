

public class Products {
	private String[][] categoryArray= {{"Electronics","Computers","Mobile Phones","Televisions", "Cameras", "Gaming Consoles"},
			{"Cosmetic","Makeup","Skincare","Perfumes","Televisions","Cameras"},
			{"Attire","Men's Clothing","Women's Clothing","Children's Clothing","Footwear","Accessories"},
			{"accessory","Jewelry","Watches","Bags","Belts","Hats"},
			{"Stationery","Pens", "Notebooks" ,"Staplers", "Markers", "Scissors"},
			{"Shoe","Men's Shoes" ,"Women's Shoes", "Children's Shoes" , "Sports Shoes" ,"Boots"},
			{"homeandlife","Furniture", "Home Decor" , "Kitchen Appliances" , "Bedding", "Cleaning Supplies" },
			{"book","Fiction" , "Non-Fiction", "Biographies","Self-Help", "History"}};
	
	private String mainCategory;
	private String subCategory;
	private Product product;
	private int numberOfProducts;
	DoubleLinkList<Double,Product> productsList=new DoubleLinkList<Double,Product>();

	public Products() {
		this.product=null;
		this.mainCategory=null;
		this.subCategory=null;
		this.numberOfProducts=0;
	}
	public boolean add(Product product,Users people,double sellerID) {
		if(people.search(sellerID,"seller")) {
			if(product.getMainCategoryType().equals(null)) {
				product.setMainCategoryType("general");
				product.setSubCategoryType("general");
			}
			productsList.addSorted(product.getProductID(), product);
			numberOfProducts++;
			return true;
		}
		else {
			return false;
		}
		
	}
	public boolean add(Product product,Users people,double sellerID,String mainCategory) {
		if(people.search(sellerID,"seller")) {
			boolean flag=false;
			for(int i=0;i<8;i++) {
				if(product.getMainCategoryType().equals(categoryArray[i][0])) {
					flag=true;
					break;
				}
			}
			if(flag==true) {
				product.setMainCategoryType(mainCategory);
				product.setSubCategoryType("general");
			}
			else {
				product.setMainCategoryType("general");
				product.setSubCategoryType("general");
			}
			add(product,people,sellerID);
			return true;
		}else {
			return false;
		}
	}
	public boolean add(Product product,Users people,double sellerID,String mainCategory,String subCategory) {
		if(people.search(sellerID,"seller")) {
			boolean flag=false;
			int c=-1;
			for(int i=0;i<8;i++) {
				if(product.getMainCategoryType().equals(categoryArray[i][0])) {
					c=i;
					flag=true;
					break;
				}
			}
			if(flag==true) {
				flag=false;
				for(int i=1;i<6;i++) {
					if(product.getSubCategoryType().equals(categoryArray[c][i])) {
						flag=true;
						break;
					}
				}
				if(flag==true) {
					product.setMainCategoryType(mainCategory);
					product.setSubCategoryType(subCategory);
				}else {
					product.setMainCategoryType(mainCategory);
					product.setSubCategoryType("general");
				}
			}
			else {
				product.setMainCategoryType("general");
				product.setSubCategoryType("general");
			}
			
			add(product,people,sellerID);
			return true;
		}
		else {
			return false;
		}
		
	}
	public boolean remove(double productId) {
		boolean flag= productsList.remove(productId);
		if(flag==true) {
			numberOfProducts--;
		}
		return flag;
	}
	public void printProducts() {
		productsList.getValue();
	}
	public void getMainCategoryFilter(String mainCategory) {
		productsList.getValue(mainCategory);
	}
	public void getSubCategoryFilter(String mainCategory,String subCategory) {
		productsList.getValue(mainCategory);
	}
	public boolean search(double ID) {
		return productsList.search(ID);
	}
	

}
