package pl.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.model.Employee;
import pl.model.Product;
import pl.model.RepairStatus;
import pl.model.dto.EmployeeDto;
import pl.model.dto.ProductDto;
import pl.repository.EmployeeRepository;
import pl.repository.ProductRepository;
import pl.repository.RepairStatusRepository;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

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
      Product product = new Product();
      product.setSerial_number(productDto.getSerial_number());
      product.setCustomer(productDto.getCustomer());
      product.setType(productDto.getType());
      product.setModel(productDto.getModel());

      product.addRepairStatus(repairStatusRepository.getOne((long)1));

      Product productSave =  productRepository.save(product);
      return productSave;
    }

    public List<Product> getAllProduct(){
       return productRepository.findAll()
               .stream()
               .sorted(Comparator.comparing(Product::getRegistered_date).reversed())
               .collect(Collectors.toList());
    }
    public List<RepairStatus> getAllStatus(){
        return repairStatusRepository.findAll();
    }

    public String getCurrentStatus(){

       List<RepairStatus> repairStatuses = getAllStatus();
               return repairStatuses.get(repairStatuses.size()-1).getStatus();
    }



//        public Product diagnosticProduct(Product product, String serial_number){
//        Product statusUpdate = productRepository.findBySerial_number(serial_number);
//        statusUpdate.setRepairStatuses(product.getRepairStatuses());
//        statusUpdate.setComment(statusUpdate.getComment());
//        statusUpdate.addRepairStatus(repairStatusRepository.getOne((long)2));
//        return productRepository.save(statusUpdate);
//    }
//    public Product getProductBySerialNumber(String serial_number){
//       return productRepository.findBySerial_number(serial_number);
//    }
}
