package com.addressbook.app.repository;

import com.addressbook.app.entity.AddressEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

@Repository
@EnableJpaRepositories
public interface AddressRepository extends JpaRepository<AddressEntity,Long> {
}