/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.kytucxa;

import com.dht.pojo.SinhVien;
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
import javafx.scene.control.Alert;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

/**
 *
 * @author Admin
 */
public class QuanLySinhVienController implements Initializable{
    @FXML TableView<SinhVien> tableSinhVien;
    @FXML TextField txtFindSinhVien;
    
     @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        
        try {
            loadSinhVien();
            loadData("");
        } catch (SQLException ex) {
            Logger.getLogger(QuanLySinhVienController.class.getName()).log(Level.SEVERE, null, ex);
        }
        txtFindSinhVien.textProperty().addListener(es->{
            try {
                loadData(txtFindSinhVien.getText());
            } catch (SQLException ex) {
                Logger.getLogger(QuanLySinhVienController.class.getName()).log(Level.SEVERE, null, ex);
            }
        });
    }    
    
    public void loadSinhVien(){
        java.util.Date utilDate = new java.util.Date();
        java.sql.Date sqlDate = new java.sql.Date(utilDate.getTime());
        
        TableColumn colId = new TableColumn("ID");
        colId.setCellValueFactory(new PropertyValueFactory("idsinhvien"));
        
        TableColumn colName = new TableColumn("Tên Sinh Viên");
        colName.setCellValueFactory(new PropertyValueFactory("tensv"));
        
        TableColumn colGioiTinh = new TableColumn("Giới Tính");
        colGioiTinh.setCellValueFactory(new PropertyValueFactory("gioitinh"));
        
        TableColumn colNgaySinh = new TableColumn("Ngày Sinh");
        colNgaySinh.setCellValueFactory(new PropertyValueFactory("ngaysinh"));
        
        colNgaySinh.setCellFactory(column ->{ 
            TableCell <SinhVien,Date> cell =new TableCell<SinhVien,Date>(){
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
        
        TableColumn colNgayNhanPhong = new TableColumn("Ngày Nhận Phòng");
        colNgayNhanPhong.setCellValueFactory(new PropertyValueFactory("ngaynhanphong"));
        colNgayNhanPhong.setCellFactory(column ->{ 
            TableCell <SinhVien,Date> cell =new TableCell<SinhVien,Date>(){
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
        
        TableColumn colIdphong = new TableColumn("Id Phòng");
        colIdphong.setCellValueFactory(new PropertyValueFactory("phong"));
        
        colId.prefWidthProperty().bind(tableSinhVien.widthProperty().multiply(0.1));
        colName.prefWidthProperty().bind(tableSinhVien.widthProperty().multiply(0.2));
        colGioiTinh.prefWidthProperty().bind(tableSinhVien.widthProperty().multiply(0.1));
        colNgaySinh.prefWidthProperty().bind(tableSinhVien.widthProperty().multiply(0.2));
        colNgayNhanPhong.prefWidthProperty().bind(tableSinhVien.widthProperty().multiply(0.2));
        colIdphong.prefWidthProperty().bind(tableSinhVien.widthProperty().multiply(0.2));
        
        tableSinhVien.getColumns().addAll(colId,colName,colGioiTinh,colNgaySinh,colNgayNhanPhong,colIdphong);
    }
    
    public void loadData(String kw) throws SQLException{
        tableSinhVien.getItems().clear();
        tableSinhVien.setItems(FXCollections.observableArrayList(SinhVienService.getSinhVien(kw)));
    }

    public void deleteSinhVienHandler(){
        SinhVien sv = tableSinhVien.getSelectionModel().getSelectedItem();
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        
        String id = String.valueOf(sv.getIdsinhvien());
        String tensv = sv.getTensv();
        
        alert.setContentText("Ban co muon xoa: ID=" + id + ", Ten:  " + tensv + "?");
        alert.showAndWait().ifPresent(res -> {
            try {
                if(SinhVienService.deleleSinhVien(id) == true){
                    alert.setContentText("Đã xóa thành công");
                    try {
                        loadData("");
                    } catch (SQLException ex) {
                        Logger.getLogger(QuanLySinhVienController.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
                else
                    alert.setContentText("Xóa thất bại?Dữ liệu sinh viên có thể đang được dùng");
            } catch (SQLException ex) {
                Logger.getLogger(QuanLySinhVienController.class.getName()).log(Level.SEVERE, null, ex);
            }
            alert.show();
        });
        
    }
    
    public void refreshTableHandler() throws SQLException{
       loadData("");
   }
}
