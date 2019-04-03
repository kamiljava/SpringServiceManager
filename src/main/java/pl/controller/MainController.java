package pl.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import pl.model.Employee;
import pl.service.EmployeeService;
import pl.service.MainService;

import java.util.List;

@Controller
public class MainController {

    MainService mainService;
    EmployeeService employeeService;

    @Autowired
    public MainController(EmployeeService employeeService, MainService mainService) {
        this.employeeService = employeeService;
        this.mainService = mainService;
    }

    @GetMapping("/employee/{login}")
    public Employee getEmployeeByLogin(@PathVariable("login") String login) {
        return mainService.getEmployeeByLogin(login);
    }

    @GetMapping("/employee")
    public List<Employee> getUsers(){
        return mainService.getAllEmployee();
    }
    @GetMapping("/")
    public String getLogin(Model model, Authentication auth) {
        model.addAttribute("auth", auth);
        if (auth != null) {
            model.addAttribute("login", employeeService.getEmployeeById(auth));
        }
        return "index";

    }


}
