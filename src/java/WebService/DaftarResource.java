package WebService;

import Model.Anggota;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import javax.json.Json;
import javax.json.JsonObject;
import javax.json.JsonObjectBuilder;
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
@Path("Daftar")
public class DaftarResource {

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public JsonObject getJson(
            @QueryParam("nama") String nama,
            @QueryParam("email") String email,
            @QueryParam("no_tlp") String no_tlp,
            @QueryParam("alamat") String alamat,
            @QueryParam("password") String password) {
        //deklarasi hasil
        String hasil;
        //create json
        JsonObjectBuilder daftar = Json.createObjectBuilder();
        //CEK ID
        String timeStamp = new SimpleDateFormat("yyMMdd").format(Calendar.getInstance().getTime());
        Anggota a = new Anggota();
        String number = "000";
        int count = Anggota.panggilID(timeStamp) + 1;
        if (count < 10) {
            number = "00" + String.valueOf(count);
        } else if (count < 100) {
            number = "0" + String.valueOf(count);
        } else {
            number = String.valueOf(count);
        }
        //membuat id | generate id
        a.setID_Angota(timeStamp + number);
        //cek nama
        if (nama.matches("[0-9]*") == true) {
            //hasil
            hasil = "Nama mengandung angka";
            //tambah hasil ke Json pinjam
            daftar.add("error", hasil);
            // Build json object yang akan dikirim
            JsonObject daftarJsonObject = daftar.build();
            //kembalikan json
            return daftarJsonObject;
        }
        //cek no_tlp
        if (no_tlp.matches("[0-9]*") == false) {
            //hasil
            hasil = "No telepon menganding huruf";
            //tambah hasil ke Json pinjam
            daftar.add("error", hasil);
            // Build json object yang akan dikirim
            JsonObject daftarJsonObject = daftar.build();
            //kembalikan json
            return daftarJsonObject;
        }
        //set parameter ke kelas model
        a.setNama(nama);
        a.setEmail(email);
        a.setNo_tlp(no_tlp);
        a.setAlamat(alamat);
        a.setPassword(password);
        //tambah anggota
        Anggota.tambahAnggota(a);
        if (Anggota.panggilAnggota(timeStamp+number).getNama().equals(nama)
                && Anggota.panggilAnggota(timeStamp+number).getEmail().equals(email)
                && Anggota.panggilAnggota(timeStamp+number).getNo_tlp().equals(no_tlp)
                && Anggota.panggilAnggota(timeStamp+number).getAlamat().equals(alamat)
                && Anggota.panggilAnggota(timeStamp+number).getPassword().equals(password)) {
            a=Anggota.panggilAnggota(timeStamp+number);
            hasil = "Pendaftaran Berhasil";
            //tambah hasil ke Json pinjam
            daftar = Json.createObjectBuilder();
            daftar.add("Result", hasil);
            daftar.add("ID", a.getID_Angota());
            daftar.add("Nama", a.getNama());
            daftar.add("Email", a.getEmail());
            daftar.add("No Telepon", a.getNo_tlp());
            daftar.add("Alamat", a.getAlamat());
            daftar.add("Password", a.getPassword());
            // Build json object yang akan dikirim
            JsonObject daftarJsonObject = daftar.build();
            //kembalikan json
            return daftarJsonObject;
        } else {
            hasil = "Pendaftaran Gagal";
            //tambah hasil ke Json pinjam
            daftar.add("error", hasil);
            // Build json object yang akan dikirim
            JsonObject daftarJsonObject = daftar.build();
            //kembalikan json
            return daftarJsonObject;
        }
    }
}
