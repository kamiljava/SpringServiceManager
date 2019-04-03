package pl.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.model.RepairStatus;

@Repository
public interface RepairStatusRepository extends JpaRepository<RepairStatus,Long> {


}
