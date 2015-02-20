package session12;

import javax.persistence.*;

/**
 * Created by ZaR on 15.02.15.
 */
@Entity
@Table(name = "EMPLOYEE")
public class Employee {
    @Id
    @SequenceGenerator(name = "sequence", sequenceName = "EMPLOYEE_SEQ",
            allocationSize = 1, initialValue = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sequence")

    @Column(name = "EMPLOYEE_ID")
    private Long id;

    @Column(name = "EMPLOYEE_NAME")
    private String name;

    @ManyToOne
    private Company company;


    public Employee() {
    }

    public Employee(String name) {
        this.name = name;

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Company getCompany() {
        return company;
    }

    public void setCompany(Company company) {
        this.company = company;
    }
}
