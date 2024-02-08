import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.instanceOf;
import static org.junit.jupiter.api.Assertions.*;

class JSONParseTest {

    static File fileForTestJson;

    @BeforeAll
    static public void beforeAll(){
        fileForTestJson = new File("/Users/vera/IdeaProjects/Misc/JSON-Parser/src/test/test.json");
        try {
            fileForTestJson.createNewFile();
            Files.copy(new File("data.json").toPath(), fileForTestJson.toPath(), StandardCopyOption.REPLACE_EXISTING);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

    @AfterAll
    static public void afterAll() {
        fileForTestJson.delete();
    }


    @Test
    void jsonToList() {

        String json = JSONParse.readString(fileForTestJson.getAbsolutePath());

        List<Employee> result = JSONParse.jsonToList(json);

        for (Employee employee : result) {
            assertThat(employee, instanceOf(Employee.class));
        }
    }
}