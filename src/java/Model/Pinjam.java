/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import Control.DatabaseManager;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author budhidarmap
 */
public class Pinjam {
    private String ID_Peminjam;
    private String ID_Buku;
    private String tanggal_pinjam;
    private int waktu_pinjam;
    private String tanggal_kembali;

    public String getID_Peminjam() {
        return ID_Peminjam;
    }

    public void setID_Peminjam(String ID_Peminjam) {
        this.ID_Peminjam = ID_Peminjam;
    }

    public String getID_Buku() {
        return ID_Buku;
    }

    public void setID_Buku(String ID_Buku) {
        this.ID_Buku = ID_Buku;
    }

    public String getTanggal_pinjam() {
        return tanggal_pinjam;
    }

    public void setTanggal_pinjam(String tanggal_pinjam) {
        this.tanggal_pinjam = tanggal_pinjam;
    }

    public int getWaktu_pinjam() {
        return waktu_pinjam;
    }

    public void setWaktu_pinjam(int waktu_pinjam) {
        this.waktu_pinjam = waktu_pinjam;
    }

    public String getTanggal_kembali() {
        return tanggal_kembali;
    }

    public void setTanggal_kembali(String tanggal_kembali) {
        this.tanggal_kembali = tanggal_kembali;
    }
    public static String UbahStatusKetersediaan(String idbuku) {
        String text = null;
        Connection conn = null;
        PreparedStatement ps = null;
        Statement st = null;
        ResultSet rs = null;
        conn = DatabaseManager.getDBConnection();
        try {
            ps = conn.prepareCall("UPDATE PTI_BUKU SET KETERSEDIAAN '?' WHERE ID ='?'");
            ps.setBoolean(1, true);
            ps.setString(2, idbuku);
            ps.executeUpdate();
            conn.commit();
        } catch (SQLException ex) {

        } finally {
            try {
                ps.close();
                conn.close();
            } catch (SQLException ex) {

            }
        }
        return text;
    }
    public static String Pengembalian(String kembali, String id) {
        String text = null;
        Connection conn = null;
        PreparedStatement ps = null;
        Statement st = null;
        ResultSet rs = null;
        conn = DatabaseManager.getDBConnection();
        try {
            ps = conn.prepareCall("UPDATE PTI_PINJAM SET TANGGAL_KEMBALI '?' WHERE ID ='?'");
            ps.setString(1, kembali);
            ps.setString(2, id);
            ps.executeUpdate();
            conn.commit();
        } catch (SQLException ex) {

        } finally {
            try {
                ps.close();
                conn.close();
            } catch (SQLException ex) {

            }
        }
        return text;
    }
}
