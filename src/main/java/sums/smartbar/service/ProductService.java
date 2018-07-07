package sums.smartbar.service;

import sums.smartbar.DTO.ProductDTO;
import sums.smartbar.model.Product;
import sums.smartbar.repository.ProductRepository;
import sums.smartbar.model.Category;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;

    public Product getDrinkById(Integer id) {
        return productRepository.getOne(id);
    }

    public List getAll() {
        return productRepository.findAll();
    }

    public void addProduct(String name, Integer price, Integer categoryId, Integer pubId) {
        productRepository.save(new Product(name, price, categoryId, pubId));
    }

    public ProductDTO getProductById(Integer id) {
        return productRepository.getProductById(id);
    }

    public void deleteProductById(Integer id) {
        productRepository.delete(id);
    }

//    public void deleteDrinkByName(String name) {
//        Product product = getDrinkByName(name);
//        //product.getCategory().removeDrinkFromCategory(product);
//        productRepository.delete(product);
//    }

    public List<ProductDTO> getAllByCategoryId(Integer categoryId) {
        return productRepository.getAllByCategoryId(categoryId);
    }
}
