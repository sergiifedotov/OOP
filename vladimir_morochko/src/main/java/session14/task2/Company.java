package session14.task2;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import javax.persistence.*;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by vladimir on 14.02.2015.
 */
@Entity
@Table(name = "COMPANIES")
public class Company {
    @SequenceGenerator(name = "sequence", sequenceName = "SEQ_COMPANIES_ID",
            allocationSize = 1, initialValue = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sequence")
    @Id
    @Column (name = "COMPANY_ID")
    private Long id;

    private String name;
//    @OneToMany
    @OneToMany(
            fetch = FetchType.EAGER, // подгружать все сразу
            mappedBy = "company", // включить двунаправленность
            cascade = CascadeType.ALL // каскадирование на сотрудников
    )
    @Fetch(FetchMode.SELECT)
    private List<Employee> employees = new LinkedList<>();

    public Company() {
    }

    public Company(String name) {
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public List<Employee> getEmployees() {
        return employees;
    }

    public void setEmployees(List<Employee> employees) {
        this.employees = employees;
    }

    public void hireEmployee (Employee employee) {
        employee.setCompany(this);
        employees.add(employee);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Company{id=" + id
                + ", name='" + name
                + "', employees=" + employees
                + "}";
    }
}
