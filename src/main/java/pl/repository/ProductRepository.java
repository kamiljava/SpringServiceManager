package pl.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.model.Product;


@Repository
public interface ProductRepository extends JpaRepository<Product,Long> {

                 Product findFirstBySerial_number(String serial_number);
                //Product findProductBySerial_number(String serial_number);
               // List<Product> findBySerial_number(String serial_number);

}
