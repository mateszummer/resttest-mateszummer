package sums.smartbar.repository;

import org.springframework.data.repository.query.Param;
import sums.smartbar.DTO.ProductDTO;
import sums.smartbar.model.Product;
import sums.smartbar.model.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.QueryHints;

import javax.persistence.QueryHint;
import java.util.List;

public interface ProductRepository extends JpaRepository<Product, Integer>{



    @Query(value = "select new sums.smartbar.ProductDTO(pr.id, pr.price, pr.pubId, pr.caregoryId) from Product pr" +
            "where pr.id = :id")
    @QueryHints(value = {@QueryHint(name = "org.hibernate.cacheable", value = "true")})
    ProductDTO getProductById(@Param("id") Integer id);


    @Query(value = "select new sums.smartbar.ProductDTO(pr.id, pr.price, pr.pubId, pr.caregoryId) from Product pr" +
            "where pr.categoryId = :categoryId")
    @QueryHints(value = {@QueryHint(name = "org.hibernate.cacheable", value = "true")})
    List<ProductDTO> getAllByCategoryId(@Param("categoryId") Integer categoryId);
}
