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

/**
 *
 * @author Admin
 */
public class NguoiDangKiService {
    
    private Connection conn; 
    
    public NguoiDangKiService(Connection conn) {
        this.conn = conn;
    }
    
     public boolean addNguoiDangKi(NguoiDangKi p) throws SQLException {
        String sql = "INSERT INTO dannhsachdangki(hoten, ngaysinh, CMND, SDT, queQuan) VALUES(?, ?, ?, ?, ?)";
        PreparedStatement stm = this.conn.prepareStatement(sql);
        stm.setString(1, p.getHoTen());
        stm.setDate(2, (Date) p.getNgaySinh());
        stm.setString(3, p.getCMND() );
        stm.setString(4, p.getSDT() );
        stm.setString(5, p.getQueQuan() );
        
        int row = stm.executeUpdate();
        
        return row > 0;
    }
}
