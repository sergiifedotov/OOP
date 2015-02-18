package Weekend_6_2;

import javax.persistence.*;

/**
 * Created by sanya on 14.02.2015.
 */

@Entity
public class Employee {
    @SequenceGenerator(name = "sequence", sequenceName = "SEQ_Emp_ID",
            allocationSize = 1, initialValue = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sequence")
    @Id
    private Long id;
    @Column
    private String firstName;
    @Column
    private String lastName;
    @Column
    private Integer age;
    @ManyToOne
    private Company company;

    public Employee() {
    }

    public Employee(String firtName, String lastName, Integer age, Long id){
        this.firstName = firtName;
        this.id = id;
        this.lastName = lastName;
        this.age = age;

    }

    public void setCompany(Company company){
        this.company = company;
    }

    public String getName() {
        return firstName;
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

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Company getCompany() {
        return company;
    }
}
