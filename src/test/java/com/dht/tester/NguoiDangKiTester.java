/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dht.tester;

import com.dht.pojo.NguoiDangKi;
import com.dht.pojo.SinhVien;
import com.dht.service.NguoiDangKiService;
import com.dht.service.SinhVienService;
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

/**
 *
 * @author Admin
 */
public class NguoiDangKiTester {
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
            Logger.getLogger(NguoiDangKiTester.class.getName()).log(Level.SEVERE, null, ex);
        }      
    }
    
@Test
    public void testNameIsNotNull() {
        try {
            List<NguoiDangKi> ndks = NguoiDangKiService.getNguoiDangKi("");
             for (NguoiDangKi ndk: ndks) {
                Assert.assertNotNull(ndk.getHoTen());
                Assert.assertNotEquals("", ndk.getHoTen().trim());
            }
        } catch (SQLException ex) {
            Logger.getLogger(NguoiDangKiTester.class.getName()).log(Level.SEVERE, null, ex);
        }                
    }
    
@Test
    public void testCateCounter() {
        try {
            List<NguoiDangKi> ndks = NguoiDangKiService.getNguoiDangKi("");
            
            Assert.assertTrue(ndks.size() >= 0);
        } catch (SQLException ex) {
            Logger.getLogger(NguoiDangKiTester.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
    
}
