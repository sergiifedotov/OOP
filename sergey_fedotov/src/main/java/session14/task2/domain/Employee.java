package session14.task2.domain;

import javax.persistence.*;

/**
 */

@Entity
@Table(name = "EMPLOYEES")
public class Employee {
    @SequenceGenerator(name = "sequence", sequenceName = "SEQ_EMPLOYEES_ID",
            allocationSize = 1, initialValue = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sequence")
    @Id
    @Column (name = "EMPLOYEE_ID")
    private Long id;

    @Column (name = "FIRST_NAME")
    private String first_name;

    @Column (name = "LAST_NAME")
    private String last_name;

    @Column (name = "SALARY")
    private Double salary;

    public Employee() {
    }

    public Employee(String first_name, String last_name, Double salary) {
        this.first_name = first_name;
        this.last_name = last_name;
        this.salary = salary;
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Double getSalary() {
        return salary;
    }

    public void setSalary(Double salary) {
        this.salary = salary;
    }


    public String getFirst_name() {
        return first_name;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public String getLast_name() {
        return last_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", first_name='" + first_name + '\'' +
                ", last_name='" + last_name + '\'' +
                ", salary=" + salary +
                '}';
    }
}
