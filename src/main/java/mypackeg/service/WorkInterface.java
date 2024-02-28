package mypackeg.service;

import mypackeg.entities.Medicines;
import mypackeg.entities.Worker;

import java.util.List;

public interface WorkInterface {
    Worker save(Worker worker);

    String delete(Long id);

    List<Worker> getAll();

    Worker findById(Long id);

    String update(Worker worker, Long id);

    List<Worker> sortBySalary(String ascOrDesc);

    Long getAvg();

    Worker save2(Worker worker, Long parId);

}
