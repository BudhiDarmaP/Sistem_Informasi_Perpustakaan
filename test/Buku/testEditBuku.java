/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Buku;

import Anggota.*;
import Model.Buku;
import java.text.SimpleDateFormat;
import java.util.Calendar;

/**
 *
 * @author budhidarmap
 */
public class testEditBuku {
    public static void main(String[] args) {
        Buku b=new Buku();
        b.setISBN("9781476763262");
        b.setJudul("Dark Territory: The Secret History of Cyber War");
        b.setPenulis("Fred Kaplan");
        b.setTahun_Terbit("2017");
        b.setPenerbit("Simon & Schuster");
        b.setKetersediaan(1);
        b.editBuku(b);
    }
}
