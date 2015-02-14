package session11.company;

import javax.persistence.*;

/**
 * Created by @CAT_Caterpiller on 14.02.2015.
 */

@Entity
@Table
public class Employee {
    @ManyToOne
    private Company company;

    @Id
    @SequenceGenerator(name = "sequence", sequenceName = "SEQ_EMPLOYEE_ID",
            allocationSize = 1, initialValue = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sequence")
    @Column(name="CLIENT_ID")
    private Long id;

    private String name;

    public Employee() {}

    public Employee(String name, Company company) {
        this.name = name;
        this.company = company;
    }
}
