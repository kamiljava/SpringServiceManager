package pl.model;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

@Data
@Entity
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @NotNull
    private String serial_number;
    @NotNull
    private String customer;
    @NotNull
    private String type;
    @NotNull
    private String model;
    private LocalDateTime registered_date = LocalDateTime.now();


  // @OneToMany(cascade = CascadeType.ALL,fetch = FetchType.EAGER, mappedBy = "product")
  // private Set<Employee> employees = new HashSet<>();



}


