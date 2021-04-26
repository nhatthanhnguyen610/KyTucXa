/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dht.service;

import com.dht.pojo.Phong;
import com.dht.pojo.SinhVien;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLDataException;
import java.sql.SQLException;
import java.sql.Time;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Admin
 */
public class SinhVienService {
    
    public static List <SinhVien> getSinhVien(String kw) throws SQLException{
        
        Connection conn = Utils.getConn();
        String sql = "SELECT * FROM sinhvien";
        if(kw!=null && !kw.trim().isEmpty())
            sql += " Where idsinhvien like ?";
        
        PreparedStatement stm = conn.prepareStatement(sql);
        
        if (kw != null && !kw.trim().isEmpty())
            stm.setString(1, String.format("%%%s%%", kw.trim()));
        
        ResultSet rs = stm.executeQuery();
        
        List <SinhVien> listSinhVien = new ArrayList();
       while(rs.next()){
           int id =  rs.getInt("idsinhvien");
           String name = rs.getString("tensv");
           String gioiTinh = rs.getString("gioitinh");
           Date ngaySinh = rs.getObject("ngaysinh", Date.class);
           Date ngayNhanPhong = rs.getObject("ngaynhanphong", Date.class);
           int idphong = rs.getInt("idphong");
           SinhVien x = new SinhVien(id, name, gioiTinh, ngaySinh, ngayNhanPhong,PhongService.getPhongByID(idphong));
           listSinhVien.add(x);
       }
       return listSinhVien;
       
    }
     public static boolean addSinhVien(SinhVien sv) throws SQLException {
        Connection conn = Utils.getConn();
        String sql = "INSERT INTO sinhvien(idsinhvien, tensv, gioitinh, ngaysinh, ngaynhanphong, idphong) VALUES(?, ?, ?, ?, ?, ?)";
        try {
            conn.setAutoCommit(false);
            PreparedStatement stm = conn.prepareStatement(sql);
            
            stm.setInt(1, sv.getIdsinhvien());
            stm.setString(2,sv.getTensv());
            stm.setString(3, sv.getGioitinh());
            stm.setDate(4, (Date) sv.getNgaysinh());
            stm.setDate(5, (Date) sv.getNgaynhanphong());
            stm.setInt(6, sv.getPhong().getIdphong());
            int execute = stm.executeUpdate();
             
            
            conn.commit();
            return execute > 0 ;
        } catch (SQLException ex) {
            Logger.getLogger(SinhVienService.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }
     
     public static boolean deleleSinhVien(String idSinhVien) throws SQLException {
        Connection conn = Utils.getConn();
        
        String sql = "DELETE FROM sinhvien WHERE idsinhvien=?";
        PreparedStatement stm = conn.prepareStatement(sql);
        stm.setString(1, idSinhVien);
        
        int row = stm.executeUpdate();
        
        return row > 0;
    }
     
     public static SinhVien getSinhVienByID(int id) throws SQLException{
         Connection conn = Utils.getConn();
        String sql = "Select * From sinhvien WHERE idsinhvien = ?";
        PreparedStatement stm = conn.prepareStatement(sql);
        stm.setInt(1, id);
        ResultSet rs = stm.executeQuery();
        while(rs.next()){  
            SinhVien sv = new SinhVien( rs.getInt("idsinhvien"),rs.getString("tensv"),
            rs.getString("gioitinh"), rs.getDate("ngaysinh"), rs.getDate("ngaynhanphong"), 
                    PhongService.getPhongByID(rs.getInt("idphong")));
            return sv;
        }
        return null;
     }
     
     
}
