package sums.smartbar.repository;

import sums.smartbar.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<Employee, Integer> {
}
