package session11;

import javax.persistence.*;

/**
 * Created by stan on 15.02.15.
 */
@Entity
@Table(name="EMPLOYEES")
public class Employee {

    @Id
    @SequenceGenerator(name = "sequence", sequenceName = "SEQ_EMPLOYEES_ID")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sequence")
    @Column(name = "EMPLOYEE_ID")
    private Long id;

    @Column(name = "FIRST_NAME")
    private String firstName;

    @Column(name = "LAST_NAME")
    private String lastName;


    @ManyToOne
    @JoinColumn(name = "COMPANY_ID")
    private Company company;

    public Employee() {}

    public Company getCompany() {
        return company;
    }

    public void setCompany(Company company) {
        this.company = company;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

}
