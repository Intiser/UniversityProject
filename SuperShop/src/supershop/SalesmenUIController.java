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
import java.time.LocalDateTime;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleIntegerProperty;
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
import javafx.scene.control.ListView;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Ahsan
 */
public class SalesmenUIController implements Initializable {
    @FXML
    private TextField customerIdField;
    @FXML
    private TextField customerNameField;
    @FXML
    private TextField customerContactField;

    Statement statement;
    @FXML
    private TableView<Customer> customerTableView;
    @FXML
    private TableColumn<Customer, String> customerIdColumn;
    @FXML
    private TableColumn<Customer, String> customerNameColumn;
    @FXML
    private TableColumn<Customer, String> customerContactColumn;
    
    private ObservableList<Customer>customers;
    @FXML
    private TableView<Product> ProductTableView;
    @FXML
    private TableColumn<Product, String> productIdColumn;
    @FXML
    private TableColumn<Product, String> productNameColumn;
    
    private ObservableList<Product>products;
    @FXML
    private ListView<Customer> CustomerListView;
    private ObservableList<Customer>customer;
    @FXML
    private TextField itemQuantityField;
    @FXML
    private TableView<Product> SellingTableView;
    @FXML
    private TableColumn<Product, String> sellingProductIdColumn;
    @FXML
    private TableColumn<Product, String> sellingProductNameColumn;
    @FXML
    private TableColumn<Product, Number> sellingProductUnitPriceColumn;
    @FXML
    private TableColumn<Product, Number> sellingProductUnitColumn;
    
    private ObservableList<Product>sellingProducts;
    @FXML
    private Button AddToSellItemsButton;
    
    private int Clickflag,keyflag,index;
    private int productIndex,customerIndex;
   
    @FXML
    private ListView<Price> PriceView;
    
    private ObservableList<Price>totalprice;
    @FXML
    private Button RemoveCustomerButton;
    @FXML
    private Button SellButton;
   
     private int Flagc,Flagp;
    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        Clickflag=0; Flagp=0; Flagc=0;
        keyflag=0;
        index=0;
         productIndex=0;
         customerIndex=0;
        String DB_URL ="jdbc:mysql://localhost/superstoredb";
        String DB_User="custom";
        String DB_Pass="obsecure";
        
        customers = FXCollections.observableArrayList();
        customerTableView.setItems(customers);
        customerIdColumn.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getCustomerID()));
        customerNameColumn.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getCutomerName())); 
        customerContactColumn.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getCustomerContact()));
        
        products =FXCollections.observableArrayList();
        ProductTableView.setItems(products);
        productIdColumn.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getProductId()));
        productNameColumn.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getProductName()));
        
        sellingProducts=FXCollections.observableArrayList();
        SellingTableView.setItems(sellingProducts);
        
        totalprice=FXCollections.observableArrayList();
        PriceView.setItems(totalprice);
        
        try {
            Connection connection = DriverManager.getConnection(DB_URL, DB_User, DB_Pass);
            statement = connection.createStatement();
            
            String query ="select * from Customer";
            
            ResultSet resultset = statement.executeQuery(query);
            
            while(resultset.next())
            {
               String Id=resultset.getString("customerID");
               String Name=resultset.getString("customerName");
               String Contact=resultset.getString("customerContact");
               
               Customer c =new Customer(Id,Name,Contact);
               
               customers.add(customerIndex,c);
               customerIndex++;
            }
            
            String query2 ="select * from Product";
            ResultSet resultset2 = statement.executeQuery(query2);
            
            while(resultset2.next())
            {
            String Id = resultset2.getString("productId");
            String Name= resultset2.getString("productName");
            String Type= resultset2.getString("productType");
            double buyPrice=resultset2.getDouble("UnitPriceBuy");
            double sellPrice=resultset2.getDouble("UnitPriceSell");
            int Unit =resultset2.getInt("Unit");
            String Supplier = resultset2.getString("supplierId");
            
            Product p=new Product(Id,Name,Type,buyPrice,sellPrice,Unit,Supplier);
            
            products.add(productIndex,p);
            productIndex++;
            
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(SalesmenUIController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
        
        
        
        
    }    

    @FXML
    private void handleCustomerAddAction(ActionEvent event) {
        String Id =customerIdField.getText();
        String Name = customerNameField.getText();
        String Contact = customerContactField.getText();
        
        String query="INSERT INTO Customer VALUES('"+Id+"','"+Name+"','"+Contact+"');";
        
        try {
            statement.execute(query);
        } catch (SQLException ex) {
        
            Logger.getLogger(SalesmenUIController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
         Customer c =new Customer(Id,Name,Contact);
               
               customers.add(c);
        
        ClearField();
        
        
    }
    
    private void ClearField()
     {
        customerIdField.setText("");
        customerNameField.setText("");
        customerContactField.setText("");
    }

    @FXML
    private void handleSelectCustomerAction(ActionEvent event) {
        
        
        
        Customer c= customerTableView.getSelectionModel().getSelectedItem();
        String Id =c.getCustomerID();
        String Name= c.getCutomerName();
        String Contact=c.getCustomerContact();
        
        customer =FXCollections.observableArrayList();
        CustomerListView.setItems(customer);
        
        customer.clear();
        
        Customer c1 =new Customer(Id,Name,Contact);
        customer.add(0,c);
        Flagc=1;
        if(Flagc==1&&Flagp==1)
            SellButton.setDisable(false);
        
        
    }

    @FXML
    private void handleSelectItemAction(ActionEvent event) {
        Product p = ProductTableView.getSelectionModel().getSelectedItem();
        String Id = p.getProductId();
        String Name =p.getProductName();
        String Type =p.getProducttype();
        double BuyPrice = p.getBuyUnitPrice();
        double SellPrice= p.getSellUnitPrice();
        int Unit = Integer.parseInt(itemQuantityField.getText());
        String supplier = p.getSupplierId();
        
        Product P = new Product(Id,Name,Type,BuyPrice,SellPrice,Unit,supplier);
        
        
        sellingProductIdColumn.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getProductId()));
        sellingProductNameColumn.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getProductName()));
        sellingProductUnitPriceColumn.setCellValueFactory(cellData -> new SimpleDoubleProperty(cellData.getValue().getSellUnitPrice()));
        sellingProductUnitColumn.setCellValueFactory(cellData -> new SimpleIntegerProperty(cellData.getValue().getUnit()));
        //sellingProducts.add(P);
         AddToSellItemsButton.setDisable(true);
        
        sellingProducts.add(index, P);
        index++;
        Flagp=1;
        if(Flagc==1&&Flagp==1)
            SellButton.setDisable(false);
        
    }

    @FXML
    private void handleSellingItemsClearAction(ActionEvent event) {
        sellingProducts.clear();
         totalprice.clear();
        index=0;
        Flagp=0; Flagc=0;
    }

    @FXML
    private void handleSelectItemUnitKeypressAction(KeyEvent event) {
        String val = itemQuantityField.getText();
              if(val!=null)
                  keyflag=1;
              else
                  keyflag=0;
              
        
              if(keyflag==1&&Clickflag==1)        
              AddToSellItemsButton.setDisable(false);
              else
                  AddToSellItemsButton.setDisable(true);
              
              
                  
    }

    @FXML
    private void handleMouseClickProductAction(MouseEvent event) {
        Clickflag=1;
        if(keyflag==1&&Clickflag==1)        
            AddToSellItemsButton.setDisable(false);
        else
            AddToSellItemsButton.setDisable(true);
        
    }

    @FXML
    private void handleCountBillAction(ActionEvent event) {
      // int index= sellingProducts.lastIndexOf(SellingTableView);
       int i=0;
       double total=0;
       while(i<index)
       {
        Product p=sellingProducts.get(i);
        double price=p.getSellUnitPrice();
        double unit=(double)p.getUnit();
        total=total+(unit*price);
           i++;
       }
       Price P=new Price(total);
       totalprice.clear();
       totalprice.add(P);
       //System.out.println(index);
    }

    @FXML
    private void handleCustomerSelectionAction(MouseEvent event) {
        RemoveCustomerButton.setDisable(false);
    }

    @FXML
    private void handleRemoveCustomerAction(ActionEvent event) {
        Customer C = customerTableView.getSelectionModel().getSelectedItem();
        String cId =C.getCustomerID();
        
        String queryC ="DELETE FROM Customer WHERE customerId = '"+ cId + "';";
        
        try {
            statement.execute(queryC);
        } catch (SQLException ex) {
            Logger.getLogger(SalesmenUIController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        customers.clear();
        customerIndex=0;
        
         String query ="select * from Customer";
            
            ResultSet resultset;
        try {
            resultset = statement.executeQuery(query);
            while(resultset.next())
            {
               String Id=resultset.getString("customerID");
               String Name=resultset.getString("customerName");
               String Contact=resultset.getString("customerContact");
               
               Customer c =new Customer(Id,Name,Contact);
               
               customers.add(customerIndex,c);
               customerIndex++;
            }
        } catch (SQLException ex) {
            Logger.getLogger(SalesmenUIController.class.getName()).log(Level.SEVERE, null, ex);
        }
            
            
        RemoveCustomerButton.setDisable(true);
       
        
    }

    @FXML
    private void handleSellAction(ActionEvent event) {
      
         String time = LocalDateTime.now().toString();
         Customer C = customer.get(0);
         
        
        
        int i=0,f,j,unit=0,newunit;
        while(i<index)
        {
            Product P1 = sellingProducts.get(0);
            String Id =P1.getProductId();
            String Name=P1.getProductName();
            String Type =P1.getProducttype();
            double Buyprice=P1.getBuyUnitPrice();
            double Sellprice =P1.getSellUnitPrice();
            int Unit = P1.getUnit();
            String Supplier = P1.getSupplierId();
            j=0;f=0;
            String nId=null;
            while(j<productIndex&&f==0)
            {
             Product n=products.get(j);
             if(n.getProductId().compareTo(Id)==0)
             {
                  unit = n.getUnit();
                 nId=n.getProductId();
                 f=1;
                
             }
             j++;
            }
            if(f==1&&unit>=Unit)
            { String delete ="DELETE FROM Product WHERE productId = '"+ nId + "';";
             
                try {
                    statement.execute(delete);
                } catch (SQLException ex) {
                    Logger.getLogger(SalesmenUIController.class.getName()).log(Level.SEVERE, null, ex);
                }
                
                 newunit=unit - Unit;
                
                String insert ="INSERT INTO Product VALUES('"+Id+"','"+Name+"','"+Type+"',"+Buyprice+","+Sellprice+","+newunit+",'"+Supplier+"');";
            
                try {
                    statement.execute(insert);
                } catch (SQLException ex) {
                    Logger.getLogger(SalesmenUIController.class.getName()).log(Level.SEVERE, null, ex);
                }
                double total = Unit*Sellprice;
                String sell ="INSERT INTO Sell VALUES('"+time+"','"+C.getCustomerID()+"','"+C.getCutomerName()+"','"+C.getCustomerContact()+"','"+Id+"','"+Name+"',"+Unit+","+Sellprice+","+total+");";
                
                try {
                    statement.execute(sell);
                } catch (SQLException ex) {
                    Logger.getLogger(SalesmenUIController.class.getName()).log(Level.SEVERE, null, ex);
                }
                
                if(Unit==unit)
                {
                 String empty ="INSERT INTO EmptyProduct VALUES('"+Id+"','"+Name+"','"+Type+"',"+Buyprice+","+Sellprice+","+newunit+",'"+Supplier+"');";
                
                try {
                    statement.execute(empty);
                } catch (SQLException ex) {
                    Logger.getLogger(SalesmenUIController.class.getName()).log(Level.SEVERE, null, ex);
                }
                 
                }
                  
            }
            i++;
         }
        
         sellingProducts.clear();
         totalprice.clear();
          customer.clear();
        SellButton.setDisable(true);
        index=0;
    }

    @FXML
    private void handlelogOutAction(ActionEvent event) {
         Parent root=null;
                
      
        
        try {
            root = FXMLLoader.load(getClass().getResource("UserLogin.fxml"));
        } catch (IOException ex) {
            Logger.getLogger(SalesmenUIController.class.getName()).log(Level.SEVERE, null, ex);
        }
       
        
        Scene scene = new Scene(root);
        
        Stage stage = SuperShop.getStage();
        stage.setTitle("LOG IN");
        stage.setScene(scene);
        stage.show();
    }

  
    
    

    

    

   
    
}
