package pl.model;

import lombok.Data;
import lombok.Setter;
import org.hibernate.validator.constraints.Length;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import java.util.HashSet;
import java.util.Set;

@Data
@Entity
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @NotNull
    private String login;
    @Length(min = 6)
    //@Pattern(regexp = "([A-Z]+.*[0-9]+|[0-9]+.*[A-Z])")
    @NotNull
    private String password;
    private Boolean active = true;


    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "employee_role", joinColumns = @JoinColumn(name = "user_id"), inverseJoinColumns = @JoinColumn(name = "role_id"))
    private Set<Role> roles = new HashSet<>();

    public void addRole(Role role){
        this.roles.add(role);
    }


}



