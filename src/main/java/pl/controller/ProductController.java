package pl.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import pl.model.Status;
import pl.model.dto.EmployeeDto;
import pl.model.dto.ProductDto;
import pl.service.ProductService;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Controller
public class ProductController {


    ProductService productService;

    @Autowired
    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping("/productregister")
    public String productRegister(Model model, Authentication auth){
        List<Status> statusEnum = new ArrayList<>(Arrays.asList(Status.values()));
        model.addAttribute("product", new ProductDto());
        model.addAttribute("auth", auth);
        model.addAttribute("status",statusEnum);
        return "productRegisterForm";
    }
    @PostMapping("/productregister")
    public String productRegister(@ModelAttribute ("product") @Valid ProductDto productDto,
                                  BindingResult bindingResult,
                                Model model, Authentication auth){
                            if (bindingResult.hasErrors()){
                                bindingResult.getRawFieldValue("register");
                                model.addAttribute("auth",auth);
                                return "productRegisterForm";
                            }
                            productService.addProduct(productDto);
                            return "redirect:/";
    }

}
