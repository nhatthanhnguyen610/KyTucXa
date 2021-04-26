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
public class Phong {
    private int idphong;
    private String tenphong;
    private String loaiphong;
    
    public Phong(){
        
    }
    
    public Phong(String name, String loaiPhong){
        this.tenphong = name;
        this.loaiphong = loaiPhong;
    }
    
    public Phong(int id, String name, String loaiPhong){
        this.idphong = id;
        this.tenphong = name;
        this.loaiphong = loaiPhong;
    }

    public int getIdphong() {
        return idphong;
    }

    public void setIdphong(int idphong) {
        this.idphong = idphong;
    }

    public String getTenphong() {
        return tenphong;
    }

    public void setTenphong(String tenphong) {
        this.tenphong = tenphong;
    }

    public String getLoaiphong() {
        return loaiphong;
    }

    public void setLoaiphong(String loaiphong) {
        this.loaiphong = loaiphong;
    }

   public String toString() {
        String result = String.format("[%d] %s: %s", this.idphong, this.tenphong,this.loaiphong);
        return result;
    }
    
}
