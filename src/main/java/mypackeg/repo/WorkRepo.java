package mypackeg.repo;

import mypackeg.entities.Worker;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public interface WorkRepo extends JpaRepository<Worker, Long> {
    @Query("select w from Worker w order by w.salary")
    List<Worker> sortBySalary2();

    @Query("select w from Worker w order by w.salary desc ")
    List<Worker> sortBySalary();


    @Query("SELECT AVG(YEAR(CURRENT_DATE) - YEAR(w.dateOfBirth)) FROM Worker w")
    Long getAvg();
    @Query("select w.email from Worker w")
    List<String> getAllEmails();
}
