package com.sprint3.admission_test.application.dto;

import jakarta.validation.constraints.*;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDate;

@Data
public class MedicationRequestDTO {
    @NotNull(message = "Campo no puede ser null")
    @Size(min = 5, max = 100, message = "Cantidad de caracteres erronea")
    private  String name;

    @NotNull(message = "Campo no puede ser null")
    @Size(min = 5, max = 100, message = "Cantidad de caracteres erronea")
    private  String description;


    @NotNull(message = "Campo no puede ser null")
    @DecimalMin(value = "0.0", message = "Cantidad de caracteres erronea")
    private BigDecimal price;


    @NotNull(message = "Expiration date is mandatory")
    @Future(message = "Expiration date must be in the future")
    private LocalDate expiration_date;


    @NotNull(message = "Category in null")
    @Size(min = 5, max = 100, message = "Cantidad de caracteres erronea")
    private String category_name;
}
