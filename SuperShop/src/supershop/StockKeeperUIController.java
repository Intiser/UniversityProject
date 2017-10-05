/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package supershop;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Month;
import java.time.ZonedDateTime;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventType;
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
public class StockKeeperUIController implements Initializable {

    /**
     * Initializes the controller class.
     */
    Statement statement;
    @FXML
    private TextField supplierIdField;
    @FXML
    private TextField supplierNameField;
    @FXML
    private TextField supplierContactField;
    @FXML
    private TextField supplierAddressField;
    @FXML
    private TableView<Supplier> SupplierTableView;
    @FXML
    private TableColumn<Supplier,String> supplierIDColumn;
    @FXML
    private TableColumn<Supplier, String> supplierNameColumn;
    @FXML
    private TableColumn<Supplier, String> supplierContactColumn;
    @FXML
    private TableColumn<Supplier, String> supplierAddressColumn;
    
    private ObservableList<Supplier> suppliers;
   
    @FXML
    private TextField productIdField;
    @FXML
    private TextField productNameField;
    @FXML
    private TextField productTypeField;
    @FXML
    private TextField productBuyUnitpriceField;
    @FXML
    private TextField productSupplierIdField;
    @FXML
    private TextField productSellUnitpriceField;
    @FXML
    private TextField productUnitField;
    @FXML
    private TableView<Product> ProductTableView;
    @FXML
    private TableColumn<Product, String> productIdColumn;
    @FXML
    private TableColumn<Product, String> productNameColumn;
    @FXML
    private TableColumn<Product, Number> productUnitColumn;
    
    private ObservableList<Product>products;
    @FXML
    private ListView<Supplier> SupplierListView;
    @FXML
    private ListView<Product> productListView;
    
    private ObservableList<Supplier>selectedSupplier;
    private ObservableList<Product>selectedProduct;
    @FXML
    private ListView<Price> CostView;
    private ObservableList<Price>totalcost;
    @FXML
    private TextField unitNumberProductField;
    @FXML
    private Button RemoveSupplierButton;
    @FXML
    private Button RemoveProductButton;
    @FXML
    private TableView<Suggestion> SuggestionTableView;
    private ObservableList<Suggestion>suggestions;
    @FXML
    private TableColumn<Suggestion, String> suggestionProductNameColumn;
    @FXML
    private TableColumn<Suggestion, String> suggestionProductTypeColumn;
    @FXML
    private Button DoneAddingButton;
    @FXML
    private Button SelectSupplierButton;
    @FXML
    private Button SelectProductButton;
    
    private int flags,flagp;
    @FXML
    private Button BuyButton;
    @FXML
    private TableView<EmptyProduct> EmptyProductTable;
    private ObservableList<EmptyProduct> emptyProductList;
    @FXML
    private TableColumn<EmptyProduct, String> EmptyProductIdColumn;
    @FXML
    private TableColumn<EmptyProduct, String> EmptyProductNameColumn;
    @FXML
    private TableColumn<EmptyProduct, String> EmptyProductSupplierIdColumn;
    @FXML
    private Button EmptyItemSelectbutton;
    @FXML
    private Button RemoveEmptyButton;
    @FXML
    private Button CostCountButton;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        String DB_URL ="jdbc:mysql://localhost/superstoredb";
        String DB_User="custom";
        String DB_Pass="obsecure";
        flags=0;
        flagp=0;
        
        suppliers =FXCollections.observableArrayList();
        SupplierTableView.setItems(suppliers);
        supplierIDColumn.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getSupplierID()));
        supplierNameColumn.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getSupplierName()));
        supplierContactColumn.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getSupplierContact()));
        supplierAddressColumn.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getSupplierAddress()));
        
        products= FXCollections.observableArrayList();
        ProductTableView.setItems(products);
        productIdColumn.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getProductId()));
        productNameColumn.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getProductName()));
        productUnitColumn.setCellValueFactory(cellData -> new SimpleIntegerProperty(cellData.getValue().getUnit()));
        
        suggestions = FXCollections.observableArrayList();
        SuggestionTableView.setItems(suggestions);
        suggestionProductNameColumn.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getProductName()));
        suggestionProductTypeColumn.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getProductType()) );
        
        totalcost=FXCollections.observableArrayList();
        CostView.setItems(totalcost);
        
        emptyProductList = FXCollections.observableArrayList();
        EmptyProductTable.setItems(emptyProductList);
        EmptyProductIdColumn.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getProductId()));
        EmptyProductNameColumn.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getProductName()));
        EmptyProductSupplierIdColumn.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getSupplierId()));
        
        
        try {
            Connection connection =DriverManager.getConnection(DB_URL, DB_User, DB_Pass);
            statement =connection.createStatement();
            String query ="select * from Supplier";
            
            ResultSet resultset = statement.executeQuery(query);
            
            while(resultset.next())
            {
                 String id = resultset.getString("supplierID");
                 String name = resultset.getString("supplierName");
                 String contact=resultset.getString("supplierContact");
                 String address = resultset.getString("supplierAddress");
                
                 Supplier s = new Supplier(id,name,contact,address);
                 
                 suppliers.add(s);
            
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
            
            products.add(p);
            
            }
            String query3="select * from Suggestion";
            ResultSet resultset3 = statement.executeQuery(query3);
            
            while(resultset3.next())
            {
            String sName =resultset3.getString("productName");
            String sType= resultset3.getString("productType");
            
            Suggestion s1 = new Suggestion(sName,sType);
            
            suggestions.add(s1);
            }
            
            String query4="select * from EmptyProduct";
            ResultSet resultset4 = statement.executeQuery(query4);
            
            while(resultset4.next())
            {
                 String eId = resultset4.getString("productId");
            String eName= resultset4.getString("productName");
            String eType= resultset4.getString("productType");
            double ebuyPrice=resultset4.getDouble("UnitPriceBuy");
            double esellPrice=resultset4.getDouble("UnitPriceSell");
            int eUnit =resultset4.getInt("Unit");
            String eSupplier = resultset4.getString("supplierId");
            
            EmptyProduct e=new EmptyProduct(eId,eName,eType,ebuyPrice,esellPrice,eUnit,eSupplier);
             
            emptyProductList.add(e);
                
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(StockKeeperUIController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }    

    @FXML
    private void handleSupplierAddAction(ActionEvent event) {
        String Id=supplierIdField.getText();
        String Name=supplierNameField.getText();
        String Contact=supplierContactField.getText();
        String Address=supplierAddressField.getText();
        
        String query ="INSERT INTO Supplier VALUES('"+Id+"','"+Name+"','"+Contact+"','"+Address+"');";
        
        Supplier s = new Supplier(Id,Name,Contact,Address);
        
        try {
            statement.execute(query);
        } catch (SQLException ex) {
            Logger.getLogger(StockKeeperUIController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
        suppliers.add(s);
        
        ClearSupplyField();
        
    }
    
    private void ClearSupplyField()
    {
    supplierIdField.setText("");
    supplierNameField.setText("");
    supplierContactField.setText("");
    supplierAddressField.setText("");
    
    }

    @FXML
    private void handleAddProductAction(ActionEvent event) {
        String Id =productIdField.getText();
        String Name =productNameField.getText();
        String Type =productTypeField.getText();
        double BuyPrice =Double.parseDouble(productBuyUnitpriceField.getText());
        double SellPrice =Double.parseDouble(productSellUnitpriceField.getText());
        int Unit =Integer.parseInt(productUnitField.getText());
        String Supplier = productSupplierIdField.getText();
        
        String query ="INSERT INTO Product VALUES('"+Id+"','"+Name+"','"+Type+"',"+BuyPrice+","+SellPrice+","+Unit+",'"+Supplier+"');";
        
        try {
            statement.execute(query);
        } catch (SQLException ex) {
            Logger.getLogger(StockKeeperUIController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
        
        Product p=new Product(Id,Name,Type,BuyPrice,SellPrice,Unit,Supplier);
        
        products.add(p);
        
         ClearProductField();
        
    }
    private void ClearProductField()
    {
    productIdField.setText("");
    productNameField.setText("");
    productTypeField.setText("");
    productBuyUnitpriceField.setText("");
    productSellUnitpriceField.setText("");
    productUnitField.setText("");
    productSupplierIdField.setText("");
    
    
    }

    @FXML
    private void handleSupplierSelectAction(ActionEvent event) {
        Supplier s =SupplierTableView.getSelectionModel().getSelectedItem();
       selectedSupplier =FXCollections.observableArrayList();
       SupplierListView.setItems(selectedSupplier);
       
       selectedSupplier.clear();
       selectedSupplier.add(0,s);
        
       RemoveSupplierButton.setDisable(true);
       SelectSupplierButton.setDisable(true);
        
        flags=1;
        if(flags==1&&flagp==1)
        BuyButton.setDisable(false);
        
    }

    @FXML
    private void handleProductSelectAction(ActionEvent event) {
        Product p = ProductTableView.getSelectionModel().getSelectedItem();
        selectedProduct = FXCollections.observableArrayList();
        productListView.setItems(selectedProduct);

        selectedProduct.clear();
        selectedProduct.add(0,p);
        SelectProductButton.setDisable(true);
        RemoveProductButton.setDisable(true);
        flagp=1;
        if(flags==1&&flagp==1)
            BuyButton.setDisable(false);
        
    }

    @FXML
    private void handleCostCountAction(ActionEvent event) {
        Product p= selectedProduct.get(0);
        int unit=Integer.parseInt( unitNumberProductField.getText());
        double total = p.getBuyUnitPrice()*(double)unit;
        Price P=new Price(total);
        totalcost.clear();
        totalcost.add(P);
        
    }

    @FXML
    private void handleClearAction(ActionEvent event) {
        totalcost.clear();
        selectedProduct.clear();
        selectedSupplier.clear();
        BuyButton.setDisable(true);
        CostCountButton.setDisable(true);
    }

    @FXML
    private void handleRemoveSupplierAction(ActionEvent event) throws SQLException {
        Supplier s1 = SupplierTableView.getSelectionModel().getSelectedItem();
        String Id = s1.getSupplierID();
        
        String query1="DELETE FROM Supplier WHERE supplierId = '"+ Id + "';";
        
         try {
            statement.execute(query1);
            suppliers.clear();
        String query ="select * from Supplier";
            
            ResultSet resultset = statement.executeQuery(query);
            
            while(resultset.next())
            {
                 String id = resultset.getString("supplierID");
                 String name = resultset.getString("supplierName");
                 String contact=resultset.getString("supplierContact");
                 String address = resultset.getString("supplierAddress");
                
                 Supplier s = new Supplier(id,name,contact,address);
                 
                 suppliers.add(s);
            
            }
        } catch (SQLException ex) {
            Logger.getLogger(StockKeeperUIController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
        
        RemoveSupplierButton.setDisable(true);
    }

    @FXML
    private void handleMouseClickSupplierAction(MouseEvent event) {
        RemoveSupplierButton.setDisable(false);
        SelectSupplierButton.setDisable(false);
    }

    @FXML
    private void handleProductSelectionAction(MouseEvent event) {
        RemoveProductButton.setDisable(false);
        SelectProductButton.setDisable(false);
    }

    @FXML
    private void handleRemoveProductAction(ActionEvent event) throws SQLException {
        Product P = ProductTableView.getSelectionModel().getSelectedItem();
        String pId = P.getProductId();
        
        String query1="DELETE FROM Product WHERE productId = '"+ pId + "';";
        
        try {
            statement.execute(query1);
              
        } catch (SQLException ex) {
            Logger.getLogger(StockKeeperUIController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
       products.clear();
        String query2 ="select * from Product";
            ResultSet resultset2;
        try {
            resultset2 = statement.executeQuery(query2);
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
            
            products.add(p);
            }
        } catch (SQLException ex) {
            Logger.getLogger(StockKeeperUIController.class.getName()).log(Level.SEVERE, null, ex);
        }
            
          RemoveProductButton.setDisable(true);
        
    }

    @FXML
    private void handleSuggestionSelectaction(MouseEvent event) {
          DoneAddingButton.setDisable(false);
    }

    @FXML
    private void handleRemoveSuggestionAction(ActionEvent event) {
        Suggestion S = SuggestionTableView.getSelectionModel().getSelectedItem();
        String SName = S.getProductName();
        
        String query ="DELETE FROM Suggestion WHERE productName = '"+ SName + "';";
    
        try {
            statement.execute(query);
        } catch (SQLException ex) {
            Logger.getLogger(StockKeeperUIController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        suggestions.clear();
        
        
        String query3="select * from Suggestion";
            ResultSet resultset3;
        try {
            resultset3 = statement.executeQuery(query3);
             while(resultset3.next())
            {
            String sName =resultset3.getString("productName");
            String sType= resultset3.getString("productType");
            
            Suggestion s1 = new Suggestion(sName,sType);
            
            suggestions.add(s1);
            }
        } catch (SQLException ex) {
            Logger.getLogger(StockKeeperUIController.class.getName()).log(Level.SEVERE, null, ex);
        }
            
           
        DoneAddingButton.setDisable(true);
        
    
    }

    @FXML
    private void handleBuyAction(ActionEvent event) {
        Product P =selectedProduct.get(0);
        String pId =P.getProductId();
        String pName=P.getProductName();
        String pType =P.getProducttype();
        double pBuyprice=P.getBuyUnitPrice();
        double pSellprice =P.getSellUnitPrice();
        int pUnit = P.getUnit();
        String pSupplier = P.getSupplierId();
        
        
        
        int BuyingUnit= Integer.parseInt(unitNumberProductField.getText());
         
        int newUnit=BuyingUnit+pUnit;
        
        String last="DELETE FROM Product WHERE productId = '"+ pId + "';";
        
        try {
            statement.execute(last);
        } catch (SQLException ex) {
            Logger.getLogger(StockKeeperUIController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        String latest ="INSERT INTO Product VALUES('"+pId+"','"+pName+"','"+pType+"',"+pBuyprice+","+pSellprice+","+newUnit+",'"+pSupplier+"');";
        
        try {
            statement.execute(latest);
        } catch (SQLException ex) {
            Logger.getLogger(StockKeeperUIController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
         products.clear();
        String query2 ="select * from Product";
            ResultSet resultset2;
        try {
            resultset2 = statement.executeQuery(query2);
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
            
            products.add(p);
            }
        } catch (SQLException ex) {
            Logger.getLogger(StockKeeperUIController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
       String time  = LocalDateTime.now().toString();
       Supplier S = selectedSupplier.get(0);
       String id = S.getSupplierID();
       String name =S.getSupplierName();
       double total= BuyingUnit*pBuyprice;
       
       String insert ="INSERT INTO Buy VALUES('"+time+"','"+id+"','"+name+"','"+pId+"','"+pName+"',"+BuyingUnit+","+pBuyprice+","+total+");";
       
        try {
            statement.execute(insert);
        } catch (SQLException ex) {
            Logger.getLogger(StockKeeperUIController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        unitNumberProductField.setText("");
        totalcost.clear();
        selectedProduct.clear();
        selectedSupplier.clear();
        BuyButton.setDisable(true);
        CostCountButton.setDisable(true);
       
    }

    @FXML
    private void handleEmptyProductClickAction(MouseEvent event) {
        RemoveEmptyButton.setDisable(false);
        EmptyItemSelectbutton.setDisable(false);
    }

    @FXML
    private void handleSelectEmptyProductAction(ActionEvent event) {
    EmptyProduct e = EmptyProductTable.getSelectionModel().getSelectedItem();
        String Id =e.getProductId();
        String Name=e.getProductName();
        String Type =e.getProducttype();
        double Buyprice=e.getBuyUnitPrice();
        double Sellprice =e.getSellUnitPrice();
        int Unit = e.getUnit();
        String Supplier = e.getSupplierId();
    
    
    Product p =new Product(Id,Name,Type,Buyprice,Sellprice,Unit,Supplier);
    
       selectedProduct = FXCollections.observableArrayList();
        productListView.setItems(selectedProduct);
    
    selectedProduct.add(p);
    
     flagp=1;
        if(flags==1&&flagp==1)
            BuyButton.setDisable(false);
    
    }

    @FXML
    private void handleRemoveEmptyProductAction(ActionEvent event) {
        EmptyProduct e = EmptyProductTable.getSelectionModel().getSelectedItem();
        String id = e.getProductId();
        
        String delete ="DELETE FROM EmptyProduct WHERE productId = '"+ id + "';";
    
        try {
            statement.execute(delete);
        } catch (SQLException ex) {
            Logger.getLogger(StockKeeperUIController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
         emptyProductList.clear();
        
        String query4="select * from EmptyProduct";
            ResultSet resultset4;
        try {
            resultset4 = statement.executeQuery(query4);
             while(resultset4.next())
            {
                 String eId = resultset4.getString("productId");
            String eName= resultset4.getString("productName");
            String eType= resultset4.getString("productType");
            double ebuyPrice=resultset4.getDouble("UnitPriceBuy");
            double esellPrice=resultset4.getDouble("UnitPriceSell");
            int eUnit =resultset4.getInt("Unit");
            String eSupplier = resultset4.getString("supplierId");
            
            EmptyProduct e1=new EmptyProduct(eId,eName,eType,ebuyPrice,esellPrice,eUnit,eSupplier);
             
            emptyProductList.add(e1);
                
            }
        } catch (SQLException ex) {
            Logger.getLogger(StockKeeperUIController.class.getName()).log(Level.SEVERE, null, ex);
        }
            
           
        
        
    }

    @FXML
    private void handleLogOutAction(ActionEvent event) {
        Parent root=null;
                
      
        try {
            root = FXMLLoader.load(getClass().getResource("UserLogin.fxml"));
        } catch (IOException ex) {
            Logger.getLogger(StockKeeperUIController.class.getName()).log(Level.SEVERE, null, ex);
        }
       
        
        Scene scene = new Scene(root);
        
        Stage stage = SuperShop.getStage();
        stage.setTitle("LOG IN");
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    private void handleUnitProductButKeyAction(KeyEvent event) {
        CostCountButton.setDisable(false);
    }
    
}
