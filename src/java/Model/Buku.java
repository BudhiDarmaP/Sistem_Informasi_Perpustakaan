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

    private String ID_Buku;
    private String ISBN;
    private String Judul;
    private String Penulis;
    private int Tahun_Terbit;
    private String Penerbit;
    private boolean Ketersediaan;

    public String getID_Buku() {
        return ID_Buku;
    }

    public void setID_Buku(String ID_Buku) {
        this.ID_Buku = ID_Buku;
    }

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

    public int getTahun_Terbit() {
        return Tahun_Terbit;
    }

    public void setTahun_Terbit(int Tahun_Terbit) {
        this.Tahun_Terbit = Tahun_Terbit;
    }

    public String getPenerbit() {
        return Penerbit;
    }

    public void setPenerbit(String Penerbit) {
        this.Penerbit = Penerbit;
    }

    public boolean isKetersediaan() {
        return Ketersediaan;
    }

    public void setKetersediaan(boolean Ketersediaan) {
        this.Ketersediaan = Ketersediaan;
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
                    + "ID LIKE '%"+key+"%' OR "
                    + "ISBN LIKE '%"+key+"%' OR  "
                    + "JUDUL LIKE '%"+key+"%' OR "
                    + "PENERBIT LIKE '%"+key+"%' OR "
                    + "PENGARANG LIKE '%"+key+"%' OR "
                    + "TH_TERBIT LIKE '%"+key+"%')");
            rs.next();
            bk = new Buku[rs.getInt(1)];
            rs = st.executeQuery("SELECT * FROM PTI_BUKU "
                    + "WHERE ("
                    + "ID LIKE '%"+key+"%' OR "
                    + "ISBN LIKE '%"+key+"%' OR  "
                    + "JUDUL LIKE '%"+key+"%' OR "
                    + "PENERBIT LIKE '%"+key+"%' OR "
                    + "PENGARANG LIKE '%"+key+"%' OR "
                    + "TH_TERBIT LIKE '%"+key+"%'"
                    + "AND KETERSEDIAAN IS Y)");
            int index = 0;
            while (rs.next()) {
                bk[index] = new Buku();
                bk[index].setID_Buku(rs.getString(1));
                bk[index].setISBN(rs.getString(2));
                bk[index].setJudul(rs.getString(3));
                bk[index].setPenulis(rs.getString(4));
                bk[index].setTahun_Terbit(rs.getInt(5));
                bk[index].setPenerbit(rs.getString(6));
                bk[index].setKetersediaan(rs.getBoolean(7));
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
