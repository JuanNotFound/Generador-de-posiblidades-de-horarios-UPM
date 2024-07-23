package dev.juest.Logic.read;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import dev.juest.domain.Lesson;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;

public class JsonManager {

    private String readFileAsString(String filePath) throws IOException {
        StringBuilder sb = new StringBuilder();
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = br.readLine()) != null) {
                sb.append(line);
            }
        }
        return sb.toString();
    }

    //------------------------------------------------------------------------------------------------------------------


    public List<Lesson> parseJSON(String filePath) throws IOException {
        Gson gson = new Gson();

        return gson.fromJson(readFileAsString(filePath), new TypeToken<List<Lesson>>(){}.getType());
    }

    //------------------------------------------------------------------------------------------------------------------

}
