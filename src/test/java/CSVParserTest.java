import static org.hamcrest.MatcherAssert.*;
import static org.hamcrest.Matchers.*;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import java.util.List;

public class CSVParserTest {
    static String[] columnMapping;
    static String path;

    @BeforeAll
    static public void beforeAll() {
        columnMapping = new String[]{"id", "firstName", "lastName", "country", "age"};
        path = "src/test/resources/dataTest.csv";
    }

    @Test
    void parseCSVTest() {
        Employee employee1 = new Employee(1, "John", "Smith", "USA", 25);
        Employee employee2 = new Employee(2, "Inav", "Petrov", "RU", 23);
        List<Employee> expected = List.of(employee1, employee2);

        List<Employee> employees = CSVParser.parseCSV(columnMapping, path);

        assertThat(employees, notNullValue());
        assertThat(employees, not(empty()));
        assertThat(employees, everyItem(instanceOf(Employee.class)));
        assertThat(employees, equalTo(expected));
    }
}