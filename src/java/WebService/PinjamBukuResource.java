package WebService;

import Model.Anggota;
import Model.Buku;
import Model.Pinjam;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import javax.json.Json;
import javax.json.JsonObject;
import javax.json.JsonObjectBuilder;
import javax.ws.rs.Produces;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

/**
 * REST Web Service
 *
 * @author budhidarmap
 */
@Path("PinjamBuku")
public class PinjamBukuResource {

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public JsonObject getJson(@QueryParam("isbn") String isbn, @QueryParam("id") String id) {
        String hasil;
        //menambahkan kalender
        GregorianCalendar cal = (GregorianCalendar) GregorianCalendar.getInstance();
        //deklarasi kelas dan timeStamp
        String timeStamp = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss").format(Calendar.getInstance().getTime());

        cal.add(Calendar.WEEK_OF_YEAR, 1);
        Date dtNextWeek = cal.getTime();
        String df = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss").format(dtNextWeek);
        //deklarasi variable pinjam
        Buku b = Buku.getBuku(isbn);
        Pinjam p = new Pinjam();
        JsonObjectBuilder pinjam = Json.createObjectBuilder();
        //set data pada kelas model
        p.setID_Peminjam(id);
        p.setID_Buku(isbn);
        p.setTanggal_pinjam(timeStamp);
        p.setWaktu_pinjam(7);
        p.setTanggal_kembali(df);
        //cek ketersediaan
        int sedia = Buku.cekKetersediaan(isbn);
        int test = Anggota.cekAnggota(id);
        if (sedia < 1 && test!=0) {
            hasil = "Peminjaman Gagal";
        } else {
            //simpan peminjaman
            boolean a = Anggota.simpanPeminjaman(p);
            //cek dan ubah copy
            Buku.UpdateKetersediaan(p.getID_Buku(), (sedia - 1));
            if (a) {
                //kembalikan true
                hasil = "Peminjaman Berhasil";
                // Buat array object pinjam builder
                pinjam = Json.createObjectBuilder();
                pinjam.add("tgl_pinjam", p.getTanggal_pinjam());
                pinjam.add("tgl_kembali", p.getTanggal_kembali());
                pinjam.add("status", p.getID_Peminjam());
                pinjam.add("isbn", p.getID_Buku());
                pinjam.add("lama pinjam", p.getWaktu_pinjam());
            } else {
                //kembalikan false
                hasil = "Peminjaman Gagal";
            }
        }
        //tambah hasil ke Json pinjam
        pinjam.add("Hasil", hasil);
        // Build json object yang akan dikirim
        JsonObject pinjamJsonObject = pinjam.build();
        //kembalikan json
        return pinjamJsonObject;
    }
}
