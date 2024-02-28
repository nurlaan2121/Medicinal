package mypackeg.api;

import lombok.RequiredArgsConstructor;
import mypackeg.entities.Medicines;
import mypackeg.entities.Pharmacy;
import mypackeg.service.PharmacyInterface;
import org.apache.catalina.LifecycleState;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/par/api")
public class PharmacyApi {
    private final PharmacyInterface pharmacyInterface;

    @PostMapping("/save")
    public Pharmacy save(@RequestBody Pharmacy pharmacy) {
        return pharmacyInterface.save(pharmacy);
    }

    @GetMapping("/getAll")
    public List<Pharmacy> getAll() {
        return pharmacyInterface.getAll();
    }

    @DeleteMapping("/delete/{id}")
    public String delete(@PathVariable Long id) {
        return pharmacyInterface.delete(id);
    }

    @GetMapping("/findById/{id}")
    public Pharmacy findByID(@PathVariable Long id) {
        return pharmacyInterface.findById(id);
    }

    @PutMapping("/updateById/{id})")
    public Pharmacy updateById(@RequestBody Pharmacy pharmacy, @PathVariable Long id) {
        pharmacyInterface.update(pharmacy, id);
        return pharmacy;
    }

    @GetMapping("/getAllMeds/{id}")
    public List<Medicines> getAllMeds(@PathVariable Long id) {
        return pharmacyInterface.getAllMeds(id);
    }
    @GetMapping("/getPharContainsWorker/{workerId}")
    public Pharmacy getPharmacy(@PathVariable Long workerId){
        return pharmacyInterface.getPharmacy(workerId);
    }
    @GetMapping("/search")
    public List<Pharmacy> search(@RequestParam String key) {
        return pharmacyInterface.search(key);
    }
    @GetMapping("/getveryBigWorks")
    public Pharmacy getMany(){
        return pharmacyInterface.getManyWorks();
    }

}
