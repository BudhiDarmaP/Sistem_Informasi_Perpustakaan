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
import java.text.SimpleDateFormat;
import java.util.Calendar;

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
    private String password;

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

    public static boolean LoginAnggota(String id, String pass) {
        Connection conn = null;
        Statement st = null;
        ResultSet rs = null;
        conn = DatabaseManager.getDBConnection();
        Anggota a = new Anggota();
        try {
            st = conn.createStatement();
            rs = st.executeQuery("SELECT COUNT (*) FROM PTI_ANGGOTA WHERE "
                    + "ID='" + id + "' AND PASSWORD='" + pass + "'");
            rs.next();
            int nilai = Integer.parseInt(rs.getString(1));
            if (nilai == 0) {
                return false;
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
        return true;
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

    public static int cekAnggota(String id) {
        Connection conn = null;
        Statement st = null;
        ResultSet rs = null;
        conn = DatabaseManager.getDBConnection();
        int cek = 0;
        try {
            st = conn.createStatement();
            rs = st.executeQuery("SELECT COUNT (*) FROM PTI_ANGGOTA WHERE"
                    + "(ID=" + id + ")");
            rs.next();
            cek = Integer.parseInt(rs.getString(1));

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
        return cek;
    }

    public static Anggota panggilAnggota(String id) {
        Connection conn = null;
        Statement st = null;
        ResultSet rs = null;
        conn = DatabaseManager.getDBConnection();
        Anggota a = new Anggota();
        try {
            st = conn.createStatement();
            rs = st.executeQuery("SELECT * FROM PTI_ANGGOTA WHERE"
                    + "(ID=" + id + ")");
            rs.next();
            a.setID_Angota(rs.getString(1));
            a.setNama(rs.getString(2));
            a.setEmail(rs.getString(3));
            a.setNo_tlp(rs.getString(4));
            a.setAlamat(rs.getString(5));
            a.setPassword(rs.getString(6));

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
        return a;
    }

    public static void tambahAnggota(Anggota a) {
        String text = null;
        Connection conn = null;
        PreparedStatement ps = null;
        conn = DatabaseManager.getDBConnection();
        
         String timeStamp = new SimpleDateFormat("yyMMdd").format(Calendar.getInstance().getTime());
        String number = "000";
        int count = a.panggilID(timeStamp) + 1;
        if (count < 10) {
            number = "00" + String.valueOf(count);
        } else if (count < 100) {
            number = "0" + String.valueOf(count);
        } else {
            number = String.valueOf(count);
        }
        
        try {
            ps = conn.prepareCall("INSERT INTO PTI_ANGGOTA VALUES"
                    + "(?,?,?,?,?,?)");
            ps.setString(1, (timeStamp+number));
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
    public static Anggota[] getListAnggota(String id) {
        Connection conn = null;
        Statement st = null;
        ResultSet rs = null;
        conn = DatabaseManager.getDBConnection();
        Anggota a[] = null;
        try {
            st = conn.createStatement();
            if (!id.equals("")) {
                rs = st.executeQuery("SELECT COUNT (*) TOTAL FROM PTI_ANGGOTA WHERE "
                        + "(ID=" + id + ")");
                rs.next();
                a = new Anggota[rs.getInt(1)];
                rs = st.executeQuery("SELECT * FROM PTI_ANGGOTA WHERE "
                        + "(ID=" + id + ")");
            } else {
                rs = st.executeQuery("SELECT COUNT (*) TOTAL FROM PTI_ANGGOTA");
                rs.next();
                a = new Anggota[rs.getInt(1)];
                rs = st.executeQuery("SELECT * FROM PTI_ANGGOTA");
            }
            int index = 0;
            while (rs.next()) {
                a[index] = new Anggota();
                a[index].setID_Angota(rs.getString(1));
                a[index].setNama(rs.getString(2));
                a[index].setEmail(rs.getString(3));
                a[index].setNo_tlp(rs.getString(4));
                a[index].setAlamat(rs.getString(5));
                a[index].setPassword(rs.getString(6));
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
        return a;
    }

    public static boolean simpanPeminjaman(Pinjam p) {
        String text = null;
        Connection conn = null;
        PreparedStatement ps = null;
        conn = DatabaseManager.getDBConnection();
        try {
            if (Buku.cekBuku(p.getID_Buku())) {
                ps = conn.prepareCall("INSERT INTO PTI_PINJAM "
                        + "VALUES(?, ?, TO_DATE(?, 'DD-MM-YYYY HH24:MI:SS'),?,"
                        + "TO_DATE(?, 'DD-MM-YYYY HH24:MI:SS'),'N')");
                ps.setString(1, p.getID_Peminjam());
                ps.setString(2, p.getID_Buku());
                ps.setString(3, p.getTanggal_pinjam());
                ps.setInt(4, p.getWaktu_pinjam());
                ps.setString(5, p.getTanggal_kembali());
                ps.executeUpdate();
                conn.commit();
                text = "Data sudah ditambahkan";
            } else {
                return false;
            }
        } catch (SQLException ex) {
        } finally {
            try {
                ps.close();
                conn.close();
            } catch (SQLException ex) {
            }
        }
        return true;
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
                    + "(ID_PEMINJAM=" + id + " AND STATUS='N')");
            int index = 0;
            while (rs.next()) {
                pin[index] = new Pinjam();
                pin[index].setID_Peminjam(rs.getString(1));
                pin[index].setID_Buku(rs.getString(2));
                pin[index].setTanggal_pinjam(rs.getString(3));
                pin[index].setWaktu_pinjam(rs.getInt(4));
                pin[index].setTanggal_kembali(rs.getString(5));
                pin[index].setTanggal_kembali(rs.getString(6));
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
