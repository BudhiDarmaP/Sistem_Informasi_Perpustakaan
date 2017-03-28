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
public class Buku {

    private String ISBN;
    private String Judul;
    private String Penulis;
    private String Tahun_Terbit;
    private String Penerbit;
    private int Ketersediaan;

    public String getISBN() {
        return ISBN;
    }

    public void setISBN(String ISBN) {
        this.ISBN = ISBN;
    }

    public String getJudul() {
        return Judul;
    }

    public void setJudul(String Judul) {
        this.Judul = Judul;
    }

    public String getPenulis() {
        return Penulis;
    }

    public void setPenulis(String Penulis) {
        this.Penulis = Penulis;
    }

    public String getTahun_Terbit() {
        return Tahun_Terbit;
    }

    public void setTahun_Terbit(String Tahun_Terbit) {
        this.Tahun_Terbit = Tahun_Terbit;
    }

    public String getPenerbit() {
        return Penerbit;
    }

    public void setPenerbit(String Penerbit) {
        this.Penerbit = Penerbit;
    }

    public int getKetersediaan() {
        return Ketersediaan;
    }

    public void setKetersediaan(int Ketersediaan) {
        this.Ketersediaan = Ketersediaan;
    }

    public static void tambahBuku(Buku b) {
        String text = null;
        Connection conn = null;
        PreparedStatement ps = null;
        conn = DatabaseManager.getDBConnection();
        try {
            ps = conn.prepareCall("INSERT INTO PTI_PINJAM VALUES"
                    + "(?,?,?,?)");
            ps.setString(1, b.getISBN());
            ps.setString(2, b.getJudul());
            ps.setString(3, b.getPenulis());
            ps.setString(4, b.getPenerbit());
            ps.setString(4, b.getTahun_Terbit());
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

    public static String UpdateKetersediaan(String isbn, int ketersediaan) {
        String text = null;
        Connection conn = null;
        PreparedStatement ps = null;
        Statement st = null;
        ResultSet rs = null;
        conn = DatabaseManager.getDBConnection();
        try {
            ps = conn.prepareCall("UPDATE PTI_PINJAM SET KETERSEDIAAN='?' WHERE ID ='?'");
            ps.setInt(1, ketersediaan);
            ps.setString(2, isbn);
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

    public static Buku cekKetersediaan(String isbn) {
        String text = null;
        Connection conn = null;
        PreparedStatement ps = null;
        Statement st = null;
        ResultSet rs = null;
        conn = DatabaseManager.getDBConnection();
        Buku b = new Buku();
        try {
            rs = st.executeQuery("SELECT KETERSEDIAAN FROM PTI_BUKU "
                    + "WHERE ID='" + isbn + "'");
            int index = 0;
            while (rs.next()) {
                b.setKetersediaan(rs.getInt(1));
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
        return b;
    }

    public static Buku[] getListPencarian(String key) {
        Connection conn = null;
        Statement st = null;
        ResultSet rs = null;
        conn = DatabaseManager.getDBConnection();
        Buku bk[] = null;
        try {
            st = conn.createStatement();
            rs = st.executeQuery("SELECT COUNT (*) TOTAL FROM PTI_BUKU "
                    + "WHERE ("
                    + "ISBN LIKE '%" + key + "%' OR  "
                    + "JUDUL LIKE '%" + key + "%' OR "
                    + "PENULIS LIKE '%" + key + "%' OR "
                    + "PENERBIT LIKE '%" + key + "%' OR "
                    + "TAHUN_TERBIT LIKE '%" + key + "%' AND "
                    + "KETERSEDIAAN > 0)");
            rs.next();
            bk = new Buku[rs.getInt(1)];
            rs = st.executeQuery("SELECT * FROM PTI_BUKU "
                    + "WHERE ("
                    + "ISBN LIKE '%" + key + "%' OR  "
                    + "JUDUL LIKE '%" + key + "%' OR "
                    + "PENULIS LIKE '%" + key + "%' OR "
                    + "PENERBIT LIKE '%" + key + "%' OR "
                    + "TAHUN_TERBIT LIKE '%" + key + "%' AND "
                    + "KETERSEDIAAN > 0)");
            int index = 0;
            while (rs.next()) {
                bk[index] = new Buku();
                bk[index].setISBN(rs.getString(1));
                bk[index].setJudul(rs.getString(2));
                bk[index].setPenulis(rs.getString(3));
                bk[index].setTahun_Terbit(rs.getString(4));
                bk[index].setPenerbit(rs.getString(5));
                bk[index].setKetersediaan(rs.getInt(6));
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
        return bk;
    }

    public static Buku getBuku(String ISBN) {
        Connection conn = null;
        Statement st = null;
        ResultSet rs = null;
        conn = DatabaseManager.getDBConnection();
        Buku bk = new Buku();
        try {
            st = conn.createStatement();
            rs = st.executeQuery("SELECT COUNT (*) TOTAL FROM PTI_BUKU "
                    + "WHERE ("
                    + "ISBN='" + ISBN + "' AND "
                    + "KETERSEDIAAN > 0)");
            rs.next();
            rs = st.executeQuery("SELECT * FROM PTI_BUKU "
                    + "WHERE ("
                    + "ISBN='" + ISBN + "' AND "
                    + "KETERSEDIAAN > 0)");
            int index = 0;
            while (rs.next()) {
                bk.setISBN(rs.getString(1));
                bk.setJudul(rs.getString(2));
                bk.setPenulis(rs.getString(3));
                bk.setTahun_Terbit(rs.getString(4));
                bk.setPenerbit(rs.getString(5));
                bk.setKetersediaan(rs.getInt(6));
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
        return bk;
    }
}
