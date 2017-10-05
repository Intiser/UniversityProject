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
public class Sell {
    private String time;
    private String customerId;
    private String customerName;
    private String customerContact;
    private String productId;
    private String productName;
    private int unit;
    private double unitPrice;
    private double totalcost;

    public Sell(String time, String customerId, String customerName, String customerContact, String productId, String productName, int unit, double unitPrice, double totalcost) {
        this.time = time;
        this.customerId = customerId;
        this.customerName = customerName;
        this.customerContact = customerContact;
        this.productId = productId;
        this.productName = productName;
        this.unit = unit;
        this.unitPrice = unitPrice;
        this.totalcost = totalcost;
    }

    public String getTime() {
        return time;
    }

    public String getCustomerId() {
        return customerId;
    }

    public String getCustomerName() {
        return customerName;
    }

    public String getCustomerContact() {
        return customerContact;
    }

    public String getProductId() {
        return productId;
    }

    public String getProductName() {
        return productName;
    }

    public int getUnit() {
        return unit;
    }

    public double getUnitPrice() {
        return unitPrice;
    }

    public double getTotalcost() {
        return totalcost;
    }

    @Override
    public String toString() {
        return "Date & time : " + time + "\nCustomerId : " + customerId + "\nCustomerName : " + customerName + "\nCustomerContact : " + customerContact + "\nproductId : " + productId + "\nProductName : " + productName + "\nUnit : " + unit + "\nUnitPrice : " + unitPrice + "\nTotalcost : " + totalcost;
    }
    
    
}
