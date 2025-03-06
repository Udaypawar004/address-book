package com.addressbook.app.services;

import com.addressbook.app.dto.AddressResponseDTO;
import com.addressbook.app.entity.AddressEntity;
import com.addressbook.app.repository.AddressRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class AddressService {
    @Autowired
    private AddressRepository addressRepository;

    private final ModelMapper modelMapper = new ModelMapper();
    public List<AddressResponseDTO> getall(){
        List<AddressEntity> temp = addressRepository.findAll();
        List<AddressResponseDTO> ans = new ArrayList<>();
        for (AddressEntity t : temp) {
            ans.add(modelMapper.map(t,AddressResponseDTO.class));
        }
        return (ans);
    }

    public AddressResponseDTO addOne(AddressResponseDTO addressDTO){
        AddressEntity add = modelMapper.map(addressDTO,AddressEntity.class);
        addressRepository.save(add);
        return (modelMapper.map(add, AddressResponseDTO.class));
    }

    public AddressResponseDTO updateOne(Long id , AddressResponseDTO addressResponseDTO){
        Optional<AddressEntity> existingEmployeeOpt = addressRepository.findById(id);
        if (existingEmployeeOpt.isPresent()) {
            AddressEntity existingEmployee = existingEmployeeOpt.get();

            // Loop through all fields in AddressResponseDTO
            for (Field field : AddressResponseDTO.class.getDeclaredFields()) {
                field.setAccessible(true); // Allow access to private fields
                try {
                    Object newValue = field.get(addressResponseDTO); // Get value from DTO
                    if (newValue != null) { // Only update non-null fields
                        Field entityField = AddressEntity.class.getDeclaredField(field.getName());
                        entityField.setAccessible(true);
                        entityField.set(existingEmployee, newValue);
                    }
                } catch (NoSuchFieldException | IllegalAccessException e) {
                    e.printStackTrace(); // Handle exceptions properly in real projects
                }
            }

            // Save updated entity
            AddressEntity updatedEmployee = addressRepository.save(existingEmployee);
            return modelMapper.map(updatedEmployee, AddressResponseDTO.class);
        }
        return new AddressResponseDTO();
    }

    public Boolean deleteOne(Long id){
        addressRepository.deleteById(id);
        return (true);
    }
}