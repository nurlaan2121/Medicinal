package mypackeg.entities;

import jakarta.persistence.*;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
@Entity
@Table(name = "pharmacies")
@SequenceGenerator(name = "id_gen",allocationSize = 1)
public class Pharmacy  extends BaseEntity{
    @OneToMany(mappedBy = "pharmacy")
    private List<Worker> workers = new ArrayList<>();
    @OneToMany(mappedBy ="pharmacy")
    private List<Medicines> medicines = new ArrayList<>();
    private String name;
    private String address;

    public Pharmacy(String name, String address) {
        this.name = name;
        this.address = address;
    }

    public Pharmacy() {
        
    }
}
