package com.codecool.language.mateszummer.repository;

import com.codecool.language.mateszummer.model.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderRepository extends JpaRepository<Order,Long> {



}
