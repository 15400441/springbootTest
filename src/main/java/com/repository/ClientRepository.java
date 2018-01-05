package com.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.bean.Client;

//@Repository(value="clientRepository")

public interface ClientRepository extends CrudRepository<Client, Long> {

}
