package session11;

import javax.persistence.*;
import java.util.Set;

/**
 * Created by stan on 15.02.15.
 */
@Entity
@Table(name="COMPANIES")
public class Company {


    @Id
    @SequenceGenerator(name = "sequence", sequenceName = "SEQ_COMPANIES_ID")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sequence")
    @Column(name = "COMPANY_ID")
    private Long id;

    @Column(name = "COMPANY_NAME")
    private String name;


    @Column(name = "ustavnoi_fond")
    private Integer fond;

    @OneToMany(mappedBy = "company", cascade = CascadeType.ALL)
    private Set<Employee> employees;

    public Company() {
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

    public Integer getFond() {
        return fond;
    }

    public void setFond(Integer fond) {
        this.fond = fond;
    }

    public Set<Employee> getEmployees() {
        return employees;
    }

    public void setEmployees(Set<Employee> employees) {
        this.employees = employees;
    }
}