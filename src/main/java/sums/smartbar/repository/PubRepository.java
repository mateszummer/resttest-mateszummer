package sums.smartbar.repository;

import sums.smartbar.model.Pub;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PubRepository extends JpaRepository<Pub, Integer> {
}
