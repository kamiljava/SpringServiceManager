package pl.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import pl.model.RepairStatus;

@Repository
public interface RepairStatusRepository extends JpaRepository<RepairStatus,Long> {

            @Query("select r from RepairStatus r where r.status = ?1")
            RepairStatus findAllByStatus(String status);
}
