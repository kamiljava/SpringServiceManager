package pl.model.dto;

import lombok.Data;

import javax.validation.constraints.NotNull;

@Data
public class ProductDto {

    @NotNull
    private String serial_number;
    @NotNull
    private String customer;
    @NotNull
    private String type;
    @NotNull
    private String model;
}
