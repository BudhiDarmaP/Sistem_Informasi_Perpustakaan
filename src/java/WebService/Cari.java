/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package WebService;
 
import Model.Buku;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/buku")
public class Cari {

    @GET
    public Buku[] Pencarian(@WebParam(name = "key") String Key) {
        Buku[] bk = Buku.getListPencarian(Key);
        return bk;
    }
}
