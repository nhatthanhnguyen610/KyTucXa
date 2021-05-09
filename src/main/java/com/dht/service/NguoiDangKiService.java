/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dht.service;

import com.dht.pojo.NguoiDangKi;
import com.dht.pojo.SinhVien;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Admin
 */
public class NguoiDangKiService {
    
    public static List <NguoiDangKi> getNguoiDangKi(String kw) throws SQLException{
        
        Connection conn = Utils.getConn();
        String sql = "SELECT * FROM danhsachdangki";
        if(kw!=null && !kw.trim().isEmpty())
            sql += " Where iddangki like ?";
        
        PreparedStatement stm = conn.prepareStatement(sql);
        
        if (kw != null && !kw.trim().isEmpty())
            stm.setString(1, String.format("%%%s%%", kw.trim()));
        
        ResultSet rs = stm.executeQuery();
        
        List <NguoiDangKi> listNguoiDangKi = new ArrayList();
       while(rs.next()){
           int id =  rs.getInt("iddangki");
           String name = rs.getString("hoten");
           Date ngaySinh = rs.getDate("ngaysinh");
           String cmnd = rs.getString("cmnd");
           String sdt = rs.getString("sdt");
           String queQuan = rs.getString("quequan");
           
           
           NguoiDangKi x = new NguoiDangKi(id, name, ngaySinh, cmnd, sdt, queQuan);
           listNguoiDangKi.add(x);
       }
       return listNguoiDangKi;
       
    }
    
    
    public static boolean addNguoiDangKi(NguoiDangKi ndk){
        Connection conn = Utils.getConn();
        String sql = "INSERT INTO danhsachdangki(iddangki, hoten, ngaysinh, cmnd, sdt, quequan) Values(?,?,?,?,?,?)";
        try {
            conn.setAutoCommit(false);
            PreparedStatement stm = conn.prepareStatement(sql);
            
            stm.setInt(1,ndk.getIdNguoiDangKi());
            stm.setString(2,ndk.getHoTen());
            stm.setDate(3, (Date) ndk.getNgaySinh());
            stm.setString(4, ndk.getCMND());
            stm.setString(5, ndk.getSDT());
            stm.setString(6, ndk.getQueQuan());
            int executeUpdate = stm.executeUpdate();
                
            
            conn.commit();
            return executeUpdate > 0;
        } catch (SQLException ex) {
            Logger.getLogger(NguoiDangKiService.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }
}
