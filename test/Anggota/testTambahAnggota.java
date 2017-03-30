package Anggota;


import Control.DatabaseManager;
import Model.Anggota;
import Model.Buku;
import Model.Pinjam;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author budhidarmap
 */
public class testTambahAnggota {
    public static void main(String[] args) {
        Anggota a=new Anggota();
         a.setID_Angota("145314000");
        a.setNama("nama");
        a.setEmail("email");
        a.setNo_tlp("no_tlp");
        a.setAlamat("alamat");
        a.setPassword("password");
        a.tambahAnggota(a);
    }
}
