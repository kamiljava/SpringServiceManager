package pl.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.service.MainService;

@RestController
@RequestMapping
public class MainController {

    @Autowired
    MainService mainService;

   // @GetMapping("/")
   // public String home(){
   //     return "Service Manager";
   // }

}
