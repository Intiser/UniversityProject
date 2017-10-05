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
public class Buy {
    private String time;
    private String supplierId;
    private String supplierName;
    private String productId;
    private String productName;
    private int unit;
    private double unitPrice;
    private double total;

    public Buy(String time, String supplierId, String supplierName, String productId, String productName, int unit, double unitPrice, double total) {
        this.time = time;
        this.supplierId = supplierId;
        this.supplierName = supplierName;
        this.productId = productId;
        this.productName = productName;
        this.unit = unit;
        this.unitPrice = unitPrice;
        this.total = total;
    }

    public String getTime() {
        return time;
    }

    public String getSupplierId() {
        return supplierId;
    }

    public String getSupplierName() {
        return supplierName;
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

    public double getTotal() {
        return total;
    }

    @Override
    public String toString() {
        return "Date & Time :" + time + "\nSupplierId :" + supplierId + "\nSupplierName :" + supplierName + "\nProductId :" + productId + "\nProductName :" + productName + "\nUnit :" + unit + "\nUnitPrice :" + unitPrice + "\nTotal :" + total;
    }
    
    
    
}
