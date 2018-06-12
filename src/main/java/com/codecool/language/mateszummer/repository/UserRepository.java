package com.codecool.language.mateszummer.repository;

import com.codecool.language.mateszummer.model.PubUser;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<PubUser, Integer> {
}
