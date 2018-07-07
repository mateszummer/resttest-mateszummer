package sums.smartbar.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import sums.smartbar.DTO.CategoryDTO;
import sums.smartbar.model.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.QueryHints;

import javax.persistence.QueryHint;
import java.util.List;

public interface CategoryRepository extends JpaRepository<Category, Integer> {

    @Query(value = "select new sums.smartbar.CategoryDTO(cat.id, cat.name, cat.pubId) from Category cat " +
            "where cat.id = :id")
    @QueryHints(value = {@QueryHint(name = "org.hibernate.cacheable", value = "true")})
    CategoryDTO getOneByCategoryId(@Param("id") Integer id);

    @Query(value = "select new sums.smartbar.CategoryDTO(cat.id, cat.name, cat.pubId) from Category cat")
    @QueryHints(value = {@QueryHint(name = "org.hibernate.cacheable", value = "true")})
    List<CategoryDTO> getAll();
}