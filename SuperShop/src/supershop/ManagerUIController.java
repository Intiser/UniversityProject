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
import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.scene.control.ListView;
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
public class ManagerUIController implements Initializable {

    Statement statement;
    @FXML
    private ComboBox<Usertype> ComboBox;
    @FXML
    private TableView<Buy> BuyTableView;
    @FXML
    private TableColumn<Buy, String> BuyProductIdColumn;
    @FXML
    private TableColumn<Buy, String> BuyProductNameColumn;
    @FXML
    private TableColumn<Buy, Number> BuyAmountColumn;
   
    private ObservableList<Buy>BuyTable;
    @FXML
    private ListView<Buy> DetailsBuy;
    private ObservableList<Buy> BuyDetails;
    @FXML
    private TableView<Sell> SellTableView;
    @FXML
    private TableColumn<Sell, String> SellProductIdColumn;
    @FXML
    private TableColumn<Sell, String> SellProductNameColumn;
    @FXML
    private TableColumn<Sell, Number> SellAmountColumn;
    
    private ObservableList<Sell>SellTable;
    @FXML
    private ListView<Sell> DetailsSell;
     private ObservableList<Sell>SellDetails;
    @FXML
    private TextField newUserIdField;
    @FXML
    private TextField newUserNameField;
    @FXML
    private PasswordField newUserPasswordField;
    @FXML
    private TextField suggestProductName;
    @FXML
    private TextField suggestProductType;
    
    
    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
         String DB_URL ="jdbc:mysql://localhost/superstoredb";
        String DB_User="custom";
        String DB_Pass="obsecure";
        
        ComboBox.getItems().addAll(Usertype.values());
        BuyTable = FXCollections.observableArrayList();
        BuyTableView.setItems(BuyTable);
        BuyProductIdColumn.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getProductId()));
        BuyProductNameColumn.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getProductName()));
        BuyAmountColumn.setCellValueFactory(cellData -> new SimpleDoubleProperty(cellData.getValue().getTotal()));
        
        SellTable = FXCollections.observableArrayList();
        SellTableView.setItems(SellTable);
        SellProductIdColumn.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getProductId()));
        SellProductNameColumn.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getProductName()));
        SellAmountColumn.setCellValueFactory(cellData -> new SimpleDoubleProperty(cellData.getValue().getTotalcost()));
        
        
        
        try {
            Connection connection = DriverManager.getConnection(DB_URL, DB_User, DB_Pass);
            statement =connection.createStatement();
            
            String query="select * from Buy";
            ResultSet resultset = statement.executeQuery(query);
            while(resultset.next())
            {
                String time= resultset.getString("time");
                String id= resultset.getString("supplierId");
                String name= resultset.getString("supplierName");
                String Pid= resultset.getString("productid");
                String Pname= resultset.getString("productName");
                int unit = resultset.getInt("unit");
                double unitprice = resultset.getDouble("unitPrice");
                double total = resultset.getDouble("totalCost");
                
                Buy b = new Buy(time,id,name,Pid,Pname,unit,unitprice,total);
                
                BuyTable.add(b);
                
            }
            
            
             String query1="select * from Sell";
            ResultSet resultset1 = statement.executeQuery(query1);
            while(resultset1.next())
            {
                String time= resultset1.getString("time");
                String id= resultset1.getString("customerId");
                String name= resultset1.getString("customerName");
                String contact= resultset1.getString("customerContact");
                String Pid= resultset1.getString("productId");
                String Pname= resultset1.getString("productName");
                int unit = resultset1.getInt("unit");
                double unitprice = resultset1.getDouble("unitPrice");
                double total = resultset1.getDouble("totalCost");
                
                Sell s = new Sell(time,id,name,contact,Pid,Pname,unit,unitprice,total);
                
                SellTable.add(s);
                
            }
            
            
            
            
        } catch (SQLException ex) {
            Logger.getLogger(ManagerUIController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
    }    

    @FXML
    private void handleSelectBuyAction(MouseEvent event) {
         BuyDetails =FXCollections.observableArrayList();
         DetailsBuy.setItems(BuyDetails);
         
         Buy b=BuyTableView.getSelectionModel().getSelectedItem();
         
         BuyDetails.add(b);
         
    }

    @FXML
    private void handleSelectSellAction(MouseEvent event) {
        SellDetails =FXCollections.observableArrayList();
         DetailsSell.setItems(SellDetails);
         
         Sell s=SellTableView.getSelectionModel().getSelectedItem();
         
         SellDetails.add(s);
    }

    @FXML
    private void handleLogOutAction(ActionEvent event) {
        Parent root=null;
                
        try {
            root = FXMLLoader.load(getClass().getResource("UserLogin.fxml"));
        } catch (IOException ex) {
            Logger.getLogger(ManagerUIController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        Scene scene = new Scene(root);
        
        Stage stage = SuperShop.getStage();
        stage.setTitle("LOG IN");
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    private void handleBuyClearActiion(ActionEvent event) {
        BuyDetails.clear();
    }

    @FXML
    private void handleSellClearActiion(ActionEvent event) {
        SellDetails.clear();
    }

    @FXML
    private void handleNewUserAddAction(ActionEvent event) {
        String designation = ComboBox.getSelectionModel().getSelectedItem().toString();
        String id = newUserIdField.getText();
        String name = newUserNameField.getText();
        String pass = newUserPasswordField.getText();
        
        String insert ="INSERT INTO User VALUES('"+designation+"','"+id+"','"+name+"','"+pass+"');";
        
        try {
            statement.execute(insert);
        } catch (SQLException ex) {
            Logger.getLogger(ManagerUIController.class.getName()).log(Level.SEVERE, null, ex);    
        }
        
        newUserIdField.setText("");
        newUserNameField.setText("");
        newUserPasswordField.setText("");
        
    }

    @FXML
    private void handleSuggestionAddAction(ActionEvent event) {
        String query ="INSERT INTO Suggestion VALUES('"+suggestProductName.getText()+"','"+suggestProductType.getText()+"');";
        
        try {
            statement.execute(query);
        } catch (SQLException ex) {
            Logger.getLogger(ManagerUIController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        suggestProductName.setText("");
        suggestProductType.setText("");
    }

    

   

   
}
