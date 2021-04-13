/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dht.service;

import com.dht.pojo.Phong;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Admin
 */
public class PhongService {
    private Connection conn;
    
    public PhongService(Connection conn){
        this.conn = conn;
    }
    
    public List<Phong> getCates() throws SQLException {
        Statement stm = this.conn.createStatement();
        ResultSet r = stm.executeQuery("SELECT * FROM phong");
        
        List<Phong> re = new ArrayList<>();
        while (r.next()) {
            Phong c = new Phong();
            c.setIdphong(r.getInt("idphong"));
            c.setTenPhong(r.getString("tenphong"));
            c.setLoaiPhong(r.getString("loaiphong"));
            
            re.add(c);
        }
        return re;
    }
}
