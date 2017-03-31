/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package WebService;

import Model.Anggota;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.ws.rs.GET;  
import javax.ws.rs.POST;
import javax.ws.rs.Path;  
import javax.ws.rs.Produces;  
import javax.ws.rs.core.MediaType;  

@Path("/daftar")
public class Daftar{  

    /**
     * Web service operation
     */
    @POST
    @WebMethod(operationName = "daftarMember")
    public Anggota daftarMember(@WebParam(name = "Nama") String Nama, 
            @WebParam(name = "Email") String Email, 
            @WebParam(name = "No_Tlp") String No_Tlp,
            @WebParam(name = "Alamat") String Alamat,
            @WebParam(name = "Password") String Password) {
        String timeStamp = new SimpleDateFormat("yyMMdd").format(Calendar.getInstance().getTime());
        Anggota a = new Anggota();
        String number = "000";
        int count = a.panggilID(timeStamp) + 1;
        if (count < 10) {
            number = "00" + String.valueOf(count);
        } else if (count < 100) {
            number = "0" + String.valueOf(count);
        } else {
            number = String.valueOf(count);
        }
        //membuat data
        a.setID_Angota(timeStamp + number);
        a.setNama(Nama);
        a.setEmail(Email);
        a.setNo_tlp(No_Tlp);
        a.setAlamat(Alamat);
        a.setPassword(Password);
        a.tambahAnggota(a);
        return a;
    }
}   