/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.kytucxa;

import com.dht.pojo.NguoiDangKi;
import com.dht.pojo.SinhVien;
import com.dht.service.NguoiDangKiService;
import com.dht.service.PhongService;
import com.dht.service.SinhVienService;
import java.net.URL;
import java.sql.Date;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

/**
 *
 * @author Admin
 */
public class DanhSachNguoiDangKiController implements Initializable {
    @FXML TableView<NguoiDangKi> tableNguoiDangKi;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        try {
            loadNguoiDangKi();
            loadData("");
        } catch (SQLException ex) {
            Logger.getLogger(DanhSachNguoiDangKiController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void loadNguoiDangKi(){
        java.util.Date utilDate = new java.util.Date();
        java.sql.Date sqlDate = new java.sql.Date(utilDate.getTime());
        
        TableColumn colId = new TableColumn("ID");
        colId.setCellValueFactory(new PropertyValueFactory("idNguoiDangKi"));
        
        TableColumn colName = new TableColumn("Họ Tên");
        colName.setCellValueFactory(new PropertyValueFactory("hoTen"));
        
        TableColumn colNgaySinh = new TableColumn("Ngày Sinh");
        colNgaySinh.setCellValueFactory(new PropertyValueFactory("ngaySinh"));
        
        colNgaySinh.setCellFactory(column ->{ 
            TableCell <NguoiDangKi,Date> cell =new TableCell<NguoiDangKi,Date>(){
                private final SimpleDateFormat f = new SimpleDateFormat("dd/MM/yyyy");
                @Override
                public void updateItem(Date item, boolean empty){
                    super.updateItem(item, empty);
                    if(empty){
                        setText(null);
                    }
                    else
                        setText(f.format(item));
                }                      
             };
            return cell;
        });
        
        TableColumn colCMND = new TableColumn("CMND");
        colCMND.setCellValueFactory(new PropertyValueFactory("CMND"));
        
        TableColumn colSDT = new TableColumn("SDT");
        colSDT.setCellValueFactory(new PropertyValueFactory("SDT"));
        
        TableColumn colQueQuan = new TableColumn("Quê Quán");
        colQueQuan.setCellValueFactory(new PropertyValueFactory("queQuan"));
        
        colId.prefWidthProperty().bind(tableNguoiDangKi.widthProperty().multiply(0.1));
        colName.prefWidthProperty().bind(tableNguoiDangKi.widthProperty().multiply(0.2));
        colNgaySinh.prefWidthProperty().bind(tableNguoiDangKi.widthProperty().multiply(0.1));
        colCMND.prefWidthProperty().bind(tableNguoiDangKi.widthProperty().multiply(0.2));
        colSDT.prefWidthProperty().bind(tableNguoiDangKi.widthProperty().multiply(0.2));
        colQueQuan.prefWidthProperty().bind(tableNguoiDangKi.widthProperty().multiply(0.2));
        
        tableNguoiDangKi.getColumns().addAll(colId,colName,colNgaySinh, colCMND, colSDT, colQueQuan);
    }
    
    public void loadData(String kw) throws SQLException{
        tableNguoiDangKi.getItems().clear();
        tableNguoiDangKi.setItems(FXCollections.observableArrayList(NguoiDangKiService.getNguoiDangKi(kw)));
    }
}
