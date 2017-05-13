package WebService;

import Control.CookieUtilities;
import Model.Buku;
import Model.Pinjam;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import javax.json.Json;
import javax.json.JsonObject;
import javax.json.JsonObjectBuilder;
import javax.servlet.http.Cookie;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.Consumes;
import javax.ws.rs.Produces;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PUT;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

/**
 * REST Web Service
 *
 * @author budhidarmap
 */
@Path("Kembali")
public class KembaliResource {

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public JsonObject getJson(@QueryParam("isbn") String isbn, @QueryParam("id") String id) {
        //deklarasi hasil
        String hasil = null;
        //panggil buku
        Buku b = Buku.getBuku(isbn);
        //deklarasi kelas dan timeStamp
        String timeStamp = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss").format(Calendar.getInstance().getTime());
        //deklarasi pinjam
        Pinjam p = new Pinjam();
        //cek copy
        int sedia = Buku.cekKetersediaan(isbn);
        //create json
        JsonObjectBuilder kembali = Json.createObjectBuilder();
        //cek status
        if (Pinjam.getPeminjaman(id, isbn)) {
            //pengembalian
            boolean test = p.Pengembalian(timeStamp, isbn, id);
            if (test) {
                //kembalikan true
                hasil = "Pengembalian Berhasil";
                //update copy
                Buku.UpdateKetersediaan(isbn, (sedia + 1));
            }
        }
        else{
            //kembalikan false
            hasil = "Pengembalian Gagal";
        }
        //tambah hasil ke Json pinjam
        kembali.add("Hasil", hasil);
        // Build json object yang akan dikirim
        JsonObject kembaliJsonObject = kembali.build();
        //kembalikan json
        return kembaliJsonObject;
    }
}
