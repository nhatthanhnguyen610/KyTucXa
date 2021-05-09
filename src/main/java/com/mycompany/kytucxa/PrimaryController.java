package com.mycompany.kytucxa;

import com.dht.pojo.NguoiDangKi;
import com.dht.service.Utils;
import com.dht.service.NguoiDangKiService;
import java.io.IOException;
import java.math.BigDecimal;
import java.net.URL;
import java.sql.Connection;
import java.sql.Date;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.DatePicker;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

public class PrimaryController implements Initializable{
    @FXML TextField txtHoTen, txtCMND, txtSDT, txtQueQuan;
    @FXML DatePicker datePickerNgaySinh;

    @FXML
    private TextField userName;
    @FXML
    private PasswordField password;
    @FXML
    private HBox lbDangKy;
    @FXML
    private VBox lbDangNhap;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        txtCMND.textProperty().addListener(new ChangeListener<String>(){
            @Override
            public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue){
                if(!newValue.matches("\\d{0,10}"))
                    txtCMND.setText(oldValue);
            }
        });
        
        txtSDT.textProperty().addListener(new ChangeListener<String>(){
            @Override
            public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue){
                if(!newValue.matches("\\d{0,10}"))
                    txtSDT.setText(oldValue);
            }
        });
    }
    
    public void trangDangKy() throws IOException {
        lbDangKy.setVisible(true);
        lbDangNhap.setVisible(false);
    }
    public void trangDangNhap() throws IOException {
        lbDangKy.setVisible(false);
        lbDangNhap.setVisible(true);
    }
    public void switchToSecondary() throws IOException {
        if (userName.getText().equals("admin") && password.getText().equals("admin"))
            App.setRoot("second");
        else
        {
            Alert a = new Alert(Alert.AlertType.WARNING);
            a.setContentText("Sai tên đăng nhập hoặc mật khẩu");
            a.show();
        }
            
    }
    
    
    public void addNguoiDangKiHandler(ActionEvent evt) throws SQLException{
       
       String ten =txtHoTen.getText();      
       Date ngaySinh =Date.valueOf(datePickerNgaySinh.getValue());      
       String CMND = txtCMND.getText();
       String SDT = txtSDT.getText();
       String queQuan = txtQueQuan.getText();
       
       NguoiDangKi ndk = null;
       Alert alert = new Alert(Alert.AlertType.INFORMATION);
       
       if(!ten.equals(""))
       {
           ndk = new NguoiDangKi(ten, ngaySinh, CMND, SDT, queQuan);
           if(NguoiDangKiService.addNguoiDangKi(ndk)== true){
               alert.setContentText("Thêm thành công");
               clearHandler();
            }
           else alert.setContentText("Thêm thất bại, kiểm tra lại ID");
       } 
       else
           alert.setContentText("Nhập thiếu");
       alert.show();
    }
    public void clearHandler(){
        datePickerNgaySinh.setValue(LocalDate.EPOCH);
        txtHoTen.setText("");
        txtCMND.setText("");
        txtQueQuan.setText("");
        txtSDT.setText("");
    }

    
    
    
}
