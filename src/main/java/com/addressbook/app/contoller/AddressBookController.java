package com.addressbook.app.contoller;

import com.addressbook.app.dto.AddressRequestDTO;
import com.addressbook.app.dto.AddressResponseDTO;
import com.addressbook.app.services.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class AddressBookController {

    @Autowired
    AddressService addressService;

    @GetMapping(value = "/getAddresses" ,produces = "application/json")
    public ResponseEntity<List<AddressResponseDTO>> getAll(){
        return ResponseEntity.ok(addressService.getall());
    }
    @PostMapping(value = "/createAddress",produces = "application/json")
    public ResponseEntity<AddressResponseDTO> createAddress(@RequestBody AddressResponseDTO address){
        return ResponseEntity.ok(addressService.addOne(address));
    }
    @PutMapping(value = "/updateAddress",produces = "application/json")
    public ResponseEntity<AddressResponseDTO> updateAddress(@RequestBody AddressResponseDTO addressResponseDTO){
        return ResponseEntity.ok(addressService.updateOne(addressResponseDTO.getId(),addressResponseDTO));
    }
    @DeleteMapping(value = "/deleteAddress",produces = "application/json")
    public ResponseEntity<Boolean> deleteAddress(@RequestBody AddressRequestDTO id){
        return ResponseEntity.ok(addressService.deleteOne(id.getId()));
    }
}