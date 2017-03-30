/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Anggota;

import Model.Anggota;
import Model.Pinjam;
import java.text.SimpleDateFormat;
import java.util.Calendar;

/**
 *
 * @author budhidarmap
 */
public class testSimpanPeminjaman {
    public static void main(String[] args) {
    String timeStamp = new SimpleDateFormat("ddMMyyyy").format(Calendar.getInstance().getTime());
    Pinjam p=new Pinjam();
        p.setID_Peminjam("145314000");
        p.setID_Buku("9781449356569");
        p.setTanggal_pinjam(timeStamp);
        p.setWaktu_pinjam(7);
        Anggota a = new Anggota();
        a.simpanPeminjaman(p);
    }
}
