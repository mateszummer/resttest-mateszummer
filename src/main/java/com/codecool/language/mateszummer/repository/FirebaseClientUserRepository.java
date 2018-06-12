package com.codecool.language.mateszummer.repository;

import com.codecool.language.mateszummer.model.FirebaseClientUser;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FirebaseClientUserRepository extends JpaRepository<FirebaseClientUser, Integer> {
}
