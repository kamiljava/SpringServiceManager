package pl.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.model.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product,Long> {

       // Product findBySerial_number(String serial_number);

}
