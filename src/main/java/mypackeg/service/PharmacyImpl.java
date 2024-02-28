package mypackeg.service;

import lombok.RequiredArgsConstructor;
import mypackeg.entities.Medicines;
import mypackeg.entities.Pharmacy;
import mypackeg.repo.PharmacyRepo;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PharmacyImpl implements PharmacyInterface{
    private final PharmacyRepo pharmacyRepo;
    @Override
    public Pharmacy save(Pharmacy pharmacy) {
        return pharmacyRepo.save(pharmacy);
    }

    @Override
    public List<Pharmacy> getAll() {
        return pharmacyRepo.findAll();
    }
    @Override
    public String delete(Long id) {
        Pharmacy pharmacy = pharmacyRepo.findById(id).orElse(null);
        if (pharmacy != null) {
            pharmacyRepo.deleteById(id);
            return "Success";
        } else return "Not found";
    }

    @Override
    public Pharmacy findById(Long id) {
        return pharmacyRepo.findById(id).orElse(null);
    }

    @Override
    public void update(Pharmacy pharmacy, Long id) {
        Pharmacy pharmacy1 = pharmacyRepo.findById(id).orElse(null);
        if (pharmacy1!=null) {
            pharmacy1.setUpdateAd(pharmacy.getUpdateAd());
            pharmacy1.setName(pharmacy.getName());
            pharmacy1.setAddress(pharmacy.getAddress());
            pharmacy1.setName(pharmacy.getName());
            pharmacy1.setWorkers(pharmacy.getWorkers());
            pharmacy1.setMedicines(pharmacy.getMedicines());
            pharmacy1.setCreatedAd(pharmacy.getCreatedAd());
        }
    }

    @Override
    public List<Medicines> getAllMeds(Long id) {
        return pharmacyRepo.getAllMeds(id);
    }

    @Override
    public Pharmacy getPharmacy(Long workerId) {
        return pharmacyRepo.getPharmacy(workerId);
    }

    @Override
    public List<Pharmacy> search(String key) {
        return pharmacyRepo.search("%"+key+"%");
    }

    @Override
    public Pharmacy getManyWorks() {
        return pharmacyRepo.getManyWorks();
    }

}
