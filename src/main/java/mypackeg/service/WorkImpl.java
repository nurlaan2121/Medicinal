package mypackeg.service;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import mypackeg.entities.Pharmacy;
import mypackeg.entities.Worker;
import mypackeg.repo.PharmacyRepo;
import mypackeg.repo.WorkRepo;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.Collections;
import java.util.List;

@RequiredArgsConstructor
@Service
public class WorkImpl implements WorkInterface {
    private final WorkRepo workRepo;
    private final PharmacyRepo pharmacyRepo;

    @Override
    public Worker save(Worker worker) {
        List<String> emails = workRepo.getAllEmails();
        if (!emails.contains(worker.getEmail())) {
            return workRepo.save(worker);
        }
        worker.setName("EMAIL NOT UNIQ");
        return worker;
    }

    @Override
    public String delete(Long id) {
        Worker worker = workRepo.findById(id).orElse(null);
        if (worker != null) {
            workRepo.deleteById(id);
            return "Success";
        }
        return "Not found";
    }

    @Override
    public List<Worker> getAll() {
        return workRepo.findAll();
    }

    @Override
    public Worker findById(Long id) {
        return workRepo.findById(id).orElse(null);
    }

    @Override
    public String update(Worker worker, Long id) {
        Worker worker1 = workRepo.findById(id).orElse(null);
        if (worker1 != null) {
            worker1.setAddress(worker.getAddress());
            worker1.setUpdateAd(worker.getUpdateAd());
            worker1.setName(worker.getName());
            worker1.setEmail(worker.getEmail());
            worker1.setDateOfBirth(worker.getDateOfBirth());
            worker1.setPharmacy(worker.getPharmacy());
            worker1.setCreatedAd(worker.getCreatedAd());
            worker1.setSalary(worker.getSalary());
            return "Success";
        }
        return "Not found";
    }

    @Override
    public List<Worker> sortBySalary(String ascOrDesc) {
        if (ascOrDesc.equalsIgnoreCase("asc")) {
            return workRepo.sortBySalary2();
        } else if (ascOrDesc.equalsIgnoreCase("desc")) {
            return workRepo.sortBySalary();
        }
        return Collections.emptyList();
    }

    @Override
    public Long getAvg() {
        return workRepo.getAvg();
    }

    @Override
    @Transactional
    public Worker save2(Worker worker, Long parId) {
        Pharmacy pharmacy = pharmacyRepo.findById(parId).orElse(null);
        if (pharmacy != null) {
            pharmacy.getWorkers().add(worker);
            worker.setPharmacy(pharmacy);
            workRepo.save(worker);
            return worker;
        }
        worker.setName("NOT FOUND PHARMACY");
        return worker;
    }
}
