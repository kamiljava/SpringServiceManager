package pl.model;

import lombok.Data;
import org.hibernate.annotations.Type;

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


    @ManyToMany
    @JoinTable(name = "product_employee", joinColumns = @JoinColumn(name = "product_id"),
    inverseJoinColumns = @JoinColumn(name = "employee_id"))
    private Set <Employee> employees = new HashSet<>();

    @ManyToMany
    @JoinTable(name = "product_status",
            joinColumns = @JoinColumn(name ="product_id"),
            inverseJoinColumns = @JoinColumn(name = "repair_status_id"))
    private Set<RepairStatus> repairStatuses = new HashSet<>();


    public void addRepairStatus(RepairStatus repairStatus) {
        this.repairStatuses.add(repairStatus);
    }
}


