package Weekend_6_2;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by sanya on 14.02.2015.
 */
@Entity
public class Company {
    @SequenceGenerator(name = "sequence", sequenceName = "SEQ_NOTEBOOK_ID",
            allocationSize = 1, initialValue = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sequence")
    @Id
    @Column(name = "COMPANY_ID")
    private Long id;
    @Column(name = "NAME")
    private String name;

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "company",cascade = CascadeType.ALL)
    private Set<Employee> employees = new HashSet<Employee>();

    public Company(){

    }

    public Company(String name, Long id){
        this.name = name;
        this.id = id;

    }

    public void addEmployee(Employee empl) {
        employees.add(empl);
    }

    public Set<Employee> getEmployees(){
        return employees;
    }
}
