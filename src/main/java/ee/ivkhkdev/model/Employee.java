package ee.ivkhkdev.model;


import java.io.Serializable;
import java.util.Objects;
import java.util.UUID;

public class Employee implements Serializable {
    private UUID id;
    private String position;
    private String salary;
    private Person person;

    public Employee() {
        this.id = UUID.randomUUID();
    }

    public Employee(String position, String salary, Person person) {
        this.id = UUID.randomUUID();
        this.position = position;
        this.salary = salary;
        this.person = person;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public String getSalary() {
        return salary;
    }

    public void setSalary(String salary) {
        this.salary = salary;
    }

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Employee employee = (Employee) o;
        return Objects.equals(id, employee.id) && Objects.equals(position, employee.position) && Objects.equals(salary, employee.salary) && Objects.equals(person, employee.person);
    }

    @Override
    public int hashCode() {
        int result = Objects.hashCode(id);
        result = 31 * result + Objects.hashCode(position);
        result = 31 * result + Objects.hashCode(salary);
        result = 31 * result + Objects.hashCode(person);
        return result;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Employee{");
        sb.append("id=").append(id);
        sb.append(", position='").append(position).append('\'');
        sb.append(", salary='").append(salary).append('\'');
        sb.append(", person=").append(person);
        sb.append('}');
        return sb.toString();
    }
}
