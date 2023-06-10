package OOP;

public class Product {
	private String productName;
    private double productID;
    private double price;
    private String categoryType;
    private String salesPersonName;

    public Product(String productName, double productID, double price, String categoryType, String salesPersonName) {
        this.productName = productName;
        this.productID = productID;
        this.price = price;
        this.categoryType = categoryType;
        this.salesPersonName = salesPersonName;
    }

    //Getter and Setter methods
    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public double getProductID() {
        return productID;
    }

    public void setProductID(double productID) {
        this.productID = productID;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getCategoryType() {
        return categoryType;
    }

    public void setCategoryType(String categoryType) {
        this.categoryType = categoryType;
    }

    public String getSalesPersonName() {
        return salesPersonName;
    }

    public void setSalesPersonName(String salesPersonName) {
        this.salesPersonName = salesPersonName;
    }

}
