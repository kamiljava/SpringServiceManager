package pl.model;


import lombok.Data;

import javax.persistence.*;

@Data
@Entity
public class RepairStatus {

    @Id
    @GeneratedValue
    private Long id;
    private String status;
}

