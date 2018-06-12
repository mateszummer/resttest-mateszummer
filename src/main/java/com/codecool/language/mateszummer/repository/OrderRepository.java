package com.codecool.language.mateszummer.repository;

import com.codecool.language.mateszummer.model.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order,Integer> {

}
