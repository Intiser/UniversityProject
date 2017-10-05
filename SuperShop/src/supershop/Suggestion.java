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
public class Suggestion {
    private String productName;
    private String productType;

    public Suggestion(String productName, String productType) {
        this.productName = productName;
        this.productType = productType;
    }

    public String getProductName() {
        return productName;
    }

    public String getProductType() {
        return productType;
    }

    @Override
    public String toString() {
        return  productName + "\n" + productType ;
    }
    
    
    
}
