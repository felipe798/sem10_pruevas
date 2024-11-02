package com.tecsup.petclinic.entities;

import jakarta.persistence.*;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.sql.Date;

/**
 * Entity class for Visit
 *
 */
@Entity(name = "visits")
@Data
public class Visit {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "pet_id")
    private int petId;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @Column(name = "visit_date")
    private Date visitDate;

    private String description;

    public Visit() {
    }

    public Visit(Integer id, int petId, Date visitDate, String description) {
        super();
        this.id = id;
        this.petId = petId;
        this.visitDate = visitDate;
        this.description = description;
    }

    public Visit(int petId, Date visitDate, String description) {
        super();
        this.petId = petId;
        this.visitDate = visitDate;
        this.description = description;
    }
}
