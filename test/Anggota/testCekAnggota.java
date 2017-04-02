/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Anggota;

import Model.Anggota;

/**
 *
 * @author budhidarmap
 */
public class testCekAnggota {

    public static void main(String[] args) {
        Anggota a = new Anggota();
        String id ="145314063";
        if (a.cekAnggota(id)==1) {
            System.out.println("Anggota Terdaftar");
        }
        else {
            System.out.println("Anggota Tidak Terdaftar");
        }
    }
}
