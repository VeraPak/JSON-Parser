import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class CSVParserTest {
    static String[] columnMapping;
    static List<Employee> employees;

    @BeforeAll
    static public void beforeAll() {
        columnMapping = new String[]{"id", "firstName", "lastName", "country", "age"};
        employees = CSVParser.parseCSV(columnMapping, "/Users/vera/IdeaProjects/Misc/JSON-Parser/src/test/data.csv");
    }

    @Test
    void testIsNotEmptyCSV(){
        assertNotNull(employees);
        assertFalse(employees.isEmpty());
    }

    static List<Employee> forPossitiveTest() {
        List<Employee> forPossitiveTest = new ArrayList<>();
        forPossitiveTest.add(employees.get(0));
        forPossitiveTest.add(employees.get(1));
        return forPossitiveTest;
    }

    @ParameterizedTest
    @MethodSource({"forPossitiveTest"})
    void testPossitiveArgumentsOfObjCSV(Employee employee){
        assertNotNull(employee);
        assertEquals(employee.getClass(), Employee.class);

        assertTrue(employee.getId() != 0);
        assertNotNull(employee.getFirstName());
        assertNotNull(employee.getLastName());
        assertNotNull(employee.getCountry());
        assertTrue(employee.getAge() >= 18);
    }

    @Test
    void emptyDataInEmployee(){
        Employee emptyDataInEmployee = employees.get(2);

        assertNotNull(emptyDataInEmployee);
        assertEquals(emptyDataInEmployee.getClass(), Employee.class);

        assertTrue(emptyDataInEmployee.getId() == 0);
        assertEquals("", emptyDataInEmployee.getFirstName());
        assertEquals("", emptyDataInEmployee.getLastName());
        assertEquals("", emptyDataInEmployee.getCountry());
        assertTrue(emptyDataInEmployee.getAge() == 0);
    }

    @Test
    void incorrectDataInEmployee(){
        Employee incorrectDataInEmployee = employees.get(3);

        assertNotNull(incorrectDataInEmployee);
        assertEquals(incorrectDataInEmployee.getClass(), Employee.class);

        assertTrue(incorrectDataInEmployee.getId() != 0);
        assertNotNull(incorrectDataInEmployee.getFirstName());
        assertEquals("", incorrectDataInEmployee.getLastName());
        assertNotNull(incorrectDataInEmployee.getCountry());
        assertTrue(incorrectDataInEmployee.getAge() < 18);
    }
}
