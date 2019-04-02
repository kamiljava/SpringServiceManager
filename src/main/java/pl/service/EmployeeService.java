package pl.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import pl.model.Employee;
import pl.model.Role;
import pl.model.dto.EmployeeDto;
import pl.repository.EmployeeRepository;
import pl.repository.RoleRepository;

@Service
public class EmployeeService {

    EmployeeRepository employeeRepository;
    RoleRepository roleRepository;

    @Autowired
    public EmployeeService(EmployeeRepository employeeRepository, RoleRepository roleRepository) {
        this.employeeRepository = employeeRepository;
        this.roleRepository = roleRepository;
    }

    public Employee addEmployee(EmployeeDto employeeDto){
        Employee employee = new Employee();
        employee.setLogin(employeeDto.getLogin());
        employee.setPassword(employeeDto.getPassword());

        String encodedPassword = new BCryptPasswordEncoder().encode(employeeDto.getPassword());
        employee.setPassword(encodedPassword);

        employee.addRole(roleRepository.getOne((long)3));
        return employeeRepository.save(employee);
    }
}
