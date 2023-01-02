package be.helb.model;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;

@Entity
public class Exercice implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "name")
    private String name;
    @Column(name = "unit")
    private int unit;

    public Exercice(String name) {
        this.name = name;
    }

    public Exercice() {
    }

    public void setId(Long id) {
        this.id = id;
    }
    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getUnits() {
        return unit;
    }

    public void setUnits(int unit) {
        this.unit = unit;
    }

}
