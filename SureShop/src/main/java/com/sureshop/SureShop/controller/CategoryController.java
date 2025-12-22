package com.sureshop.SureShop.controller;
import com.sureshop.SureShop.model.Category;
import com.sureshop.SureShop.service.CategotyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class CategoryController {
    @Autowired
    private CategotyService categotyService;


    @GetMapping("/api/public/categories")
    public List<Category> getCategories(){
        return categotyService.getAllCategories();
    }
    @PostMapping("/api/admin/create/category")
    public Map<String,Object> createCategory(@RequestBody String categoryName){
        return categotyService.createCategory(categoryName);
    }
    @DeleteMapping("/api/admin/delete/category/{id}")
    public Map<String,Object> deleteCategory(@PathVariable Long id){
        return categotyService.deleteCategory(id);
    }
}
