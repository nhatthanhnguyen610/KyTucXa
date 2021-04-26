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
    private int idsinhvien;
    private String tensv;
    private String gioitinh;
    private Date ngaysinh;
    private Date ngaynhanphong;
    private Phong phong;
    
    public SinhVien(){
        
    }
    
    public SinhVien(int idsv, String tensv){
        this.idsinhvien = idsv;
        this.tensv = tensv;
    }
    
    public SinhVien(int idsv, String name, String gioiTinh, Date ngaySinh, Date ngayNhanPhong, Phong phong){
        this.idsinhvien = idsv;
        this.tensv = name;
        this.gioitinh = gioiTinh;
        this.ngaysinh = ngaySinh;
        this.ngaynhanphong = ngayNhanPhong;
        this.phong = phong;
    }
    
    public SinhVien(int idsv, String name, String gioiTinh, Date ngaySinh, Date ngayNhanPhong){
        this.idsinhvien = idsv;
        this.tensv = name;
        this.gioitinh = gioiTinh;
        this.ngaysinh = ngaySinh;
        this.ngaynhanphong = ngayNhanPhong;
    }

    public int getIdsinhvien() {
        return idsinhvien;
    }

    public void setIdsinhvien(int idsinhvien) {
        this.idsinhvien = idsinhvien;
    }

    public String getTensv() {
        return tensv;
    }

    public void setTensv(String tensv) {
        this.tensv = tensv;
    }

 
    public Date getNgaysinh() {
        return ngaysinh;
    }

    public void setNgaysinh(Date ngaysinh) {
        this.ngaysinh = ngaysinh;
    }

    public Date getNgaynhanphong() {
        return ngaynhanphong;
    }

    public void setNgaynhanphong(Date ngaynhanphong) {
        this.ngaynhanphong = ngaynhanphong;
    }

    public Phong getPhong() {
        return phong;
    }

    public void setPhong(Phong phong) {
        this.phong = phong;
    }
     public String getGioitinh() {
        return gioitinh;
    }

    public void setGioitinh(String gioitinh) {
        this.gioitinh = gioitinh;
    }

    @Override
    public String toString() {
        String result = String.format("[%d] %s", this.idsinhvien, this.tensv);
        return result;
    }
    
    
}
