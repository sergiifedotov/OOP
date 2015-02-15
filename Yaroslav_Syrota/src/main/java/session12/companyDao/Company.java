package session12.companyDao;


import session11.company.Employee;

import javax.persistence.*;
import java.util.Set;

/**
 * Created by @CAT_Caterpiller on 14.02.2015.
 */

@Entity
@Table
public class Company{
    @OneToMany(fetch = FetchType.EAGER)
    private Set<Employee> employeeSet;

    @Id
    @SequenceGenerator(name = "sequence", sequenceName = "SEQ_COMPANY_ID",
            allocationSize = 1, initialValue = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sequence")
    @Column(name="CLIENT_ID")
    private Long id;

    private String name;
    private int fond;



    public Company() {}



    public Company(String name) {
        this.name = name;

    }

    public Company(String name, Set<Employee> employeeSet) {
        this.name = name;
        this.employeeSet = employeeSet;
    }




    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getFond() {
        return fond;
    }

    public void setFond(int fond) {
        this.fond = fond;
    }
    public Set<Employee> getEmployeeSet() {
        return employeeSet;
    }

    public void setEmployeeSet(Set<session11.company.Employee> employeeSet) {
        this.employeeSet = employeeSet;
    }
}
