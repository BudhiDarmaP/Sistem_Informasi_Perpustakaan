/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import Control.DatabaseManager;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

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
    public static void Pengembalian(Pinjam p) {
        String text = null;
        Connection conn = null;
        PreparedStatement ps = null;
        conn = DatabaseManager.getDBConnection();
        try {
            ps = conn.prepareCall("INSERT INTO RPL_PEMBAYARAN VALUES(?,?,?,?,TO_DATE(?, 'DD-MM-YYYY'))");
            ps.setString(1, p.getID_Buku());
            ps.setString(2, p.getID_Peminjam());
            ps.setString(3, p.getTanggal_kembali());
            ps.setInt(4, p.getWaktu_pinjam());
            ps.setString(5, p.getTanggal_pinjam());
            ps.executeUpdate();
            conn.commit();
            text = "Data sudah ditambahkan";

        } catch (SQLException ex) {
        } finally {
            try {
                ps.close();
                conn.close();
            } catch (SQLException ex) {
            }
        }
    }
}
