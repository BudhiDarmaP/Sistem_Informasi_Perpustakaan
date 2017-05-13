
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
public class NewMain {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Buku[] buku = Buku.getListPencarian("");
        for (int i = 0; i < buku.length; i++) {
            System.out.println(buku[i].getJudul());
        }
    }
    
}
