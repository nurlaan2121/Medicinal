package mypackeg.service;

import mypackeg.entities.Medicines;

import java.util.List;

public interface MedicinesInterface {
    Medicines save(Medicines medicines);

    String delete(Long id);

    List<Medicines> getAll();

    Medicines findById(Long id);

    String update(Medicines medicines, Long id);

    List<Medicines> sortBYName(Long param);

    List<Medicines> search(String key);

    Medicines save2(Medicines medicines, Long idPar);
}

