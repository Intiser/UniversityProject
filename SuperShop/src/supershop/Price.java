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
public class Price {
    double Totalprice;

    public Price(double Totalprice) {
        this.Totalprice = Totalprice;
    }

    public double getTotalprice() {
        return Totalprice;
    }

    @Override
    public String toString() {
        return  Totalprice +"";
    }
    
    
}
