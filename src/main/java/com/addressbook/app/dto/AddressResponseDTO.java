package com.addressbook.app.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AddressResponseDTO {
    //DTO special for Response design
    private Long id;
    private String fullName;
    private String address;
    private String city;
    private String state;
    private int zipCode;
    private long phoneNumber;
}