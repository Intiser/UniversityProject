/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package supershop;

/**
 *
 * @author Ahsan
 */
public class Product {
         private String productId;
         private String productName;
         private String producttype;
         private double buyUnitPrice;
         private double sellUnitPrice;
         private int    Unit;
         private String supplierId;

    public Product(String productId, String productName, String producttype, double buyUnitPrice, double sellUnitPrice, int Unit, String supplierId) {
        this.productId = productId;
        this.productName = productName;
        this.producttype = producttype;
        this.buyUnitPrice = buyUnitPrice;
        this.sellUnitPrice = sellUnitPrice;
        this.Unit = Unit;
        this.supplierId = supplierId;
    }

    public String getProductId() {
        return productId;
    }

    public String getProductName() {
        return productName;
    }

    public String getProducttype() {
        return producttype;
    }

    public double getBuyUnitPrice() {
        return buyUnitPrice;
    }

    public double getSellUnitPrice() {
        return sellUnitPrice;
    }

    public int getUnit() {
        return Unit;
    }

    public String getSupplierId() {
        return supplierId;
    }

    @Override
    public String toString() {
        return "ProductId : "+ productId + "\nProductName : " + productName + "\nProductType : " + producttype + "\nUnit Price (Buy) : " + buyUnitPrice + "\nUnit Price (Sell) : " + sellUnitPrice + "\nUnits : " + Unit + "\nSupplier Id : " + supplierId;
    }
         
         
}
