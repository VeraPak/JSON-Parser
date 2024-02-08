import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        // (1)CSVParser
        String[] columnMapping = {"id", "firstName", "lastName", "country", "age"};
        String fileName = "data.csv";

        List<Employee> listCSV = CSVParser.parseCSV(columnMapping, fileName);
        String json1 = listToJson(listCSV);
        writeString(json1, "data.json");

        // (2)XMLParser
        List<Employee> listXML = XMLParser.parseXML("dataNegativeTest.xml");
        String json2 = listToJson(listXML);
        writeString(json2, "data2.json");

        // (3)JSONParse
        String json = JSONParse.readString("data.json");
        List<Employee> list = JSONParse.jsonToList(json);

        for (Employee employee : list) {
            System.out.println(employee);
        }
    }

    private static String listToJson(List<Employee> list) {
        GsonBuilder builder = new GsonBuilder();
        Gson gson = builder.create();

        Type listType = new TypeToken<List<Employee>>() {
        }.getType();
        return gson.toJson(list, listType);
    }

    private static void writeString(String json, String fileName) {
        try (FileWriter fw = new FileWriter(fileName)) {
            fw.write(String.valueOf(json));
            fw.flush();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
}
