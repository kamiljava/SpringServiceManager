package pl.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import pl.model.Product;


@Repository
public interface ProductRepository extends JpaRepository<Product,Long> {

                @Query("select p from Product p where p.serial_number = ?1")
                Product findBySerial_number(String serial_number);

}
