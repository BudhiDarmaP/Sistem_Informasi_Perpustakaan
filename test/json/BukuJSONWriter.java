package json;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.OutputStream;

import javax.json.Json;
import javax.json.JsonArrayBuilder;
import javax.json.JsonObject;
import javax.json.JsonObjectBuilder;
import javax.json.JsonWriter;
import Model.Buku;

public class BukuJSONWriter {

	public static void main(String[] args) throws FileNotFoundException {

		Buku buku = createBuku();
                
		JsonObjectBuilder bukuBuilder = Json.createObjectBuilder();


		bukuBuilder.add("isbn", buku.getISBN());
                bukuBuilder.add("judul", buku.getJudul());
                bukuBuilder.add("ketersediaan", buku.getKetersediaan());
                bukuBuilder.add("penerbit", buku.getPenerbit());
                bukuBuilder.add("penulis", buku.getPenulis());
                bukuBuilder.add("tahun", buku.getTahun_Terbit());

		
		JsonObject bukuJsonObject = bukuBuilder.build();
		
		System.out.println("Employee JSON String\n"+bukuJsonObject);
		
		//write to file
		OutputStream os = new FileOutputStream("buku.txt");
		JsonWriter jsonWriter = Json.createWriter(os);
		/**
		 * We can get JsonWriter from JsonWriterFactory also
		JsonWriterFactory factory = Json.createWriterFactory(null);
		jsonWriter = factory.createWriter(os);
		*/
		jsonWriter.writeObject(bukuJsonObject);
		jsonWriter.close();
	}
        
        public static Buku createBuku(){
            Buku buku = new Buku();
            buku.setISBN("123456789");
            buku.setJudul("Ini Buku");
            buku.setKetersediaan(2);
            buku.setPenerbit("ini penerbit");
            buku.setPenulis("ini penulis");
            buku.setTahun_Terbit("1995");
            return buku;
        }

}
