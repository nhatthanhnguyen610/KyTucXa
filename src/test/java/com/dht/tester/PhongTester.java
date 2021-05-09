/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dht.tester;
import com.dht.pojo.Phong;
import com.dht.service.PhongService;
import com.dht.service.Utils;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.jupiter.api.BeforeAll;

/**
 *
 * @author Admin
 */
public class PhongTester {
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
            Logger.getLogger(PhongTester.class.getName()).log(Level.SEVERE, null, ex);
        }      
    }
    
@Test
    public void testNameIsNotNull() {
        try {
            List<Phong> phongs = PhongService.getPhong("");
             for (Phong phong: phongs) {
                Assert.assertNotNull(phong.getTenphong());
                Assert.assertNotEquals("", phong.getTenphong().trim());
            }
        } catch (SQLException ex) {
            Logger.getLogger(PhongTester.class.getName()).log(Level.SEVERE, null, ex);
        }                
    } 
    
@Test
    public void testCateCounter() {
        try {
            List<Phong> cats = PhongService.getPhong("");
            
            Assert.assertTrue(cats.size() >= 0);
        } catch (SQLException ex) {
            Logger.getLogger(PhongTester.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    

@Test
    public void testDelete() throws SQLException{    
        Assert.assertFalse(PhongService.delelePhong("6"));  
    }
  
@Test
 public void testGetPhongByID(){
        try {
            Phong phong = PhongService.getPhongByID(2);
            Assert.assertNotNull(phong.getTenphong());
            Assert.assertNotEquals("", phong.getTenphong().trim());
            Assert.assertNotNull(phong.getLoaiphong());
            
        } catch (SQLException ex) {
            Logger.getLogger(PhongTester.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
 
 public void testAddPhong(){
        Phong p = new Phong(4, "B06", "Vip");
        Assert.assertTrue(PhongService.addPhong(p));
    }
}

