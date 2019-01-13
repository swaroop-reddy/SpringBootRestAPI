package com.swaroop.SpringBootRestAPI.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.swaroop.SpringBootRestAPI.model.Address;

@Repository
public interface AddressRepository extends CrudRepository<Address, Long> {

}
