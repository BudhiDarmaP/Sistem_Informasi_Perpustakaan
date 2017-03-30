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
public class testEditAnggota {
    public static void main(String[] args) {
        Anggota a=new Anggota();
         a.setID_Angota("145314000");
        a.setNama("Elisabeth Kusuma Adi");
        a.setEmail("email");
        a.setNo_tlp("no_tlp");
        a.setAlamat("alamat");
        a.setPassword("password");
        a.editMember(a);
    }
}
