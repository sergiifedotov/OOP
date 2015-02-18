package session11;

import javax.persistence.*;

/**
 * Created by vladimir on 14.02.2015.
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

    private String name;

    @ManyToOne
    private Company company;
    private Double salary;

    public Employee() {
    }

    public Employee(String name, Double salary) {
        this.name = name;
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

    public Company getCompany() {
        return company;
    }

    public void setCompany(Company company) {
        this.company = company;
    }

    @Override
    public String toString() {
        return "Employee{id=" + id
                + ", name='" + name
                + "', salary=" + salary
                + ", company=" + company.getName() // чтобы оборвать рекурсию
                + "}";
    }

}
