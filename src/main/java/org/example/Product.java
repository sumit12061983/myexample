package org.example;

public class Product {
    String productId;
    String productName;
    String productQty;
    String productAmount;

    public Product(String productId, String productName, String productQty, String productAmount) {
        this.productId = productId;
        this.productName = productName;
        this.productQty = productQty;
        this.productAmount = productAmount;
    }

    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getProductQty() {
        return productQty;
    }

    public void setProductQty(String productQty) {
        this.productQty = productQty;
    }

    public String getProductAmount() {
        return productAmount;
    }

    public void setProductAmount(String productAmount) {
        this.productAmount = productAmount;
    }

    @Override public String toString() {
        return "Product{" + "productId='" + productId + '\'' + ", productName='" + productName + '\'' + ", productQty='"
                + productQty + '\'' + ", productAmount='" + productAmount + '\'' + '}';
    }
}
