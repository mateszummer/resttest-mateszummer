package sums.smartbar.repository;

import sums.smartbar.model.PubTable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TableRepository extends JpaRepository<PubTable, Integer> {
}
