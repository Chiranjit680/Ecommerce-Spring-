package com.sureshop.SureShop;

import com.sureshop.SureShop.model.Category;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
@SpringBootTest
public class categoryTest {
    @Autowired
    private CategoryRepository categoryRepository;
    @Test
    public void testCategoryAll() {
        // Test logic for category creation
        List<Category> categoryList = categoryRepository.findAll();
        System.out.println(categoryList);

    }
    @Test
    public void testCategoryCreation() {
        // Test logic for category creation
        Category category = new Category();
        category.setCategoryName("Medicines");
        categoryRepository.save(category);
    }

}
