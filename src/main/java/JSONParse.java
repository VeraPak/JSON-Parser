import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.json.simple.JSONArray;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

public class JSONParse {

    public static String readString(String fileName) {

        String str;
        StringBuilder sb = new StringBuilder();

        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            while ((str = reader.readLine()) != null) {
                sb.append(str);
            }
        } catch (IOException ex) {
            ex.getStackTrace();
        }
        return sb.toString();
    }

    public static List<Employee> jsonToList(String json) {
        List<Employee> list = new ArrayList<>();

        JSONParser parser = new JSONParser();

        try {
            JSONArray jsonArray = (JSONArray) parser.parse(json);

            GsonBuilder builder = new GsonBuilder();
            Gson gson = builder.create();

            for (int i = 0; i < jsonArray.size(); i++) {
                String js = String.valueOf(jsonArray.get(i));
                Employee employee = gson.fromJson(js, Employee.class);
                list.add(employee);
            }

        } catch (ParseException e) {
            throw new RuntimeException(e);
        }

        return list;
    }
}
