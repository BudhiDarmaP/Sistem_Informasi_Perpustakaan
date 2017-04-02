/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Buku;

import Model.Buku;

/**
 *
 * @author budhidarmap
 */
public class testUpdateKetersediaan {

    public static void main(String[] args) {
        int sedia=0;
        Buku b = new Buku();
        sedia=Buku.cekKetersediaan("9780596529260");
        b.UpdateKetersediaan("9780596529260", (sedia+1));
        System.out.println(Buku.cekKetersediaan("9780596529260"));
    }
}
