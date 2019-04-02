package pl.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.model.Role;

@Repository
public interface RoleRepository extends JpaRepository<Role,Long> {

}
