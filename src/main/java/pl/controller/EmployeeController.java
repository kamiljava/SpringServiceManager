package pl.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.model.dto.EmployeeDto;
import pl.service.EmployeeService;

import javax.validation.Valid;


@Controller
public class EmployeeController {

    EmployeeService employeeService;

    @Autowired
    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping("/register")
    public String register(Model model, Authentication auth){
        model.addAttribute("employee",new EmployeeDto());
        model.addAttribute("auth",auth);
        return "registerForm";
    }
    @PostMapping("/register")
    public String register(@ModelAttribute("employee") @Valid EmployeeDto employeeDto,
                           BindingResult bindingResult,
                           Model model,Authentication auth){
        if (bindingResult.hasErrors()){
            bindingResult.getRawFieldValue("login");
            model.addAttribute("auth",auth);

            return "registerForm";
        }
        employeeService.addEmployee(employeeDto);
        return "redirect:/";
    }

    @GetMapping("/login")
    public String login(Model model,Authentication auth){
        model.addAttribute("auth",auth);
        return "loginForm";
    }
}
