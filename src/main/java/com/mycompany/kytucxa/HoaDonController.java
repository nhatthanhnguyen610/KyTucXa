package com.mycompany.kytucxa;


import com.dht.pojo.HoaDon;
import com.dht.pojo.SinhVien;
import com.dht.service.HoaDonService;
import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.text.DecimalFormat;
import java.util.Optional;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import com.mycompany.kytucxa.SecondaryController;

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
            DecimalFormat formatter = new DecimalFormat("###,###,###");

            HoaDon hoadon = HoaDonService.getFirstHoaDon();
            
            lbTenSV.setText(hoadon.getSinhVien().getTensv());
            lbTienDien.setText(formatter.format(hoadon.getTienDien())+"VNĐ");
            lbTienNuoc.setText(formatter.format(hoadon.getTienNuoc())+"VNĐ");
            lbTienPhong.setText(formatter.format(hoadon.getTienPhong())+"VNĐ");
            lbTong.setText(formatter.format(hoadon.getTienDien() + hoadon.getTienNuoc()+ hoadon.getTienPhong())+ "VND");
            
        } catch (SQLException ex) {
            Logger.getLogger(HoaDonController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
        
    
}
