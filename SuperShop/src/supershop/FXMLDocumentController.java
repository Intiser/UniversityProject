/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package supershop;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.stage.Stage;

/**
 *
 * @author Ahsan
 */
public class FXMLDocumentController implements Initializable {
    
   
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void handleProductAction(ActionEvent event) {
        Parent root=null;
        try {
            root = FXMLLoader.load(getClass().getResource("ProductUI.fxml"));
        } catch (IOException ex) {
            Logger.getLogger(FXMLDocumentController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        Scene scene = new Scene(root);
        
        Stage stage=SuperShop.getStage();
        stage.setScene(scene);
        stage.show();
        
    }

    @FXML
    private void handleCloseAction(ActionEvent event) {
        System.exit(0);
    }

    @FXML
    private void handleSupplierAction(ActionEvent event) {
        Parent root=null;
        Parent root1=null;
        try {
            root = FXMLLoader.load(getClass().getResource("SupplierUI.fxml"));
        } catch (IOException ex) {
            Logger.getLogger(FXMLDocumentController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        try {
            root1 = FXMLLoader.load(getClass().getResource("FXMLDocument.fxml"));
        } catch (IOException ex) {
            Logger.getLogger(FXMLDocumentController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        Scene scene = new Scene(root);
        Scene scene1=new Scene(root1); 
        Stage stage =SuperShop.getStage();
         Stage stage1 =SuperShop.getStage();
        stage.setScene(scene);
        stage.show();
        stage1.setScene(scene1);
        stage1.show();
        
    }
    
}
