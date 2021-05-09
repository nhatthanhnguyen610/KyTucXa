/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.kytucxa;

import com.dht.pojo.Phong;
import com.dht.service.PhongService;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;

/**
 *
 * @author Admin
 */
public class AddPhongController implements Initializable{
    @FXML TextField txtIdPhong;
    @FXML TextField txtTenPhong;
    @FXML TextField txtLoaiPhong;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
            // listener chi nhap duoc so 10 ky tu
        txtIdPhong.textProperty().addListener(new ChangeListener<String>(){
            @Override
            public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue){
                if(!newValue.matches("\\d{0,10}"))
                    txtIdPhong.setText(oldValue);
            }
        });
    }
    
    public void addPhongHandler(){
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        Phong phong = new Phong();
        String name = txtTenPhong.getText();
        String loaiPhong = txtLoaiPhong.getText();        
        if(!name.equals("")&& !loaiPhong.equals("")){
            phong.setTenphong(name);
            phong.setLoaiphong(loaiPhong);
            phong.setIdphong(Integer.parseInt(txtIdPhong.getText()));
            if(PhongService.addPhong(phong) == true)
            {
                
                alert.setContentText("Đã thêm. Hay refresh lại quản lý phòng");
            }
            else alert.setContentText("Lỗi");
        }
        else{
            alert.setContentText("Nhập thiếu!");
        }
        alert.show();
    }
    
    public void clearHandler(){
        txtIdPhong.setText("");
        txtTenPhong.setText("");
        txtLoaiPhong.setText("");
    }
}
