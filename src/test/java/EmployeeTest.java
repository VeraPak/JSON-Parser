import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class EmployeeTest {
    static Employee employee1;
    static Employee employee2;
    static Employee employee3;

    @BeforeAll
    static void beforeAll() {
        employee1 = new Employee(1, "Bob", "Marley", "JAM", 55);
        employee2 = new Employee(1, "Bob", "Marley", "JAM", 55);
        employee3 = new Employee(338, "John", "Snow", "ST", 30);
    }

    @Test
    void testHashCodePossitive() {
        assertTrue(employee1.hashCode() == employee2.hashCode());
    }
    @Test
    void testEqualsPossitive() {
        assertTrue(employee1.equals(employee1));
    }

    @Test
    void testHashCodeNegative() {
        assertFalse(employee1.hashCode() == employee3.hashCode());
    }
    @Test
    void testEqualsNegative() {
        assertFalse(employee1.equals(employee3));
    }
}