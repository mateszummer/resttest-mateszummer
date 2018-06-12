package com.codecool.language.mateszummer.repository;

import com.codecool.language.mateszummer.model.PubTable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TableRepository extends JpaRepository<PubTable, Integer> {
}
