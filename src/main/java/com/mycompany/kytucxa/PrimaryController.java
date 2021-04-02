package com.mycompany.kytucxa;

import java.io.IOException;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

public class PrimaryController {

    @FXML
    private TextField userName;
    @FXML
    private PasswordField password;
    
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
