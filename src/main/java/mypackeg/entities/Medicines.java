package mypackeg.entities;

import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.ManyToAny;
import org.springframework.aop.target.LazyInitTargetSource;

import java.math.BigDecimal;
import java.nio.file.LinkOption;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@Table(name = "Medicineses")
@SequenceGenerator(name = "id_gen",allocationSize = 1)
public class Medicines extends BaseEntity {
    @ManyToOne
    private Pharmacy pharmacy;
    private String name;
    private BigDecimal price;
}
