package com.addressbook.app.dto;


import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AddressRequestDTO {
    //DTO special for Request design
    @NotNull(message = "ID CAN't be NULL")
    private Long id;
}