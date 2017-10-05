/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package supershop;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Ahsan
 */
public class UserLoginController implements Initializable {
    @FXML
    private ComboBox<User> UsersBox;
    @FXML
    private TextField userNameField;
    @FXML
    private Button LogInButton;
    @FXML
    private PasswordField passwordField;
    private int pFlag,uFlag,sFlag;
    
    Statement statement;
    @FXML
    private Label warningLabel;
    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        UsersBox.getItems().addAll(User.values());
        
        pFlag=0;
        sFlag=0;
        uFlag=0;
        
          String DB_URL ="jdbc:mysql://localhost/superstoredb";
        String DB_User="custom";
        String DB_Pass="obsecure";
        
        try {
            Connection connection =DriverManager.getConnection(DB_URL, DB_User, DB_Pass);
            statement = connection.createStatement();
            
        } catch (SQLException ex) {
            Logger.getLogger(UserLoginController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }    

    @FXML
    private void handleBoxClickAction(MouseEvent event) {
        sFlag=1;
        if(sFlag==1&&uFlag==1&&pFlag==1)
            LogInButton.setDisable(false);
            
    }

    @FXML
    private void handleUserKeyAction(KeyEvent event) {
         uFlag=1;
        if(sFlag==1&&uFlag==1&&pFlag==1)
            LogInButton.setDisable(false);
    }

    @FXML
    private void handleLogINAction(ActionEvent event) {
        String designation = UsersBox.getSelectionModel().getSelectedItem().toString();
        String User = userNameField.getText();
        String Pass = passwordField.getText();
        
        String query ="Select * from User";
        int f=0;
        
       
        try {
            ResultSet resultset = statement.executeQuery(query);
            while(resultset.next()&&f==0)
            {
             String pos = resultset.getString("designation");
             String name = resultset.getString("userName");
             String pass = resultset.getString("userPassword");
             
             if(pos.compareTo(designation)==0&&name.compareTo(User)==0&&pass.compareTo(Pass)==0)
              f=1;
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(UserLoginController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
         if(f==1){
        Parent root= null;
        String title = null; 
        
         
         
         if(designation.compareTo("Admin")==0)
         {   
            try {
                root = FXMLLoader.load(getClass().getResource("AdminUI.fxml"));
            } catch (IOException ex) {
                Logger.getLogger(UserLoginController.class.getName()).log(Level.SEVERE, null, ex);
            }
            title ="ADMIN";
         }
         else if(designation.compareTo("GenearalManager")==0)
        {   
            try {
                root = FXMLLoader.load(getClass().getResource("ManagerUI.fxml"));
            } catch (IOException ex) {
                Logger.getLogger(UserLoginController.class.getName()).log(Level.SEVERE, null, ex);
            }
            title = "MONITORING POINT";
         }
         else if(designation.compareTo("StockKeeper")==0)
        {   
            try {
                root = FXMLLoader.load(getClass().getResource("StockKeeperUI.fxml"));
            } catch (IOException ex) {
                Logger.getLogger(UserLoginController.class.getName()).log(Level.SEVERE, null, ex);
            }
            title ="STOCK POINT";
         }
         else if(designation.compareTo("Salesmen")==0)
        {   
            try {
                root = FXMLLoader.load(getClass().getResource("SalesmenUI.fxml"));
            } catch (IOException ex) {
                Logger.getLogger(UserLoginController.class.getName()).log(Level.SEVERE, null, ex);
            }
            
            title = "SALES POINT";
         }
        
        
      
        
        Scene scene = new Scene(root);
        
        Stage stage=SuperShop.getStage();
        stage.setTitle(title);
        stage.setScene(scene);
        stage.show();
        }
         else {
         
            warningLabel.setText("UserName or Password is incorrect");
         }
        
    }

    @FXML
    private void handlePasswordKeyAction(KeyEvent event) {
         pFlag=1;
        if(sFlag==1&&uFlag==1&&pFlag==1)
            LogInButton.setDisable(false);
    }
    
}
