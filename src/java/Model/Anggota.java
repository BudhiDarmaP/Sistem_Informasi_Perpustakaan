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
public class Anggota {

    private String Nama;
    private String ID_Angota;
    private String email;
    private String no_tlp;
    private String alamat;
    protected String password;

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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getNo_tlp() {
        return no_tlp;
    }

    public void setNo_tlp(String no_tlp) {
        this.no_tlp = no_tlp;
    }

    public String getAlamat() {
        return alamat;
    }

    public void setAlamat(String alamat) {
        this.alamat = alamat;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public static int panggilID(String tgl) {
        Connection conn = null;
        Statement st = null;
        ResultSet rs = null;
        conn = DatabaseManager.getDBConnection();
        int index = 0;
        try {
            st = conn.createStatement();
            rs = st.executeQuery("SELECT COUNT (ID) FROM PTI_ANGGOTA WHERE"
                    + "(ID LIKE '%" + tgl + "%')");
            rs.next();
            rs = st.executeQuery("SELECT ID FROM PTI_ANGGOTA WHERE"
                    + "(ID LIKE '%" + tgl + "%')");
            while (rs.next()) {
                index++;
                System.out.println(index);
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
        return index;
    }

    public static void tambahAnggota(Anggota a) {
        String text = null;
        Connection conn = null;
        PreparedStatement ps = null;
        conn = DatabaseManager.getDBConnection();
        try {
            ps = conn.prepareCall("INSERT INTO PTI_ANGGOTA VALUES"
                    + "(?,?,?,?,?,?)");
            ps.setString(1, a.getID_Angota());
            ps.setString(2, a.getNama());
            ps.setString(3, a.getEmail());
            ps.setString(4, a.getNo_tlp());
            ps.setString(5, a.getAlamat());
            ps.setString(6, a.getPassword());
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

    public static String editMember(Anggota a) {
        String text = null;
        Connection conn = null;
        PreparedStatement ps = null;
        Statement st = null;
        ResultSet rs = null;
        conn = DatabaseManager.getDBConnection();
        try {
            ps = conn.prepareCall("UPDATE PTI_ANGGOTA SET"
                    + " NAMA=?, EMAIL=?, NO_TLP=?, ALAMAT=?, "
                    + "PASSWORD=? WHERE ID=?");
            ps.setString(1, a.getNama());
            ps.setString(2, a.getEmail());
            ps.setString(3, a.getNo_tlp());
            ps.setString(4, a.getAlamat());
            ps.setString(5, a.getPassword());
            ps.setString(6, a.getID_Angota());
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

    public static void hapusMember(String id) {
        String text = null;
        Connection conn = null;
        PreparedStatement ps = null;
        conn = DatabaseManager.getDBConnection();
        try {
            ps = conn.prepareCall("DELETE FROM PTI_ANGGOTA "
                    + "WHERE EMAIL='" + id + "'");
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

    public static void simpanPeminjaman(Pinjam p) {
        String text = null;
        Connection conn = null;
        PreparedStatement ps = null;
        conn = DatabaseManager.getDBConnection();
        try {
            ps = conn.prepareCall("INSERT INTO PTI_PINJAM "
                    + "VALUES(?, ?, TO_DATE(?, 'DD-MM-YYYY'),? ,NULL)");
            ps.setString(1, p.getID_Peminjam());
            ps.setString(2, p.getID_Buku());
            ps.setString(3, p.getTanggal_pinjam());
            ps.setInt(4, p.getWaktu_pinjam());
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

    public static Pinjam[] getListPeminjaman(String id) {
        Connection conn = null;
        Statement st = null;
        ResultSet rs = null;
        conn = DatabaseManager.getDBConnection();
        Pinjam pin[] = null;
        try {
            st = conn.createStatement();
            rs = st.executeQuery("SELECT COUNT (*) TOTAL FROM PTI_PINJAM WHERE"
                    + "(ID_PEMINJAM=" + id + ")");
            rs.next();
            pin = new Pinjam[rs.getInt(1)];
            rs = st.executeQuery("SELECT * FROM PTI_PINJAM WHERE "
                    + "(ID_PEMINJAM=" + id + " AND TANGGAL_KEMBALI=NULL)");
            int index = 0;
            while (rs.next()) {
                pin[index] = new Pinjam();
                pin[index].setID_Peminjam(rs.getString(1));
                pin[index].setID_Buku(rs.getString(2));
                pin[index].setTanggal_pinjam(rs.getString(3));
                pin[index].setWaktu_pinjam(rs.getInt(4));
                pin[index].setTanggal_kembali(rs.getString(5));
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
        return pin;
    }
}
