package session13;


import javax.persistence.*;

/**
 * Created by sanya on 14.02.2015.
 */
@Entity
@Table(name = "EMPLOYEE")
public class Employee {
    @SequenceGenerator(name = "sequence", sequenceName = "SEQ_NOTEBOOK_ID",
            allocationSize = 1, initialValue = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sequence")
    @Id
    private Long id;
    @Column(name = "FIRST_NAME")
    private String firstName;
    @Column(name = "LAST_NAME")
    private String lastName;
    //@Column()
    //private Integer age;

    //private Company company;

    public Employee() {
    }

    public Employee(String firtName, String lastName, Long id){
        this.firstName = firtName;
        this.id = id;
        this.lastName = lastName;
        //this.age = age;

    }

    public Employee(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }
    //public void setCompany(Company company){
        //this.company = company;
    //}

    public String getName() {
        return firstName;
    }

    @Override
    public String toString() {
        return firstName;
    }

    public Long getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
}
