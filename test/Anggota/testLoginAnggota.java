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
        if (a.LoginAnggota("145314009", "budhi")) {
            System.out.println("Login");
        }
        else{
            System.out.println("Gagal");
        }
    }
}
