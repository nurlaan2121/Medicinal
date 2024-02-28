package mypackeg.api;

import lombok.RequiredArgsConstructor;
import mypackeg.entities.Medicines;
import mypackeg.entities.Worker;
import mypackeg.service.WorkInterface;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/work/api")
public class WorkerApi {
    private final WorkInterface workInterface;

    @PostMapping("/save")
    public Worker save(@RequestBody Worker worker) {
        return workInterface.save(worker);
    }
    @PostMapping("/save/{parId}")
    public Worker save2(@RequestBody Worker worker,@PathVariable Long parId) {
        return workInterface.save2(worker,parId);
    }

    @DeleteMapping("/delete/{id}")
    public String delete(@PathVariable Long id) {
        return workInterface.delete(id);
    }

    @GetMapping("/getAll")
    public List<Worker> getAll() {
        return workInterface.getAll();
    }

    @GetMapping("/findById/{id}")
    public Worker findByID(@PathVariable Long id) {
        return workInterface.findById(id);
    }

    @PutMapping("/updateById/{id})")
    public String updateById(@RequestBody Worker worker, @PathVariable Long id) {
        return workInterface.update(worker, id);
    }
    @GetMapping("/sortBySalary")
    public List<Worker> sortBySalary(@RequestParam String ascOrDesc){
        return workInterface.sortBySalary(ascOrDesc);
    }
    @GetMapping("/getAvgAge")
    public Long getAvg(){
        return workInterface.getAvg();
    }
}
