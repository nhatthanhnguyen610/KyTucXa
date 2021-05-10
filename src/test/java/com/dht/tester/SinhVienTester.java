/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dht.tester;

import com.dht.pojo.Phong;
import com.dht.pojo.SinhVien;
import com.dht.service.PhongService;
import com.dht.service.SinhVienService;
import com.dht.service.Utils;
import java.sql.Connection;
import java.sql.Date;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 *
 * @author Admin
 */
public class SinhVienTester {
    private static Connection conn;
    

@BeforeClass
    public static void setUp() {
        conn = Utils.getConn();
    }
    
@AfterClass
    public static void tearDown() {       
        try {
            conn.close();
        } catch (SQLException ex) {
            Logger.getLogger(SinhVienTester.class.getName()).log(Level.SEVERE, null, ex);
        }      
    }
    
@Test
    public void testNameIsNotNull() {
        try {
            List<SinhVien> sinhViens = SinhVienService.getSinhVien("");
             for (SinhVien sv: sinhViens) {
                Assert.assertNotNull(sv.getTensv());
                Assert.assertNotEquals("", sv.getTensv().trim());
            }
        } catch (SQLException ex) {
            Logger.getLogger(SinhVienTester.class.getName()).log(Level.SEVERE, null, ex);
        }                
    }
    
@Test
    public void testCateCounter() {
        try {
            List<SinhVien> cats = SinhVienService.getSinhVien("");
            
            Assert.assertTrue(cats.size() >= 0);
        } catch (SQLException ex) {
            Logger.getLogger(SinhVienTester.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
    
@Test
    public void testDelete() throws SQLException{    
        Assert.assertFalse(SinhVienService.deleleSinhVien("2"));  
    }
    
@Test
 public void testGetSinhVienByID(){
        try {
            Assert.assertNotNull(SinhVienService.getSinhVienByID(2));
            Assert.assertNull(SinhVienService.getSinhVienByID(6));
        } catch (SQLException ex) {
            Logger.getLogger(SinhVienTester.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
 
 @Test
     public void testGetSinhVien() throws SQLException{
       List <SinhVien> sv = SinhVienService.getSinhVien("N");
       Assert.assertTrue(sv.size() >= 1);
       for(SinhVien c: sv)
           Assert.assertNotNull(c);
    }
     
@Test
    public void testDeleteSinhVien(){
        try {
            Assert.assertFalse(SinhVienService.deleleSinhVien("2"));
            Assert.assertFalse(SinhVienService.deleleSinhVien("4"));
            
        } catch (SQLException ex) {
            Logger.getLogger(SinhVienTester.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
}

