package session12;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;


import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "COMPANY")
public class Company {
    @Id
    @SequenceGenerator(name = "sequence", sequenceName = "COMPANY_SEQ",
            allocationSize = 1, initialValue = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sequence")

    @Column(name = "COMPANY_ID")
    private Long id;

    @Column(name = "COMPANY_NAME")
    private String name;

    @Column(name = "COMPANY_CAPITAL")
    private String capital;


    @OneToMany(fetch = FetchType.EAGER,
                mappedBy = "company",
                cascade = CascadeType.ALL)
//    @Fetch(FetchMode.SELECT)

    private Set<Employee> employee = new HashSet<>();

    public Company() {
    }

    public Company(String name, String capital) {
        this.name = name;
        this.capital = capital;

    }
    public void addEmployee(Employee empl1){
        this.employee.add(empl1);
        empl1.setCompany(this);
    }

    public Set<Employee> getEmployee() {
        return employee;
    }

    public void setEmployee(Set<Employee> employee) {
        this.employee = employee;
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

    public String getCapital() {
        return capital;
    }

    public void setCapital(String capital) {
        this.capital = capital;
    }
}