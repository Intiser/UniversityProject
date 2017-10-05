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
public class Supplier {
    private String supplierID;
    private String supplierName;
    private String supplierContact;
    private String supplierAddress;

    public Supplier(String supplierID, String supplierName, String supplierContact, String supplierAddress) {
        this.supplierID = supplierID;
        this.supplierName = supplierName;
        this.supplierContact = supplierContact;
        this.supplierAddress = supplierAddress;
    }

    public String getSupplierID() {
        return supplierID;
    }

    public String getSupplierName() {
        return supplierName;
    }

    public String getSupplierContact() {
        return supplierContact;
    }

    public String getSupplierAddress() {
        return supplierAddress;
    }

    @Override
    public String toString() {
        return  "SupplierID : "+supplierID + "\nSupplierName : " + supplierName + "\nSupplierContact : " + supplierContact + "\nSupplierAddress : " + supplierAddress ;
    }
    
    
    
}
