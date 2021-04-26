/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dht.pojo;

/**
 *
 * @author Admin
 */
public class HoaDon {
    private int idhoadon;
    private double tienPhong;
    private double tienDien;
    private double tienNuoc;
    private SinhVien sinhVien;
    
    public HoaDon(){
        
    }
    

    
    public HoaDon(int idHoaDdon, double tienPhong, 
            double tienDien, double tienNuoc, SinhVien sinhVien ){
        this.idhoadon = idHoaDdon;
        this.tienPhong = tienPhong;
        this.tienDien = tienDien;
        this.tienNuoc = tienNuoc;
        this.sinhVien = sinhVien;
    }

    /**
     * @return the idhoadon
     */
    public int getIdhoadon() {
        return idhoadon;
    }

    /**
     * @param idhoadon the idhoadon to set
     */
    public void setIdhoadon(int idhoadon) {
        this.idhoadon = idhoadon;
    }

    /**
     * @return the tienPhong
     */
    public double getTienPhong() {
        return tienPhong;
    }

    /**
     * @param tienPhong the tienPhong to set
     */
    public void setTienPhong(double tienPhong) {
        this.tienPhong = tienPhong;
    }

    /**
     * @return the tienDien
     */
    public double getTienDien() {
        return tienDien;
    }

    /**
     * @param tienDien the tienDien to set
     */
    public void setTienDien(double tienDien) {
        this.tienDien = tienDien;
    }

    /**
     * @return the tienNuoc
     */
    public double getTienNuoc() {
        return tienNuoc;
    }

    /**
     * @param tienNuoc the tienNuoc to set
     */
    public void setTienNuoc(double tienNuoc) {
        this.tienNuoc = tienNuoc;
    }

    /**
     * @return the sinhVien
     */
    public SinhVien getSinhVien() {
        return sinhVien;
    }

    /**
     * @param sinhVien the sinhVien to set
     */
    public void setSinhVien(SinhVien sinhVien) {
        this.sinhVien = sinhVien;
    }

    /**
     * @return the idSinhVien
     */
    
    
    
    
}
