package mypackeg.entities;

import jakarta.persistence.*;
import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;

@Entity
@Data
@Table(name = "workers")
@SequenceGenerator(name = "id_gen",allocationSize = 1)
public class Worker extends BaseEntity{
    @ManyToOne
    private Pharmacy pharmacy;
    private String name;
    private String email;
    private String address;
    private BigDecimal salary;
    private Date dateOfBirth;

    public Worker(String name, String email, String address, BigDecimal salary, Date dateOfBirth) {
        this.name = name;
        this.email = email;
        this.address = address;
        this.salary = salary;
        this.dateOfBirth = dateOfBirth;
    }

    public Worker() {

    }
}
