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
public class testPanggilAnggota {

    public static void main(String[] args) {
        Anggota a = new Anggota();
        a = Anggota.panggilAnggota("145314063");
        System.out.println(a.getNama());
    }
}
