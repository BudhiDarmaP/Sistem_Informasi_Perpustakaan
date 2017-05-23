
import Model.Anggota;
import Model.Buku;
import Model.Pinjam;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import javax.json.Json;
import javax.json.JsonObjectBuilder;

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
//        Anggota a= new Anggota();
//        a.setID_Angota("145314045");
//        a.setNama("Sekar");
//        a.setEmail("email@gmail.com");
//        a.setNo_tlp("0812345678912");
//        a.setAlamat("Entah");
//        a.setPassword("123");
//        a.tambahAnggota(a);
        System.out.println(Pinjam.getPeminjaman("001230517", "9781449356569"));
    }
    
}
