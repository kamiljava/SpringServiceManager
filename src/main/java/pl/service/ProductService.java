package pl.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.model.Employee;
import pl.model.Product;
import pl.model.dto.ProductDto;
import pl.repository.EmployeeRepository;
import pl.repository.ProductRepository;
import pl.repository.RepairStatusRepository;

@Service
public class ProductService {

   ProductRepository productRepository;
   RepairStatusRepository repairStatusRepository;
   EmployeeRepository employeeRepository;

   @Autowired
    public ProductService(ProductRepository productRepository, RepairStatusRepository repairStatusRepository, EmployeeRepository employeeRepository) {
        this.productRepository = productRepository;
        this.repairStatusRepository = repairStatusRepository;
        this.employeeRepository = employeeRepository;
    }

    public Product addProduct(ProductDto productDto){
      //Employee employee = employeeRepository.findByLogin(login);
      Product product = new Product();
      product.setSerial_number(productDto.getSerial_number());
      product.setCustomer(productDto.getCustomer());
      product.setType(productDto.getType());
      product.setModel(productDto.getModel());
      //employee.getLogin();

      product.addRepairStatus(repairStatusRepository.getOne((long)1));
        System.out.println("mmmmmm"+product);
      Product product1 =  productRepository.save(product);
        System.out.println(product1);
      return product1;
    }
}
