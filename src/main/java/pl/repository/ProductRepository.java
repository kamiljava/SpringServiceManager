package pl.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import pl.model.Product;

import java.util.List;


@Repository
public interface ProductRepository extends JpaRepository<Product,Long> {

                @Query("select p from Product p where p.serial_number = ?1")
                Product findBySerial_number(String serial_number);

//                List<Product> findAllBySerial_numberLikeOrModelLikeOrTypeLikeOrCustomerLikeOOrRepairStatusesLike
//                        (String serial_number,String model,String type,String customer,String status_repair);

}
