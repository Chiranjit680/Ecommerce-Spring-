package com.sureshop.SureShop.controller;
import com.sureshop.SureShop.model.Category;
import com.sureshop.SureShop.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api")
public class CategoryController {
    @Autowired
    private CategoryService categoryService;


    @GetMapping("/public/categories")
    ResponseEntity<List<Category>>getCategories(){
        try {
            return ResponseEntity.status(HttpStatus.OK).body(categoryService.getAllCategories());
        }
        catch (Exception e){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
    }
    @PostMapping("/admin/create/category")
    public ResponseEntity<Map<String,Object>> createCategory(@RequestBody String categoryName){
        try{
            return ResponseEntity.status(HttpStatus.CREATED).body(categoryService.createCategory(categoryName));
        } catch (Exception e) {
            Map<String, Object> response = new HashMap<>();
            response.put("success", false);
            response.put("message", e.getMessage());
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(response);
        }
    }

//    @PutMapping("/api/admin/update/category/{id}")
    @RequestMapping(value = "/admin/update/category/{id}", method=RequestMethod.PUT)
    public ResponseEntity<Map<String,Object>> updateCategory(@PathVariable Long id, @RequestBody String categoryName){
       try{
           return ResponseEntity.status(HttpStatus.CREATED).body(categoryService.updateCategory(id, categoryName));
       }
       catch (Exception e) {
           Map<String, Object> response = new HashMap<>();
           response.put("success", false);
           response.put("message", e.getMessage());
           return ResponseEntity.status(HttpStatus.NOT_FOUND).body(response);
       }
    }
    @DeleteMapping("/admin/delete/category/{id}")
    public ResponseEntity<Map<String, Object>> deleteCategory(@PathVariable Long id) {
        try {
            return ResponseEntity.status(HttpStatus.CREATED).body(categoryService.deleteCategory(id));
        } catch (Exception e) {
            Map<String, Object> response = new HashMap<>();
            response.put("success", false);
            response.put("message", e.getMessage());
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(response);
        }
    }

}
