package mypackeg.service;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import mypackeg.entities.Medicines;
import mypackeg.entities.Pharmacy;
import mypackeg.repo.MedicinesRepo;
import mypackeg.repo.PharmacyRepo;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class MedicinesImpl implements MedicinesInterface {
    private final MedicinesRepo medicinesRepo;
    private final PharmacyRepo pharmacyRepo;
    @Override
    public Medicines save(Medicines medicines) {
        return medicinesRepo.save(medicines);
    }

    @Override
    public String delete(Long id) {
        Medicines medicines = medicinesRepo.findById(id).orElse(null);
        if (medicines != null) {
            medicinesRepo.deleteById(id);
            return "Success";
        } else return "Not found";
    }

    @Override
    public List<Medicines> getAll() {
        return medicinesRepo.findAll();
    }

    @Override
    public Medicines findById(Long id) {
        return medicinesRepo.findById(id).orElse(null);
    }

    @Override
    @Transactional
    public String update(Medicines medicines, Long id) {
        Medicines medicines1 = medicinesRepo.findById(id).orElse(null);
        if (medicines1 != null) {
            medicines1.setUpdateAd(medicines.getUpdateAd());
            medicines1.setName(medicines.getName());
            medicines1.setPrice(medicines.getPrice());
            medicines1.setCreatedAd(medicines.getCreatedAd());
            return "Success";
        }
        return "Not found";
    }

    @Override
    public List<Medicines> sortBYName(Long param) {
        if (param == 1) {
            return medicinesRepo.sortByName1(param);
        }
        return medicinesRepo.sortByName2(param);
    }

    @Override
    public List<Medicines> search(String key) {
        return medicinesRepo.search("%"+key+"%");
    }

    @Override @Transactional
    public Medicines save2(Medicines medicines, Long idPar) {
        Pharmacy pharmacy = pharmacyRepo.findById(idPar).orElse(null);
        if (pharmacy!=null){
            medicinesRepo.save(medicines);
            medicines.setPharmacy(pharmacy);
            pharmacy.getMedicines().add(medicines);
            return medicines;
        }
        medicines.setName("NOT FOUD PHAR");
        return medicines;
    }
}
