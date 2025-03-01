package com.addressbook.app.services;

import com.addressbook.app.dto.AddressResponseDTO;
import com.addressbook.app.entity.AddressEntity;
import com.addressbook.app.repository.AddressRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class AddressService {
    @Autowired
    private AddressRepository addressRepository;

    private ModelMapper modelMapper = new ModelMapper();
    public List<AddressResponseDTO> getall(){
        List<AddressEntity> temp = addressRepository.findAll();
        List<AddressResponseDTO> ans = new ArrayList<>();
        for (AddressEntity t : temp) {
            ans.add(modelMapper.map(t,AddressResponseDTO.class));
        }
        return (ans);
    }

    public AddressResponseDTO addOne(AddressResponseDTO addressDTO){
        AddressEntity addd = modelMapper.map(addressDTO,AddressEntity.class);
        addressRepository.save(addd);
        System.out.println(addd);
        return (modelMapper.map(addd, AddressResponseDTO.class));
    }

    public AddressResponseDTO updateOne(Long id , AddressResponseDTO addressResponseDTO){
        Optional<AddressEntity> existingEmployeeOpt = addressRepository.findById(id);
        if (existingEmployeeOpt.isPresent()) {
            AddressEntity existingEmployee = existingEmployeeOpt.get();
            modelMapper.typeMap(AddressResponseDTO.class, AddressEntity.class)
                    .addMappings(mapper -> mapper.skip(AddressEntity::setId)); // Skip ID mapping
            modelMapper.map(addressResponseDTO, existingEmployee); // Map changes onto existing entity
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