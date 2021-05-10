/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.kytucxa;

import com.dht.pojo.Phong;
import com.dht.pojo.SinhVien;
import com.dht.service.PhongService;
import com.dht.service.SinhVienService;
import java.lang.annotation.Target;
import java.net.URL;
import java.sql.Date;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;

/**
 *
 * @author Admin
 */
public class AddSinhVienController implements Initializable{
    
    @FXML TextField  txtTen, txtGioiTinh;
    @FXML DatePicker dpNgaySinh, dpNgayNhanPhong;
    @FXML ChoiceBox<Phong> choicePhong;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        try {
            choicePhong.setItems(FXCollections.observableArrayList(PhongService.getPhong("")));
        } catch (SQLException ex) {
            Logger.getLogger(AddSinhVienController.class.getName()).log(Level.SEVERE, null, ex);
        }
        // listener chi nhap duoc so voi 10 ky ty
    }
    
    public void addSinhVienHandler() throws SQLException{
        String ten = txtTen.getText();
        String gioiTinh = txtGioiTinh.getText();
        
        
        
        SinhVien sv;
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        if( !ten.equals("") && !gioiTinh.equals("") && dpNgaySinh.getValue() != null &&
               dpNgayNhanPhong.getValue() != null &&  choicePhong.getValue() != null)
        {
            Date ngaySinh = Date.valueOf(dpNgaySinh.getValue());
            Date ngayNhanPhong = Date.valueOf(dpNgayNhanPhong.getValue());
           sv = new SinhVien( ten, gioiTinh, ngaySinh, ngayNhanPhong,choicePhong.getValue());
           if(SinhVienService.addSinhVien(sv)== true){
               alert.setContentText("Thêm thành công");
               clearHandler();
            }
           else alert.setContentText("Thêm thất bại, kiểm tra lại ID");
        } 
        else{
           alert.setContentText("Nhập thiếu");
        }
       alert.show();
    }
    
    public void clearHandler(){
        txtTen.setText("");
        txtGioiTinh.setText("");
    }
}
