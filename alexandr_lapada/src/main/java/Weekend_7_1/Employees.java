package Weekend_7_1;

import Weekend_6_2.*;

import javax.persistence.*;

/**
 * Created by sanya on 21.02.2015.
 */
@Entity
public class Employees {
    @SequenceGenerator(name = "sequence", sequenceName = "SEQ_Emp_ID",
            allocationSize = 1, initialValue = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sequence")
    @Id
    private Long id;
    @Column(name = "FIRST_NAME")
    private String firstName;
    @Column(name = "LAST_NAME")
    private String lastName;
    @Column(name = "SALARY")
    private Double salary;


    public Employees() {
    }

    public Employees(String firtName, String lastName, Double salary){
        this.firstName = firtName;
        this.lastName = lastName;
        this.salary = salary;

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

    public Double getSalary() {
        return salary;
    }

    public void setSalary(Integer age) {
        this.salary = salary;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", salary=" + salary +
                '}';
    }
}
