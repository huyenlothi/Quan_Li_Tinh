package com.quanli.repository;

import com.quanli.model.Customer;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IRepo extends PagingAndSortingRepository<Customer, Long> {

    Page<Customer> findAllByFirstNameContaining(String firstname, Pageable pageable);
}
