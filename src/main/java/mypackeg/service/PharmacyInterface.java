package mypackeg.service;

import mypackeg.entities.Medicines;
import mypackeg.entities.Pharmacy;

import java.util.List;

public interface PharmacyInterface {
    Pharmacy save(Pharmacy pharmacy);

    List<Pharmacy> getAll();

    String delete(Long id);

    Pharmacy findById(Long id);

    void update(Pharmacy pharmacy, Long id);

    List<Medicines> getAllMeds(Long id);

    Pharmacy getPharmacy(Long workerId);

    List<Pharmacy> search(String key);

    Pharmacy getManyWorks();

}
