import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

class XMLParserTest {
    static String path;

    @BeforeAll
    static public void beforeAll() {
        path = "/Users/vera/IdeaProjects/Misc/JSON-Parser/src/test/Files/dataPossitiveTest.xml";
    }

    @Test
    void parseXMLTest() {
        List<Employee> employees = XMLParser.parseXML(path);
        assertThat(employees, notNullValue());
        assertThat(employees, not(empty()));

        for (Employee employee : employees) {
            assertThat(employee, notNullValue());
            assertThat(employee, instanceOf(Employee.class));

            assertThat(employee.getId(), greaterThan(0L));
            assertThat(employee.getFirstName(), matchesPattern("[A-Z][a-z]*"));
            assertThat(employee.getLastName(), matchesPattern("[A-Z][a-z]*"));
            assertThat(employee.getCountry(), matchesPattern("[A-Z]+"));
            assertThat(employee.getAge(), allOf(greaterThan(18), lessThanOrEqualTo(110)));
        }
    }
}
