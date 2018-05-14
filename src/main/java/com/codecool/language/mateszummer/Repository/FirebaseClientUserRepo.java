package com.codecool.language.mateszummer.Repository;

import com.codecool.language.mateszummer.model.FirebaseClientUser;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FirebaseClientUserRepo extends JpaRepository<FirebaseClientUser, Integer> {
}
