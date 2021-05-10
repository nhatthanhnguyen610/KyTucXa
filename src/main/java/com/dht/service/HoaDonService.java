/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dht.service;

import com.dht.pojo.HoaDon;
import com.dht.pojo.Phong;
import com.dht.pojo.SinhVien;
import java.sql.Connection;
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
public class HoaDonService {
    
    public static List<HoaDon> getHoaDon(String kw)throws SQLException{
        Connection conn = Utils.getConn();
        String sql = "Select * From hoadon";
        if(kw !=null && !kw.trim().isEmpty())
            sql += " WHERE idhoadon like ?";
        PreparedStatement stm = conn.prepareStatement(sql);
        if(kw !=null && !kw.trim().isEmpty())
            stm.setString(1,String.format("%%%s%%",kw.trim()));
        ResultSet rs = stm.executeQuery();
        
        List <HoaDon> listHoaDdon = new ArrayList<>();
        while(rs.next()){
            int idHoaDDon = rs.getInt("idhoadon");
            double tienPhong = rs.getDouble("tienphong");
            double tienDien = rs.getDouble("tienDien");
            double tienNuoc = rs.getDouble("tienNuoc");
            int idSinhVien = rs.getInt("idsinhvien");
            HoaDon hoadon = new HoaDon(idHoaDDon, tienPhong, tienDien, tienNuoc, 
                    SinhVienService.getSinhVienByID(idSinhVien));
            listHoaDdon.add(hoadon);
        }
        return listHoaDdon;
    }
    
    public static boolean addHoaDon(HoaDon hoadon)throws SQLException{
        Connection conn = Utils.getConn();
         String sql = "INSERT INTO hoadon(idhoadon, tienphong, tiendien, tiennuoc, idsinhvien)" + "Values(?,?,?,?,?)";
        try{
            conn.setAutoCommit(false);
            PreparedStatement stm = conn.prepareStatement(sql);
            
            stm.setInt(1,hoadon.getIdhoadon());
            stm.setDouble(2,hoadon.getTienPhong());
            stm.setDouble(3,hoadon.getTienDien());
            stm.setDouble(4,hoadon.getTienNuoc());
            stm.setInt(5,hoadon.getSinhVien().getIdsinhvien());
            int execute= stm.executeUpdate();
            
            conn.commit();
            return execute > 0 ;
            
        }catch(SQLException ex){
            Logger.getLogger(HoaDonService.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }
      
    public static HoaDon getFirstHoaDon()throws SQLException{
        Connection conn = Utils.getConn();
        String sql = "Select * From hoadon ORDER BY idhoadon DESC limit 1";
        PreparedStatement stm = conn.prepareStatement(sql);
        ResultSet rs = stm.executeQuery();
        while(rs.next()){  
            int id = rs.getInt("idhoadon");
            Double tienPhong = rs.getDouble("tienphong");
            Double tienDien = rs.getDouble("tiendien");
            Double tienNuoc = rs.getDouble("tiennuoc");
            int idsinhvien = rs.getInt("idsinhvien");
            HoaDon hoadon = new HoaDon(id, tienPhong, tienDien, tienNuoc,
            SinhVienService.getSinhVienByID(idsinhvien));
            return  hoadon;
        }
        return null;
    }
    

    
}
