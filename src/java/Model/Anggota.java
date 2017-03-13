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
public class Anggota {
    private String Nama;
    private String ID_Angota;

    public String getNama() {
        return Nama;
    }

    public void setNama(String Nama) {
        this.Nama = Nama;
    }

    public String getID_Angota() {
        return ID_Angota;
    }

    public void setID_Angota(String ID_Angota) {
        this.ID_Angota = ID_Angota;
    }
    public static void simpanPeminjaman(Pinjam p) {
        String text = null;
        Connection conn = null;
        PreparedStatement ps = null;
        conn = DatabaseManager.getDBConnection();
        try {
            ps = conn.prepareCall("INSERT INTO PTI_PINJAM VALUES"
                    + "(?,?,TO_DATE(?, 'DD-MM-YYYY'),?,TO_DATE(?, 'DD-MM-YYYY'))");
            ps.setString(1, p.getID_Peminjam());
            ps.setString(2, p.getID_Buku());
            ps.setString(3, p.getTanggal_pinjam());
            ps.setInt(4, p.getWaktu_pinjam());
            ps.setString(5, p.getTanggal_kembali());
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
