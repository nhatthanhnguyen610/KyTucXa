package com.mycompany.kytucxa;

import java.io.IOException;
import java.util.Optional;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.ButtonType;
import javafx.scene.layout.AnchorPane;

public class SecondaryController {

    @FXML
    private AnchorPane khuNam;
    @FXML
    private AnchorPane khuNu;
    
    public void danhsachNam() throws IOException{
        khuNam.setVisible(true);
        khuNu.setVisible(false);
    }
    public void danhsachNu() throws IOException{
        khuNam.setVisible(false);
        khuNu.setVisible(true);
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
}