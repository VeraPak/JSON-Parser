import java.util.Objects;
import java.util.Random;

public class Employee {
    private long id;
    private String firstName;
    private String lastName;
    private String country;
    private int age;

    public Employee() {
    }

    public Employee(long id, String firstName, String lastName, String country, int age) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.country = country;
        this.age = age;
    }

    public long getId() {return id;}
    public String getFirstName() {
        return firstName;
    }
    public String getLastName() {
        return lastName;
    }
    public String getCountry() {
        return country;
    }
    public int getAge() {return age;}

    public void setId(long id) {this.id = id;}
    public void setFirstName(String firstName) {this.firstName = firstName;}
    public void setLastName(String lastName) {this.lastName = lastName;}
    public void setCountry(String country) {this.country = country;}
    public void setAge(int age) {this.age = age;}

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Employee employee = (Employee) o;
        return id == employee.id && age == employee.age && Objects.equals(firstName, employee.firstName) && Objects.equals(lastName, employee.lastName) && Objects.equals(country, employee.country);
    }

    @Override
    public int hashCode() {
        return Objects.hash(Employee.class, id, firstName, lastName, country, age);
    }

    @Override
    public String toString() {
        return "\"id\":" + id +
                ",\"firstName\":\"" + firstName + "\"" +
                ",\"lastName\":\"" + lastName + "\"" +
                ",\"country\":\"" + country + "\"" +
                ",\"age\":" + age +
                "}";
    }
}