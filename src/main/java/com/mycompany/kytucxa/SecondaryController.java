package com.mycompany.kytucxa;

import java.io.IOException;
import java.net.URL;
import java.util.Optional;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.ButtonType;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;

public class SecondaryController {
    
    public @FXML BorderPane rootPane;
    
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
      
    }  

    public void switchToPrimary() throws IOException {
        Alert alert = new Alert(AlertType.CONFIRMATION);
        alert.setTitle("Đăng xuất");
        alert.setHeaderText("Bạn có chắc chắn muốn kết thúc phiên làm việc?");
 
        // option != null.
        Optional<ButtonType> option = alert.showAndWait();
 
        if (option.get() == ButtonType.OK) {
            App.setRoot("primary");
        }
    }
    
    public void loadUI(String UI) throws IOException{
        
        AnchorPane paneCenter = FXMLLoader.load(getClass().getResource(UI));
        rootPane.setCenter(paneCenter);    
        
    }

    
    public void loadPhongKhuNam(ActionEvent e){
        try {
            
            loadUI("phongkhunam.fxml");
        } catch (IOException ex) {
            Logger.getLogger(SecondaryController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void loadPhongKhuNu(ActionEvent e){
        
        try {
            loadUI("phongkhunu.fxml");
        } catch (IOException ex) {
            Logger.getLogger(SecondaryController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void loadQuanLySinhVien(ActionEvent e){
        
        try {
            loadUI("QuanLySinhVien.fxml");
        } catch (IOException ex) {
            Logger.getLogger(SecondaryController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void loadAddSinhVien(ActionEvent e){
        
        try {
            loadUI("AddSinhVien.fxml");
        } catch (IOException ex) {
            Logger.getLogger(SecondaryController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
        
    public void loadAddPhong(ActionEvent e){
        
        try {
            loadUI("AddPhong.fxml");
        } catch (IOException ex) {
            Logger.getLogger(SecondaryController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
     public void loadThanhToan(ActionEvent e){
        
        try {
            loadUI("ThanhToan.fxml");
        } catch (IOException ex) {
            Logger.getLogger(SecondaryController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
     
     public void loadQuanLyPhong(ActionEvent e){
        
        try {
            loadUI("QuanLyPhong.fxml");
        } catch (IOException ex) {
            Logger.getLogger(SecondaryController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    
        
        
   
}