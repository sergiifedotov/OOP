package session11.company;


import javax.persistence.*;
import java.util.Set;

/**
 * Created by @CAT_Caterpiller on 14.02.2015.
 */

@Entity
@Table
public class Company {
    @OneToMany
    private Set<Employee> employeeSet;

    @Id
    @SequenceGenerator(name = "sequence", sequenceName = "SEQ_COMPANY_ID",
            allocationSize = 1, initialValue = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sequence")
    @Column(name="CLIENT_ID")
    private Long id;

    private String name;


    public Company() {}

    public Set<Employee> getEmployeeSet() {
        return employeeSet;
    }

    public void setEmployeeSet(Set<Employee> employeeSet) {
        this.employeeSet = employeeSet;
    }

    public Company(String name) {
        this.name = name;

    }
    
    public Company(String name, Set<Employee> employeeSet) {
        this.name = name;
        this.employeeSet = employeeSet;
    }
}
