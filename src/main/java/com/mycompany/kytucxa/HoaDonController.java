package com.mycompany.kytucxa;


import com.dht.pojo.HoaDon;
import com.dht.pojo.SinhVien;
import com.dht.service.HoaDonService;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Admin
 */
public class HoaDonController implements Initializable
{
    
    
    @FXML Label lbTenSV, lbTienDien, lbTienNuoc, lbTienPhong, lbTong;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        try {
            HoaDon hoadon = HoaDonService.getFirstHoaDon();
            
            lbTenSV.setText(hoadon.getSinhVien().getTensv());
            lbTienDien.setText(String.valueOf(hoadon.getTienDien()));
            lbTienNuoc.setText(String.valueOf(hoadon.getTienNuoc()));
            lbTienPhong.setText(String.valueOf(hoadon.getTienPhong()));
            lbTong.setText(String.valueOf(hoadon.getTienDien() + hoadon.getTienNuoc()+ hoadon.getTienPhong()));
            
        } catch (SQLException ex) {
            Logger.getLogger(HoaDonController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    

    
    
    
}
