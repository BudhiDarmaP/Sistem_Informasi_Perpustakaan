/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

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
    private int Ketersediaan;

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

    public int getKetersediaan() {
        return Ketersediaan;
    }

    public void setKetersediaan(int Ketersediaan) {
        this.Ketersediaan = Ketersediaan;
    }

}
