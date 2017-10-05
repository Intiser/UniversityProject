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
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

 

/**
 * FXML Controller class
 *
 * @author Ahsan
 */
public class AdminUIController implements Initializable {

    Statement statement;
    @FXML
    private TableView<Users> UserTableView;
    @FXML
    private TableColumn<Users, String> DesignationColumn;
    @FXML
    private TableColumn<Users, String> UserIdColumn;
    @FXML
    private TableColumn<Users, String> UserNameColumn;
    
    private ObservableList<Users>users;
    @FXML
    private ComboBox<User> EditBox;
    @FXML
    private TextField EditId;
    @FXML
    private TextField EditName;
    @FXML
    private Button UpdateButton;
    @FXML
    private PasswordField EditPassField;
    @FXML
    private ComboBox<User> CreateBox;
    @FXML
    private TextField UserIdField;
    @FXML
    private TextField UserNameField;
    @FXML
    private PasswordField UserPasswordField;
    @FXML
    private Button RemoveButton;
    @FXML
    private Button SelectButton;
     
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        EditBox.getItems().addAll(User.values());
        CreateBox.getItems().addAll(User.values());
         
          String DB_URL ="jdbc:mysql://localhost/superstoredb";
        String DB_User="custom";
        String DB_Pass="obsecure";
        
        users =FXCollections.observableArrayList();
        UserTableView.setItems(users);
        DesignationColumn.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getDesignation()));
        
        UserIdColumn.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getUserId()));
        UserNameColumn.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getUserName()));
        
        try {
            Connection connection =DriverManager.getConnection(DB_URL, DB_User, DB_Pass);
            statement = connection.createStatement();
            
            String query ="select * from User";

            ResultSet resultset=statement.executeQuery(query);
            
            while(resultset.next())
            {
              String post = resultset.getString("designation");
              String id   = resultset.getString("userId");
              String name = resultset.getString("userName");
              String pass = resultset.getString("userPassword");
              
              Users u = new Users(post,id,name,pass);
              
              users.add(u);
              
            }
             
            
        } catch (SQLException ex) {
            Logger.getLogger(AdminUIController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }    

    @FXML
    private void handleManagerViewAction(ActionEvent event) {
         Parent root= null;
                
        try {
            root = FXMLLoader.load(getClass().getResource("ManagerUI.fxml"));
        } catch (IOException ex) {
            Logger.getLogger(AdminUIController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        Scene scene = new Scene(root);
        
        Stage stage=SuperShop.getStage();
        stage.setTitle("MONITORING POINT");
        stage.setScene(scene);
        stage.show();
        
        
    }

    @FXML
    private void handleStockKeeperViewAction(ActionEvent event) {
         Parent root= null;
                
        try {
            root = FXMLLoader.load(getClass().getResource("StockKeeperUI.fxml"));
        } catch (IOException ex) {
            Logger.getLogger(AdminUIController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        Scene scene = new Scene(root);
        
        Stage stage=SuperShop.getStage();
        stage.setTitle("STOCK POINT");
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    private void handleSalesmenViewAction(ActionEvent event) {
         Parent root= null;
                
        try {
            root = FXMLLoader.load(getClass().getResource("SalesmenUI.fxml"));
        } catch (IOException ex) {
            Logger.getLogger(AdminUIController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        Scene scene = new Scene(root);
        
        Stage stage=SuperShop.getStage();
        stage.setTitle("SALES POINT");
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    private void handleLogOutAction(ActionEvent event) {
        Parent root= null;
                
        try {
            root = FXMLLoader.load(getClass().getResource("UserLogin.fxml"));
        } catch (IOException ex) {
            Logger.getLogger(AdminUIController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        Scene scene = new Scene(root);
        
        Stage stage=SuperShop.getStage();
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    private void handleSelectAction(MouseEvent event) {
        RemoveButton.setDisable(false);
        SelectButton.setDisable(false);
        
    }

    @FXML
    private void handleUserUpdateAction(ActionEvent event) {
         String id = EditId.getText();
         String name = EditName.getText();
         String pass=  EditPassField.getText();
         String designation = EditBox.getSelectionModel().getSelectedItem().toString();
          Users u = UserTableView.getSelectionModel().getSelectedItem();
        String Id = u.getUserId();
         
         String delete ="DELETE FROM User WHERE  userId ='"+Id+"';";
         
        try {
            statement.execute(delete);
        } catch (SQLException ex) {
            Logger.getLogger(AdminUIController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
         String insert ="INSERT INTO User VALUES('"+designation+"','"+id+"','"+name+"','"+pass+"');";
        
        try {
            statement.execute(insert);
        } catch (SQLException ex) {
            Logger.getLogger(AdminUIController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
          EditId.setText("");
          EditName.setText("");
          EditPassField.setText("");
         
          users.clear();
          
          String query ="select * from User";

            ResultSet resultset;
        try {
            resultset = statement.executeQuery(query);
             while(resultset.next())
            {
              String post = resultset.getString("designation");
              String uid   = resultset.getString("userId");
              String uname = resultset.getString("userName");
              String upass = resultset.getString("userPassword");
              
              Users u1 = new Users(post,uid,uname,upass);
              
              users.add(u1);
              
            }
        } catch (SQLException ex) {
            Logger.getLogger(AdminUIController.class.getName()).log(Level.SEVERE, null, ex);
        }
            
           
          
          
          
    }

    @FXML
    private void handleAddAction(ActionEvent event) {
        String post = CreateBox.getSelectionModel().getSelectedItem().toString();
        String id = UserIdField.getText();        
        String name = UserNameField.getText();
        String pass = UserPasswordField.getText();
        
        String insert ="INSERT INTO User VALUES('"+post+"','"+id+"','"+name+"','"+pass+"');";
        
        try {
            statement.execute(insert);
        } catch (SQLException ex) {
            Logger.getLogger(AdminUIController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        UserIdField.setText("");
        UserNameField.setText("");
        UserPasswordField.setText("");
        
         users.clear();
          
          String query ="select * from User";

            ResultSet resultset;
        try {
            resultset = statement.executeQuery(query);
             while(resultset.next())
            {
              String upost = resultset.getString("designation");
              String uid   = resultset.getString("userId");
              String uname = resultset.getString("userName");
              String upass = resultset.getString("userPassword");
              
              Users u1 = new Users(upost,uid,uname,upass);
              
              users.add(u1);
              
            }
        } catch (SQLException ex) {
            Logger.getLogger(AdminUIController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
    }

    @FXML
    private void handleRemoveAction(ActionEvent event) {
        Users u = UserTableView.getSelectionModel().getSelectedItem();
        String Id = u.getUserId();
         
        String delete ="DELETE FROM User WHERE  userId ='"+Id+"';";
        
        try {
            statement.execute(delete);
        } catch (SQLException ex) {
            Logger.getLogger(AdminUIController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        users.clear();
          
          String query ="select * from User";

            ResultSet resultset;
        try {
            resultset = statement.executeQuery(query);
             while(resultset.next())
            {
              String upost = resultset.getString("designation");
              String uid   = resultset.getString("userId");
              String uname = resultset.getString("userName");
              String upass = resultset.getString("userPassword");
              
              Users u1 = new Users(upost,uid,uname,upass);
              
              users.add(u1);
              
            }
        } catch (SQLException ex) {
            Logger.getLogger(AdminUIController.class.getName()).log(Level.SEVERE, null, ex);
        }
         
    }

   

    @FXML
    private void handleSelecUsertAction(ActionEvent event) {
         Users u = UserTableView.getSelectionModel().getSelectedItem();
        String id = u.getUserId();
        String name = u.getUserName();
        String pass= u.getUserPassword();
       
        
        EditId.setText(id);
        EditName.setText(name);
        EditPassField.setText(pass);
        UpdateButton.setDisable(false);
        
    }
    
}
