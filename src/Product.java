

public class Product {
    private String productName;
    private double ID;
    private double price;
    private String mainCategoryType;
    private String subCategoryType;
    private double sellerID;
    private double amount;

    public Product(String productName,double productID, double price, String mainCategoryType, String subCategoryType, double sellerID, double amount) {
        this.productName = productName;
        this.ID=productID;
        this.price = price;
        this.mainCategoryType = mainCategoryType;
        this.subCategoryType = subCategoryType;
        this.sellerID = sellerID;
        this.amount=amount;
    }
    public Product(String productName, double amount, double price,double sellerID,double productID) {
        this.productName = productName;
        this.ID=productID;
        this.price = price;
        this.mainCategoryType = null;
        this.subCategoryType = null;
        this.sellerID = sellerID;
        this.amount=amount;
    }

    // Getters and Setters
    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public double getProductID() {
        return ID;
    }

    public void setProductID(double ID) {
        this.ID=ID;
    }
    public double getAmount() {
        return amount;
    }

    public void setamount(double amount) {
        this.amount=amount;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getMainCategoryType() {
        return mainCategoryType;
    }

    public void setMainCategoryType(String mainCategoryType) {
        this.mainCategoryType = mainCategoryType;
    }

    public String getSubCategoryType() {
        return subCategoryType;
    }

    public void setSubCategoryType(String subCategoryType) {
        this.subCategoryType = subCategoryType;
    }

    public double getSellerID() {
        return sellerID;
    }

    public void setSellerID(double sellerID) {
        this.sellerID=sellerID;
    }

    @Override
    public String toString() {
        return  "productName='" + productName + '\'' +
                ", amount=" + ID +
                ", price=" + price +
                ", mainCategoryType='" + mainCategoryType + '\'' +
                ", subCategoryType='" + subCategoryType + '\'' +
                ", salesPersonID='" + sellerID + '\''+
                ", amount='" + amount + '\'';
    }
    public String getData() {
    	
        return  productName +
                ", price: " + price +
                "$, salesPersonID: " + sellerID +
                ", amount: " +amount+
                ", product ID: " + ID;
    }
}

