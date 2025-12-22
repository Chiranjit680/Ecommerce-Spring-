package com.sureshop.SureShop.service;

import com.sureshop.SureShop.model.Category;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
@Service
public class CategoryServiceImplementation implements CategotyService{
    private Long numberOfCategories=0L;
    private List<Category> categories = new ArrayList<>();

    @Override
    public List<Category> getAllCategories(){
        return categories;
    }
    @Override
    public Map<String,Object> createCategory(String categoryName) {
        Category category = new Category();
        category.setCategoryId(++numberOfCategories);
        category.setCategoryName(categoryName);
        categories.add(category);
        Map<String, Object> response = new HashMap<>();
        response.put("success", true);
        response.put("category", category);

        return response;
    }
    @Override
    public Map<String,Object> deleteCategory(Long id) {
         Category category=null;
         for(Category c : categories){
             if(c.getCategoryId().equals(id)){
                 category = c;
                 categories.remove(c);
                 break;


             }
         }
        Map<String, Object> response = new HashMap<>();
         if(category!=null) {
             response.put("success", true);
             response.put("category", category);

         }
         else{
             response.put("success", false);
             response.put("category", null);

         }
        return response;
    }
}
