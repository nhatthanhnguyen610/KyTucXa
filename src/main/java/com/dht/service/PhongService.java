/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dht.service;

import com.dht.pojo.Phong;
import com.dht.pojo.SinhVien;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Admin
 */
public class PhongService {     
    public static List<Phong> getPhong(String kw) throws SQLException{
        Connection conn = Utils.getConn();
        String sql = "Select * From phong";
        if(kw !=null && !kw.trim().isEmpty())
            sql += " WHERE tenphong like ?";
        
        PreparedStatement stm = conn.prepareStatement(sql);
        
        if(kw !=null && !kw.trim().isEmpty())
            stm.setString(1, String.format("%%%s%%",kw.trim()));
        ResultSet rs = stm.executeQuery();
        
        List <Phong> listPhong = new ArrayList<>();
        while(rs.next()){
            int idphong = rs.getInt("idphong");
            String name = rs.getString("tenphong");
            String loaiPhong = rs.getString("loaiphong");
            Phong phong = new Phong(idphong, name, loaiPhong);
            listPhong.add(phong);
        }
        return listPhong;
    }
    
    public static Phong getPhongByID(int id) throws SQLException{
        Connection conn = Utils.getConn();
        String sql = "Select * From phong WHERE idphong = ?";
        PreparedStatement stm = conn.prepareStatement(sql);
        stm.setInt(1,id);
        ResultSet rs = stm.executeQuery();
        while(rs.next()){  
            Phong phong = new Phong( rs.getInt("idphong"),rs.getString("tenphong"), rs.getString("loaiphong"));
             return phong;
        }
        return null;
    }
    
    public static boolean addPhong(Phong phong){
        Connection conn = Utils.getConn();
        try {
            conn.setAutoCommit(false);
            String sql = "INSERT INTO phong(idphong, tenphong, loaiphong)" + "Values(?,?,?)";
            PreparedStatement stm = conn.prepareStatement(sql);
            
            stm.setInt(1,phong.getIdphong());
            stm.setString(2,phong.getTenphong());
            stm.setString(3,phong.getLoaiphong());
            int executeUpdate = stm.executeUpdate();
                
            
            conn.commit();
            return executeUpdate > 0;
        } catch (SQLException ex) {
            Logger.getLogger(PhongService.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }
    
    public static boolean delelePhong(String idPhong) throws SQLException {
        Connection conn = Utils.getConn();
        
        String sql = "DELETE FROM phong WHERE idphong=?";
         try {
            conn.setAutoCommit(false);
            PreparedStatement stm = conn.prepareStatement(sql);
            stm.setString(1, idPhong);
            if(stm.executeUpdate() == 1);
            {
             conn.commit();
             return true;
            }
        } catch (SQLException ex) {
            Logger.getLogger(PhongService.class.getName()).log(Level.SEVERE, null, ex);
        }
        
      return false;
    }
   

}
