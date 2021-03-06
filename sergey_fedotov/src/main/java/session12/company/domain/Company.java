package session12.company.domain;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import javax.persistence.*;
import java.util.LinkedList;
import java.util.List;

/**
 *
 */
@Entity
@Table(name="COMPANY")
public class Company {

    @Id
    @SequenceGenerator(name = "auto", sequenceName = "SEQ_COMPANY_ID")
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "auto")
    @Column (name = "COMPANY_ID")
    private Long id;

    @Column (name = "NAME")
    private String name;

    @Column (name = "CHARTER_CAPITAL")
    private Double charterCapital;

    //    @OneToMany
    @Fetch(FetchMode.SELECT)
    @OneToMany
            (
            fetch = FetchType.EAGER, // подргужать все сразу
            mappedBy = "company", // включить двунаправленность
            cascade = CascadeType.ALL // каскадирование на сотрудников
            )
    private List<Employee> employees = new LinkedList<>();


    public Company() {
    }

    public Company(String name, double charterCapital) {
        this.name = name;
        this.charterCapital = charterCapital;
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

    public double getCharterCapital() {
        return charterCapital;
    }

    public void setCharterCapital(double charterCapital) {
        this.charterCapital = charterCapital;
    }


    @Override
    public String toString() {
        return "Company{id=" + id
                + ", name='" + name
                + "', employees=" + employees
                + "}";
    }
}
