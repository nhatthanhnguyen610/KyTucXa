/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.kytucxa;

import com.dht.pojo.HoaDon;
import com.dht.pojo.Phong;
import com.dht.pojo.SinhVien;
import com.dht.service.HoaDonService;
import com.dht.service.PhongService;
import com.dht.service.SinhVienService;
import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

/**
 *
 * @author Admin
 */
public class ThanhToanController implements Initializable{
    
    @FXML TextField txtTienPhong, txtSoDien, txtSoNuoc;
    @FXML ChoiceBox<SinhVien> choiceBoxSinhVien;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        try {
            choiceBoxSinhVien.setItems(FXCollections.observableArrayList(SinhVienService.getSinhVien("")));
        } catch (SQLException ex) {
            Logger.getLogger(ThanhToanController.class.getName()).log(Level.SEVERE, null, ex);
        }
        // listener chi nhap duoc so voi 10 ky ty
         
          txtTienPhong.textProperty().addListener(new ChangeListener<String>(){
            @Override
            public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue){
                if(!newValue.matches("\\d{0,10}"))
                    txtTienPhong.setText(oldValue);
            }
          });
          txtSoDien.textProperty().addListener(new ChangeListener<String>(){
            @Override
            public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue){
                if(!newValue.matches("\\d{0,10}"))
                    txtSoDien.setText(oldValue);
            }
          });
          txtSoNuoc.textProperty().addListener(new ChangeListener<String>(){
            @Override
            public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue){
                if(!newValue.matches("\\d{0,10}"))
                    txtSoNuoc.setText(oldValue);
            }
          });          
    }
    
    public void showHoaDon() throws SQLException, IOException{
        try {
            AnchorPane addHoaDon = FXMLLoader.load(getClass().getResource("HoaDon.fxml"));
            Scene scene = new Scene(addHoaDon);
        
            Stage stage = new Stage(StageStyle.DECORATED);
            stage.setTitle("Chức năng tạo hóa đơn");
            stage.setScene(scene);
            stage.initModality(Modality.WINDOW_MODAL);
            stage.showAndWait();
        } catch (IOException ex) {
            Logger.getLogger(ThanhToanController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    

    
    public void addHoaDonHandler() throws SQLException, IOException{
                                                                                                                                                     
        
        HoaDon hoadon;
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        if(!txtSoDien.getText().equals("") && !txtSoNuoc.getText().equals("") && !txtTienPhong.getText().equals("") &&
                choiceBoxSinhVien.getValue() != null)
       {
            Double tienDien = Double.parseDouble(txtSoDien.getText()) * 3500;
            Double tienNuoc = Double.parseDouble(txtSoNuoc.getText()) * 10000;
            Double tienPhong = Double.parseDouble(txtTienPhong.getText()); 
           hoadon = new HoaDon( tienPhong, tienDien, tienNuoc, choiceBoxSinhVien.getValue());
           if(HoaDonService.addHoaDon(hoadon)== true){
               showHoaDon();
               clearHandler();
            }
           else alert.setContentText("Thêm thất bại, kiểm tra lại");
       } 
       else
           alert.setContentText("Nhập thiếu");
       alert.show();
       
    }
    
     public void clearHandler(){
        txtTienPhong.setText("");
        txtSoDien.setText("");
        txtSoNuoc.setText("");
    }
     
}
