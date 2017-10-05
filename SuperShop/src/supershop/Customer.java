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
public class Customer {
    private String customerID;
    private String cutomerName;
    private String customerContact;

    public Customer(String customerID, String cutomerName, String customerContact) {
        this.customerID = customerID;
        this.cutomerName = cutomerName;
        this.customerContact = customerContact;
    }

    public String getCustomerID() {
        return customerID;
    }

    public String getCutomerName() {
        return cutomerName;
    }

    public String getCustomerContact() {
        return customerContact;
    }

    @Override
    public String toString() {
        return  "ID : "+customerID + "\nName : " + cutomerName + "\nContact : " + customerContact ;
        
    }
    
    
    
}
