package mypackeg.repo;

import mypackeg.entities.Medicines;
import mypackeg.entities.Pharmacy;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface PharmacyRepo extends JpaRepository<Pharmacy, Long> {
    @Query("select m from Medicines m join Pharmacy p on m.pharmacy.id = p.id where p.id = :id")
    List<Medicines> getAllMeds(Long id);

    @Query("select p from Pharmacy p join Worker w on p.id = w.pharmacy.id where w.id = :workerId")
    Pharmacy getPharmacy(Long workerId);

    @Query("select p from Pharmacy p where p.name ilike (:s) or p.address ilike (:s)")
    List<Pharmacy> search(String s);
    @Query("select p,count (*) from Pharmacy p join Worker w on p.id = w.pharmacy.id group by p order by count (*)")
    Pharmacy getManyWorks();
}
