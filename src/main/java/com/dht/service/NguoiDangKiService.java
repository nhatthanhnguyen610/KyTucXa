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
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Admin
 */
public class NguoiDangKiService {
    
    public static boolean addNguoiDangKi(NguoiDangKi ndk){
        Connection conn = Utils.getConn();
        try {
            conn.setAutoCommit(false);
            String sql = "INSERT INTO danhsachdangki(iddangki, hoten, nagysinh, cmnd, sdt, quequan)" + "Values(?,?,?,?,?,?)";
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
            Logger.getLogger(PhongService.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }
}
