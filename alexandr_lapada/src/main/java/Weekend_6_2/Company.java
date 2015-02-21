package Weekend_6_2;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

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
    @Column
    private Double fond;

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "company",cascade = CascadeType.PERSIST)
    @Fetch(FetchMode.SELECT)
    private Set<Employee> employees = new HashSet<Employee>();

    public Company(){

    }

    public Company(String name, Long id, Double fond){
        this.name = name;
        this.id = id;
        this.fond = fond;
    }

    public void addEmployee(Employee empl) {
        employees.add(empl);
    }

    public Set<Employee> getEmployees(){
        return employees;
    }
}
