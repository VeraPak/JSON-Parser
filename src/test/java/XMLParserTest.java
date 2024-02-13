import static org.hamcrest.MatcherAssert.*;
import static org.hamcrest.Matchers.*;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import java.util.List;

class XMLParserTest {
    static String path;

    @BeforeAll
    static public void beforeAll() {
        path = "src/test/resources/dataTest.xml";
    }

    @Test
    void parseXMLTest() {
        Employee employee1 = new Employee(1, "John", "Smith", "USA", 25);
        Employee employee2 = new Employee(2, "Inav", "Petrov", "RU", 23);
        List<Employee> expected = List.of(employee1, employee2);

        List<Employee> employees = XMLParser.parseXML(path);

        assertThat(employees, notNullValue());
        assertThat(employees, not(empty()));
        assertThat(employees, everyItem(instanceOf(Employee.class)));
        assertThat(employees, equalTo(expected));
    }
}
