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
public class Users {
    private String designation;
    private String userName;
    private String userId;
    private String userPassword;

    public Users(String resignation, String userId, String userName, String userPassword) {
        this.designation = resignation;
        this.userName = userName;
        this.userId = userId;
        this.userPassword = userPassword;
    }

    public String getDesignation() {
        return designation;
    }

    public String getUserName() {
        return userName;
    }

    public String getUserId() {
        return userId;
    }

    public String getUserPassword() {
        return userPassword;
    }

    @Override
    public String toString() {
        return   designation + "\n" + userName + "\n" + userId ;
    }
    
    
    
}
