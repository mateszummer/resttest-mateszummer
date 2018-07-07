package sums.smartbar.service;


import sums.smartbar.DTO.CategoryDTO;
import sums.smartbar.repository.CategoryRepository;
import sums.smartbar.repository.ProductRepository;
import sums.smartbar.model.Category;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class CategoryService {

    @Autowired
    private CategoryRepository categoryRepo;

    @Autowired
    private ProductRepository productRepository;

    @Transactional
    public CategoryDTO getCategoryById(Integer id) {

        return categoryRepo.getOneByCategoryId(id);
    }

    @Transactional
    public void addCategory(String name) {

        categoryRepo.save(new Category(name));
    }

    @Transactional
    public void deleteCategoryById(Integer id) {
        //productRepository.delete(category.getDrinkList());
        categoryRepo.delete(id);

    }

    @Transactional
    public List<CategoryDTO> getAllDTO() {
        return categoryRepo.getAll();
    }

}
