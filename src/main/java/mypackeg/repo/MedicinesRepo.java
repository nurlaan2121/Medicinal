package mypackeg.repo;

import mypackeg.entities.Medicines;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface MedicinesRepo extends JpaRepository<Medicines,Long> {
    @Query("select m from Medicines m order by m.name")
    List<Medicines> sortByName1(Long param);

    @Query("select m from Medicines m order by m.name desc")
    List<Medicines> sortByName2(Long param);
    @Query("select m from Medicines m  where m.name ilike (:key)")
    List<Medicines> search(String key);
}
