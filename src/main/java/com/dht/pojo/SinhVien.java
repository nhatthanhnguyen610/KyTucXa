/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dht.pojo;

import java.util.Date;

/**
 *
 * @author Admin
 */
public class SinhVien {
    private int idSinhVien;
    private String name;
    private String gioiTinh;
    private Date ngaySinh;
    private Date ngayNhanPhong;
    private int idPhong;
    

    /**
     * @return the id
     */
    public int getIdSinhVien() {
        return idSinhVien;
    }

    /**
     * @param id the id to set
     */
    public void setIdSinhVien(int id) {
        this.idSinhVien = idSinhVien;
    }

    /**
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return the gioiTinh
     */
    public String getGioiTinh() {
        return gioiTinh;
    }

    /**
     * @param gioiTinh the gioiTinh to set
     */
    public void setGioiTinh(String gioiTinh) {
        this.gioiTinh = gioiTinh;
    }

    /**
     * @return the ngaySinh
     */
    public Date getNgaySinh() {
        return ngaySinh;
    }

    /**
     * @param ngaySinh the ngaySinh to set
     */
    public void setNgaySinh(Date ngaySinh) {
        this.ngaySinh = ngaySinh;
    }

    /**
     * @return the ngayNhanPhong
     */
    public Date getNgayNhanPhong() {
        return ngayNhanPhong;
    }

    /**
     * @param ngayNhanPhong the ngayNhanPhong to set
     */
    public void setNgayNhanPhong(Date ngayNhanPhong) {
        this.ngayNhanPhong = ngayNhanPhong;
    }

    /**
     * @return the idPhong
     */
    public int getIdPhong() {
        return idPhong;
    }

    /**
     * @param idPhong the idPhong to set
     */
    public void setIdPhong(int idPhong) {
        this.idPhong = idPhong;
    }
    
    
}
