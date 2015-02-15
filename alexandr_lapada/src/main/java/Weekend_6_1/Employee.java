package Weekend_6_1;

import javax.persistence.*;

/**
 * Created by sanya on 14.02.2015.
 */
@SuppressWarnings("JpaAttributeTypeInspection")
@Entity
public class Employee {
    @SequenceGenerator(name = "sequence", sequenceName = "SEQ_NOTEBOOK_ID",
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
    @ManyToOne(cascade = CascadeType.ALL)
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

}
