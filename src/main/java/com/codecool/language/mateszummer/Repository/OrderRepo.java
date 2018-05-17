package com.codecool.language.mateszummer.Repository;

import com.codecool.language.mateszummer.model.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepo extends JpaRepository<Order,Integer> {

}
