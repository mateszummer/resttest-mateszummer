package com.codecool.language.mateszummer.repository;

import com.codecool.language.mateszummer.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Integer> {
}
