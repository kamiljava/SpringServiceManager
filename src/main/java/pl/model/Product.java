package pl.model;

import lombok.Data;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;


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
    @Type(type = "text")
    private String comment;

    private LocalDateTime registered_date = LocalDateTime.now();


    @ManyToMany(fetch = FetchType.EAGER)
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

    public Product() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getSerial_number() {
        return serial_number;
    }

    public void setSerial_number(String serial_number) {
        this.serial_number = serial_number;
    }

    public String getCustomer() {
        return customer;
    }

    public void setCustomer(String customer) {
        this.customer = customer;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public LocalDateTime getRegistered_date() {
        return registered_date;
    }

    public void setRegistered_date(LocalDateTime registered_date) {
        this.registered_date = registered_date;
    }

    public Set<Employee> getEmployees() {
        return employees;
    }

    public void setEmployees(Set<Employee> employees) {
        this.employees = employees;
    }

    public Set<RepairStatus> getRepairStatuses() {
        return repairStatuses;
    }

    public void setRepairStatuses(Set<RepairStatus> repairStatuses) {
        this.repairStatuses = repairStatuses;
    }

    public Product(@NotNull String serial_number, @NotNull String customer, @NotNull String type, @NotNull String model, String comment, LocalDateTime registered_date, Set<Employee> employees, Set<RepairStatus> repairStatuses) {
        this.serial_number = serial_number;
        this.customer = customer;
        this.type = type;
        this.model = model;
        this.comment = comment;
        this.registered_date = registered_date;
        this.employees = employees;
        this.repairStatuses = repairStatuses;
    }

}


