package mypackeg.api;

import lombok.RequiredArgsConstructor;
import mypackeg.entities.Medicines;
import mypackeg.service.MedicinesInterface;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/med/api")
public class MedicinesApi {
    private final MedicinesInterface medicinesInterface;

    @PostMapping("/save")
    public Medicines save(@RequestBody Medicines medicines) {
        if (medicines.getPrice().intValue() < 0) {
            medicines.setName("Errror price not 0");
            return medicines;
        }
        return medicinesInterface.save(medicines);
    }
    @PostMapping("/save/{idPar}")
    public Medicines save2(@RequestBody Medicines medicines,@PathVariable Long idPar){
        if (medicines.getPrice().intValue() < 0) {
            medicines.setName("Errror price not 0");
            return medicines;
        }
        return medicinesInterface.save2(medicines,idPar);
    }

    @DeleteMapping("/delete/{id}")
    public String delete(@PathVariable Long id) {
        return medicinesInterface.delete(id);
    }

    @GetMapping("/getAll")
    public List<Medicines> getAll() {
        return medicinesInterface.getAll();
    }

    @GetMapping("/findById/{id}")
    public Medicines findByID(@PathVariable Long id) {
        return medicinesInterface.findById(id);
    }

    @PutMapping("/updateById/{id})")
    public Medicines updateById(@RequestBody Medicines medicines, @PathVariable Long id) {
        medicinesInterface.update(medicines, id);
        return medicines;
    }

    @GetMapping("/sort/{param}")
    public List<Medicines> sortByName(@PathVariable Long param) {
        return medicinesInterface.sortBYName(param);
    }

    @GetMapping("/search")
    public List<Medicines> search(@RequestParam String key) {
        return medicinesInterface.search(key);
    }
}
