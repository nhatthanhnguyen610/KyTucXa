/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dht.service;

import com.dht.pojo.SinhVien;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLDataException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Admin
 */
public class SinhVienService {
    private Connection conn;

    public SinhVienService(Connection conn) {
        this.conn = conn;
    }
    
    public List<SinhVien> getProducts(String kw) throws SQLException {
        if (kw == null)
            throw new SQLDataException();
        
        String sql = "SELECT * FROM product WHERE name like concat('%', ?, '%')";
        PreparedStatement stm = this.conn.prepareStatement(sql);
        stm.setString(1, kw);
        
        ResultSet rs = stm.executeQuery();
        List<SinhVien> products = new ArrayList<>();
        while (rs.next()) {
            SinhVien p = new SinhVien();
            p.setIdSinhVien(rs.getInt("id"));
            p.setName(rs.getString("tensv"));
            p.setGioiTinh(rs.getString("gioitinh"));
            p.setNgaySinh(rs.getDate("ngaysinh"));
            p.setNgayNhanPhong(rs.getDate("ngaynhanphong"));
            p.setIdPhong(rs.getInt("idphong"));
            
            products.add(p);
        }
        return products;
    }
    
     public boolean addSinhVien(SinhVien p) throws SQLException {
        String sql = "INSERT INTO product(name, gioiTinh, ngayNhanPhong, idPhong) VALUES(?, ?, ?, ?)";
        PreparedStatement stm = this.conn.prepareStatement(sql);
        stm.setString(1, p.getName());
        stm.setString(2, p.getGioiTinh());
        stm.setDate(3, (Date) p.getNgayNhanPhong());
        stm.setInt(4,p.getIdPhong());
        
        int row = stm.executeUpdate();
        
        return row > 0;
    }
}
