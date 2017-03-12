
import Model.Buku;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author budhidarmap
 */
public class Test {
    public static void main(String[] args) {
        Buku[] bk = Buku.getListPencarian("Web");
        for (int i = 0; i < 2; i++) {
            System.out.println(bk[i].getJudul());
        }
    }
}
