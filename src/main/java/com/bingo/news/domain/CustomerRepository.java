package com.bingo.news.domain;

import org.springframework.data.jpa.repository.JpaRepository;


public interface CustomerRepository extends JpaRepository<Customer, Long> {
    @Override
    Customer getOne(Long aLong);

    Customer findByName(String userName);
}
