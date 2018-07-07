package sums.smartbar.service;

import org.springframework.stereotype.Component;

@Component
public class InitializerBean {

    public InitializerBean(CategoryService categoryService , ProductService productService) {
        categoryService.addCategory("shot");
        categoryService.addCategory("wine");
        categoryService.addCategory("beer");
        categoryService.addCategory("soft drink");
        productService.addProduct("Soproni",300,3,1);
        productService.addProduct("mineral water",200,4,1);
        productService.addProduct("Egri Bikavár",1200,2,1);
    }

}
