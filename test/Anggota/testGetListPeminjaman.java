/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Anggota;

import Model.Anggota;
import Model.Pinjam;

/**
 *
 * @author budhidarmap
 */
public class testGetListPeminjaman {
    //error
    public static void main(String[] args) {
        Anggota a = new Anggota();
        Pinjam [] p = Anggota.getListPeminjaman("145314000");
        
        for (int i = 0; i < p.length; i++) {
            System.out.println(p[i].getID_Peminjam()+","+
                    p[i].getID_Buku()+","+
                    p[i].getTanggal_pinjam()+","+
                    p[i].getWaktu_pinjam()+","+
                    p[i].getTanggal_kembali()+",");
        }
    }
}
