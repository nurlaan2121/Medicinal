package mypackeg.entities;

import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.query.SelectionQuery;

import java.time.ZonedDateTime;

@MappedSuperclass
@Data
public class BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "id_gen")
    private Long id;


    private ZonedDateTime createdAd;
    private ZonedDateTime updateAd;

    @PrePersist
    private void prePersist() {
        this.createdAd = ZonedDateTime.now();
    }

    @PreUpdate
    private void preUpdate() {
        this.updateAd = ZonedDateTime.now();
    }
}
