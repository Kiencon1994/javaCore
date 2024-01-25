package final_Exam;

import java.util.Date;

public class Product {
    private int productId;
    private String productName;
    private float productPrice;
    private boolean available;
    private Date saleDate;

    public Product() {

    }

    public Product(int productId, String productName,float productPrice,boolean available,Date saleDate) {
        this.productId = productId;
        this.productName = productName;
        this.productPrice = productPrice;
        this.available = available;
        this.saleDate = saleDate;
    }

    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public String getProductName() {
        return this.productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public float getProductPrice() {
        return this.productPrice;
    }

    public void setProductPrice(float productPrice) {
        this.productPrice = productPrice;
    }

    public boolean isAvailable() {
        return available;
    }

    public void setAvailable(boolean available) {
        this.available = available;
    }

    public Date getSaleDate() {
        return saleDate;
    }

    public void setSaleDate(Date saleDate) {
        this.saleDate = saleDate;
    }

    public void displayInformationProduct() {
        StringBuilder result = new StringBuilder();
        result.append("Product Id: ").append(this.productId)
                .append(", Product Name: ").append(this.productName)
                .append(", Product Price: ").append(this.productPrice)
                .append(", available: ").append(this.available ? "con hang" : "het hang")
                .append(", Sale Day: ").append(this.saleDate);
        System.out.println(result);
    }
}
