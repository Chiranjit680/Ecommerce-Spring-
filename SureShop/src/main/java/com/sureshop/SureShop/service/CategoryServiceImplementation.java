package com.sureshop.SureShop.service;

import com.sureshop.SureShop.CategoryRepository;
import com.sureshop.SureShop.model.Category;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
@Service
@RequiredArgsConstructor
public class CategoryServiceImplementation implements CategoryService {

    private final CategoryRepository categoryRepository;


    @Override
    public List<Category> getAllCategories(){
        return categoryRepository.findAll();
    }
    @Override
    public  Map<String,Object> createCategory(String categoryName) {
        Category category = new Category();
        category.setCategoryName(categoryName);
        categoryRepository.save(category);
        Map<String, Object> response = new HashMap<>();
        response.put("success", true);
        response.put("category", category);
        return response;
    }
    @Override
    public Map<String,Object> deleteCategory(Long id) {
         Category category = categoryRepository.findById(id).get();
        categoryRepository.delete(category);
        Map<String, Object> response = new HashMap<>();

        response.put("success", true);
        response.put("category", category);

        return response;
    }
    @Override
    public Map<String, Object> updateCategory(Long id, String categoryName) {
        Category category = categoryRepository.findById(id).orElseThrow(() ->
                new ResponseStatusException(HttpStatus.NOT_FOUND, "Category not found"));
        category.setCategoryName(categoryName);
        categoryRepository.save(category);
        Map<String, Object> response = new HashMap<>();
        response.put("success", true);
        response.put("category", category);

        return response;
    }
}
