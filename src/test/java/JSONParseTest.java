import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;
import static org.hamcrest.Matchers.equalTo;
import static org.junit.jupiter.api.Assertions.*;

class JSONParseTest {
    static String path;
    static Employee employee1;
    static Employee employee2;

    @BeforeAll
    static public void beforeAll(){
        path = "src/test/resources/dataTest.json";
        employee1 = new Employee(1, "John", "Smith", "USA", 25);
        employee2 = new Employee(2, "Inav", "Petrov", "RU", 23);
    }

    @Test
    void jsonToList() {
        List<Employee> expected = List.of(employee1, employee2);

        String json = JSONParse.readString(path);
        List<Employee> employees = JSONParse.jsonToList(json);

        assertThat(employees, notNullValue());
        assertThat(employees, not(empty()));
        assertThat(employees, everyItem(instanceOf(Employee.class)));
        assertThat(employees, equalTo(expected));
    }
}