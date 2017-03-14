
import Model.Anggota;
import Model.Buku;
import Model.Pinjam;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author budhidarmap
 */
public class Test {
    public static void main(String[] args) {
        
//        Pinjam[] t = new Pinjam[1];
//        for (int i = 0; i < 1; i++) {
//            t[i] = new Pinjam();
//            t[i].setID_Peminjam("145314063");
//            t[i].setID_Buku("9781455539741001");
//            t[i].setTanggal_pinjam("14-03-2017");
//            t[i].setWaktu_pinjam(7);
//            Anggota.simpanPeminjaman(t[i]);
//        }
        Pinjam.UbahStatusKetersediaan("9781455539741001");
    }
}
