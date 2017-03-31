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
public class testLoginAnggota {
    public static void main(String[] args) {
        Anggota a = null;
                a = Anggota.LoginAnggota("145314063", "budhi");
        System.out.println(a.getID_Angota());
        System.out.println(a.getNama());
        System.out.println(a.getEmail());
        System.out.println(a.getNo_tlp());
        System.out.println(a.getAlamat());
    }
}
