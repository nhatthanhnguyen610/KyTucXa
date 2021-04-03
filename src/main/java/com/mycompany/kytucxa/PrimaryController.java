package com.mycompany.kytucxa;

import java.io.IOException;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

public class PrimaryController {

    @FXML
    private TextField userName;
    @FXML
    private PasswordField password;
    @FXML
    private HBox lbDangKy;
    @FXML
    private VBox lbDangNhap;
    
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
            App.setRoot("secondary");
        else
        {
            Alert a = new Alert(Alert.AlertType.WARNING);
            a.setContentText("Sai tên đăng nhập hoặc mật khẩu");
            a.show();
        }
            
    }
    
}
