/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dht.service;

import java.sql.Connection;

/**
 *
 * @author Admin
 */
public class HoaDonService {
    private Connection conn;

    public HoaDonService(Connection conn) {
        this.conn = conn;
    }
}
