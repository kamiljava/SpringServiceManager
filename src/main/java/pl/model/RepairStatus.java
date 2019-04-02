package pl.model;


import lombok.Data;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;

@Data
@Entity
public class RepairStatus {

    @Id
    @GeneratedValue
    private Long id;
    @Enumerated
    private Status status;
    @NotNull
    @Type(type = "text")
    private String comment;
    private LocalDateTime status_update = LocalDateTime.now();


}