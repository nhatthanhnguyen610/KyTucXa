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
public class NguoiDangKi {
    private int idNguoiDangKi;
    private String hoTen;
    private Date ngaySinh;
    private String CMND;
    private String SDT;
    private String queQuan;

    /**
     * @return the idNguoiDangKi
     */
    public int getIdNguoiDangKi() {
        return idNguoiDangKi;
    }

    /**
     * @param idNguoiDangKi the idNguoiDangKi to set
     */
    public void setIdNguoiDangKi(int idNguoiDangKi) {
        this.idNguoiDangKi = idNguoiDangKi;
    }

    /**
     * @return the hoTen
     */
    public String getHoTen() {
        return hoTen;
    }

    /**
     * @param hoTen the hoTen to set
     */
    public void setHoTen(String hoTen) {
        this.hoTen = hoTen;
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
     * @return the CMND
     */
    public String getCMND() {
        return CMND;
    }

    /**
     * @param CMND the CMND to set
     */
    public void setCMND(String CMND) {
        this.CMND = CMND;
    }

    /**
     * @return the SDT
     */
    public String getSDT() {
        return SDT;
    }

    /**
     * @param SDT the SDT to set
     */
    public void setSDT(String SDT) {
        this.SDT = SDT;
    }

    /**
     * @return the queQuan
     */
    public String getQueQuan() {
        return queQuan;
    }

    /**
     * @param queQuan the queQuan to set
     */
    public void setQueQuan(String queQuan) {
        this.queQuan = queQuan;
    }
    
    
}
