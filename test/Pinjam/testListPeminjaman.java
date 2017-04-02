/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Pinjam;

import Model.Pinjam;

/**
 *
 * @author budhidarmap
 */
public class testListPeminjaman {

    public static void main(String[] args) {
        String id = "145314063";
        Pinjam[] p = Pinjam.getListPinjaman(id);
        if (Pinjam.getListPinjaman(id) != null) {
            for (int i = 0; i < p.length; i++) {
                System.out.println(p[i].getID_Peminjam());
                System.out.println(p[i].getID_Buku());
                System.out.println(p[i].getTanggal_pinjam());
                System.out.println(p[i].getWaktu_pinjam());
                System.out.println(p[i].getTanggal_kembali());
                System.out.println(p[i].getStatus());
            }
        }
    }
}
