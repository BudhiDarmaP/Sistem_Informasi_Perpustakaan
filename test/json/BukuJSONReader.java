package json;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

import javax.json.Json;
import javax.json.JsonArray;
import javax.json.JsonObject;
import javax.json.JsonReader;
import javax.json.JsonValue;
import Model.Buku;

public class BukuJSONReader {

    public static final String JSON_FILE = "buku.txt";

    public static void main(String[] args) throws IOException {
        InputStream fis = new FileInputStream(JSON_FILE);

        //create JsonReader object
        JsonReader jsonReader = Json.createReader(fis);

        /**
         * We can create JsonReader from Factory also JsonReaderFactory factory
         * = Json.createReaderFactory(null); jsonReader =
         * factory.createReader(fis);
         */
        //get JsonObject from JsonReader
        JsonObject jsonObject = jsonReader.readObject();
        JsonArray array = jsonObject.getJsonArray("buku");
        //we can close IO resource and JsonReader now
        jsonReader.close();
        fis.close();

        //Retrieve data from JsonObject and create Employee bean
        Buku buku[] = null;
        int i=0;
        
            //print employee bean information
            System.out.println(buku[i].getJudul());
            i++;
    }
}
