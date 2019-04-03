package pl.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.model.Employee;
import pl.repository.EmployeeRepository;

import java.util.List;

@Service
public class MainService {

    EmployeeRepository employeeRepository;

    @Autowired
    public MainService(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    public Employee loginEmployee(String login,String password){
        return employeeRepository.findByLoginAndPassword(login,password);
    }
    public List<Employee> getAllEmployee(){
        return employeeRepository.findAll();
    }

    public Employee getEmployeeByLogin(String login){
        return employeeRepository.findByLogin(login);
    }

}
