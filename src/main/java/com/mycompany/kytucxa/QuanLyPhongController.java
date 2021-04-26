/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.kytucxa;

import com.dht.pojo.Phong;
import com.dht.service.PhongService;
import com.dht.service.SinhVienService;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

/**
 *
 * @author Admin
 */
public class QuanLyPhongController implements Initializable{
    
    @FXML TableView<Phong> tablePhong;
    @FXML TextField txtFindPhong;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        try {
            loadPhong();
            loadData("");
        } catch (SQLException ex) {
            Logger.getLogger(QuanLyPhongController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void loadPhong(){
        TableColumn colId = new TableColumn("ID");
        colId.setCellValueFactory(new PropertyValueFactory("idphong"));
        
        TableColumn colTenPhong = new TableColumn("Tên Phòng");
        colTenPhong.setCellValueFactory(new PropertyValueFactory("tenphong"));
        
        TableColumn colLoaiPhong = new TableColumn("Loại phòng");
        colLoaiPhong.setCellValueFactory(new PropertyValueFactory("loaiphong"));
        
        colId.prefWidthProperty().bind(tablePhong.widthProperty().multiply(0.1));
        colTenPhong.prefWidthProperty().bind(tablePhong.widthProperty().multiply(0.2));
        colLoaiPhong.prefWidthProperty().bind(tablePhong.widthProperty().multiply(0.1));
        
        tablePhong.getColumns().addAll(colId,colTenPhong,colLoaiPhong);
    }
    
    public void loadData(String kw) throws SQLException{
        tablePhong.getItems().clear();
        tablePhong.setItems(FXCollections.observableArrayList(PhongService.getPhong(kw)));
    }
    
    public void deletePhongHandler(){
        Phong phong = tablePhong.getSelectionModel().getSelectedItem();
        String id = String.valueOf(phong.getIdphong());
        String tenPhong = phong.getTenphong();
        
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setContentText("Ban co muon xoa: ID=" + id + ", Ten:  " + tenPhong + "?");
        alert.showAndWait().ifPresent(res -> {
            try{
                if(PhongService.delelePhong(id) == true){
                    alert.setContentText("Xóa thành công");
                    loadData("");
                   }
                else alert.setContentText("Xóa thất bại? dữ liệu sinh vien muốn xóa có thể đang được sử dụng");
            }catch (SQLException ex) {
               Logger.getLogger(QuanLyPhongController.class.getName()).log(Level.SEVERE, null, ex);
           }
        });
    }
    
    public void refreshTableHandler() throws SQLException{
       loadData("");
   }
}
