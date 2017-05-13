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
    private String status;

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

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public static void hapusPinjamBuku(String isbn) {
        String text = null;
        Connection conn = null;
        PreparedStatement ps = null;
        conn = DatabaseManager.getDBConnection();
        try {
            ps = conn.prepareCall("DELETE FROM PTI_PINJAM "
                    + "WHERE ID_BUKU='" + isbn + "'");
            ps.executeUpdate();
            conn.commit();
            text = "Data sudah dihapus";

        } catch (SQLException ex) {
        } finally {
            try {
                ps.close();
                conn.close();
            } catch (SQLException ex) {
            }
        }
    }

    public static void hapusPinjamAnggota(String id) {
        String text = null;
        Connection conn = null;
        PreparedStatement ps = null;
        conn = DatabaseManager.getDBConnection();
        try {
            ps = conn.prepareCall("DELETE FROM PTI_PINJAM "
                    + "WHERE ID_PEMINJAM='" + id + "'");
            ps.executeUpdate();
            conn.commit();
            text = "Data sudah dihapus";

        } catch (SQLException ex) {
        } finally {
            try {
                ps.close();
                conn.close();
            } catch (SQLException ex) {
            }
        }
    }

    public static Pinjam[] getListPinjaman(String id) {
        Connection conn = null;
        Statement st = null;
        ResultSet rs = null;
        conn = DatabaseManager.getDBConnection();
        Pinjam[] p = null;
        try {
            st = conn.createStatement();
            rs = st.executeQuery("SELECT COUNT (*) TOTAL FROM PTI_PINJAM "
                    + "WHERE (ID_PEMINJAM='" + id + "' AND STATUS='N')");
            rs.next();
            p = new Pinjam[rs.getInt(1)];
            rs = st.executeQuery("SELECT * FROM PTI_PINJAM "
                    + "WHERE (ID_PEMINJAM='" + id + "' AND STATUS='N')");
            int index = 0;
            while (rs.next()) {
                p[index] = new Pinjam();
                p[index].setID_Peminjam(rs.getString(1));
                p[index].setID_Buku(rs.getString(2));
                p[index].setTanggal_pinjam(rs.getString(3));
                p[index].setWaktu_pinjam(rs.getInt(4));
                p[index].setTanggal_kembali(rs.getString(5));
                p[index].setStatus(rs.getString(6));
                index++;
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        } finally {
            try {
                rs.close();
                st.close();
                conn.close();
            } catch (SQLException ex) {
                System.out.println(ex.getMessage());
            }
        }
        return p;
    }

    public static Pinjam[] getHistory(String id) {
        Connection conn = null;
        Statement st = null;
        ResultSet rs = null;
        conn = DatabaseManager.getDBConnection();
        Pinjam[] p = null;
        try {
            st = conn.createStatement();
            rs = st.executeQuery("SELECT COUNT (*) TOTAL FROM PTI_PINJAM "
                    + "WHERE (ID_PEMINJAM='" + id + "')");
            rs.next();
            p = new Pinjam[rs.getInt(1)];
            rs = st.executeQuery("SELECT * FROM PTI_PINJAM "
                    + "WHERE (ID_PEMINJAM='" + id + "')");
            int index = 0;
            while (rs.next()) {
                p[index] = new Pinjam();
                p[index].setID_Peminjam(rs.getString(1));
                p[index].setID_Buku(rs.getString(2));
                p[index].setTanggal_pinjam(rs.getString(3));
                p[index].setWaktu_pinjam(rs.getInt(4));
                p[index].setTanggal_kembali(rs.getString(5));
                p[index].setStatus(rs.getString(6));
                index++;
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        } finally {
            try {
                rs.close();
                st.close();
                conn.close();
            } catch (SQLException ex) {
                System.out.println(ex.getMessage());
            }
        }
        return p;
    }

    public static boolean getPeminjaman(String id, String isbn) {
        Connection conn = null;
        Statement st = null;
        ResultSet rs = null;
        boolean hasil=false;
        Pinjam p = new Pinjam();
        conn = DatabaseManager.getDBConnection();
        try {
            st = conn.createStatement();
            rs = st.executeQuery("SELECT * FROM PEMINJAMAN WHERE"
                    + "(ID='" + id + "' AND STATUS='N' "
                    + "AND ISBN='"+isbn+"')");
            rs.next();
            p.setID_Peminjam(rs.getString(1));
            p.setID_Buku(rs.getString(2));
            p.setTanggal_pinjam(rs.getString(3));
            p.setWaktu_pinjam(rs.getInt(4));
            p.setTanggal_kembali(rs.getString(5));
            p.setStatus(rs.getString(6));
            hasil=true;
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        } finally {
            try {
                rs.close();
                st.close();
                conn.close();
            } catch (SQLException ex) {
                System.out.println(ex.getMessage());
            }
        }
        return hasil;
    }

    public static boolean Pengembalian(String kembali, String IDbuku, String IDanggota) {
        boolean text = false;
        Connection conn = null;
        PreparedStatement ps = null;
        Statement st = null;
        ResultSet rs = null;
        conn = DatabaseManager.getDBConnection();
        try {
            ps = conn.prepareCall("UPDATE PTI_PINJAM SET TANGGAL_KEMBALI="
                    + "TO_DATE(?, 'DD-MM-YYYY HH24:MI:SS'), "
                    + "STATUS='Y' "
                    + "WHERE ID_PEMINJAM=? AND ID_BUKU=?");
            ps.setString(1, kembali);
            ps.setString(2, IDanggota);
            ps.setString(3, IDbuku);
            ps.executeUpdate();
            conn.commit();
            text=true;
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
