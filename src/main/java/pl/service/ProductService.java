package pl.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.model.Product;
import pl.model.dto.ProductDto;
import pl.repository.ProductRepository;
import pl.repository.RepairStatusRepository;

@Service
public class ProductService {

   ProductRepository productRepository;
   RepairStatusRepository repairStatusRepository;

   @Autowired
    public ProductService(ProductRepository productRepository, RepairStatusRepository repairStatusRepository) {
        this.productRepository = productRepository;
        this.repairStatusRepository = repairStatusRepository;
    }

    public Product addProduct(ProductDto productDto){
      Product product = new Product();
      product.setSerial_number(productDto.getSerial_number());
      product.setCustomer(productDto.getCustomer());
      product.setType(productDto.getType());
      product.setModel(productDto.getModel());



      //product.addRepairStatus(repairStatusRepository.getOne((long)1));
      return productRepository.save(product);
    }
}
