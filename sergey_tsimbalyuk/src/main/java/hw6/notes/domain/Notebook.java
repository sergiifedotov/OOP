package hw6.notes.domain;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by tsv on 09.02.15.
 */
@Entity
@Table(name="NOTEBOOKS")
public class Notebook {
    @Id
    @SequenceGenerator(name = "sequence", sequenceName = "SEQ_NOTEBOOKS_ID",
            allocationSize = 1, initialValue = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sequence")

    @Column(name = "ID")
    private Long id;

    @Column(name = "SERIAL")
    private String serial;

    @Column(name = "VENDOR")
    private String vendor;

    @Column(name = "MODEL")
    private String model;

    @Column(name = "MANUFACTURE_DATE")
    private Date manufactureDate;

    @Column(name = "PRICE")
    private Double price;


    public Notebook() {

    }
}
