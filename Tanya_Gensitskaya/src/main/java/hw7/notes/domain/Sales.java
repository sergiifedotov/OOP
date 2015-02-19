package hw7.notes.domain;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "Sales")
public class Sales {
    @SequenceGenerator(name = "sequence", sequenceName = "SEQ_STORE_ID",
            allocationSize = 1, initialValue = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sequence")

    @Id
    @Column(name = "SALES_ID")
    private Long id;

    @Column(name = "NOTEBOOK")
    private Notebook notebook;

    @Temporal(TemporalType.DATE)
    @Column(name = "SALES_DATE")
    private Date salesDate;

    @Column(name = "AMOUNT")
    private Integer amount;

    public Sales() {
    }

    public Sales(Notebook notebook, Date salesDate, Integer amount) {
        this.notebook = notebook;
        this.salesDate = salesDate;
        this.amount = amount;
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Notebook getNotebook() {
        return notebook;
    }

    public void setNotebook(Notebook notebook) {
        this.notebook = notebook;
    }

    public Date getSalesDate() {
        return salesDate;
    }

    public void setSalesDate(Date salesDate) {
        this.salesDate = salesDate;
    }

    public Integer getAmount() {
        return amount;
    }

    public void setAmount(Integer amount) {
        this.amount = amount;
    }

    @Override
    public String toString() {
        return "Sales {id=" + id
                + ", notebook='" + notebook
                + ", salesDate='" + salesDate
                + ", amount='" + amount
                + "}";
    }
}

