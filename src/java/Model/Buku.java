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
                    + "ISBN LIKE '%"+key+"%' OR  "
                    + "JUDUL LIKE '%"+key+"%' OR "
                    + "PENULIS LIKE '%"+key+"%' OR "
                    + "PENERBIT LIKE '%"+key+"%' OR "
                    + "TAHUN_TERBIT LIKE '%"+key+"%' AND "
                    + "KETERSEDIAAN > 0)");
            rs.next();
            bk = new Buku[rs.getInt(1)];
            rs = st.executeQuery("SELECT * FROM PTI_BUKU "
                    + "WHERE ("
                    + "ISBN LIKE '%"+key+"%' OR  "
                    + "JUDUL LIKE '%"+key+"%' OR "
                    + "PENULIS LIKE '%"+key+"%' OR "
                    + "PENERBIT LIKE '%"+key+"%' OR "
                    + "TAHUN_TERBIT LIKE '%"+key+"%' AND "
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
}
