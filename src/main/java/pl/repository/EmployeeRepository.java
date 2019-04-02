package pl.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.model.Employee;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee,Long> {

        Employee findByLogin(String login);
        Employee findByLoginAndPassword(String login,String password);
}
