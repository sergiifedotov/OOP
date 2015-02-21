package session13.DAO;

import javax.persistence.*;

/**
 * Created by tsv on 21.02.15.
 */
@Entity
@Table
public class EmployeeTwoDao {

    @Id
    @Column
    private Long id;

    @Column
    private String firstName;

    @Column
    private String lastName;

    @ManyToOne
    private CompanyTwoDao companyTwoDao;

    @Override
    public String toString() {
        return "Employee{" +
                ", First Name='" + firstName + '\'' +
                ", Last Name='" + lastName + '\'' +
                ", Company=" + companyTwoDao.getName() +
                '}';
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setCompanyTwoDao(CompanyTwoDao companyTwoDao) {
        this.companyTwoDao = companyTwoDao;
    }
}
