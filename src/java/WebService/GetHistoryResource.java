/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package WebService;

import Model.Buku;
import Model.Pinjam;
import javax.json.Json;
import javax.json.JsonArrayBuilder;
import javax.json.JsonObject;
import javax.json.JsonObjectBuilder;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.Produces;
import javax.ws.rs.Consumes;
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
@Path("getHistory")
public class GetHistoryResource {

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public JsonObject getJson(@QueryParam("id") String id) {
        // Ambil list buku dari database sesuai query
        Pinjam[] pinjam = Pinjam.getHistory(id);
        // Buat object JsonObject builder untuk dikirim
        JsonObjectBuilder JsonBuku = Json.createObjectBuilder();

        // Buat JsonArray untuk menanpung object buku
        JsonArrayBuilder arrayPinjam = Json.createArrayBuilder();

        // Buat array object buku builder
        JsonObjectBuilder[] objectPinjam = new JsonObjectBuilder[pinjam.length];

        // Masukan buku dari database ke object buku builder
        for (int i = 0; i < objectPinjam.length; i++) {
            objectPinjam[i] = Json.createObjectBuilder();
            objectPinjam[i].add("tgl_pinjam", pinjam[i].getTanggal_pinjam());
            objectPinjam[i].add("tgl_kembali", pinjam[i].getTanggal_kembali());
            objectPinjam[i].add("isbn", pinjam[i].getID_Buku());
            objectPinjam[i].add("waktu", pinjam[i].getWaktu_pinjam());
            objectPinjam[i].add("status", pinjam[i].getStatus());
            objectPinjam[i].add("judul", Buku.infoBuku(pinjam[i].getID_Buku()).getJudul());
            arrayPinjam.add(objectPinjam[i]);
        }

        // Masukan array buku builder ke object json
        JsonBuku.add("history", arrayPinjam);

        // Build json object yang akan dikirim
        JsonObject pinjamJsonObject = JsonBuku.build();

        return pinjamJsonObject;
    }

    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    public void putJson(String content) {
    }
}
