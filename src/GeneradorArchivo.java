import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.FileWriter;
import java.io.IOException;

public class GeneradorArchivo {

    public void guardarJsonMoneda (Moneda moneda) throws IOException {
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        FileWriter escribeJson = new FileWriter(moneda.base_code());
        escribeJson.write(gson.toJson(moneda));
        escribeJson.close();
    }
}
