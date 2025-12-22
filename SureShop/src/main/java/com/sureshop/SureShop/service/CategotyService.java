package com.sureshop.SureShop.service;

import com.sureshop.SureShop.model.Category;

import java.util.List;
import java.util.Map;

public interface CategotyService {
    List<Category> getAllCategories();
    Map<String,Object> createCategory(String categoryName);
//    Map<String,Object> updateCategory(Long id,String categoryName);
    Map<String,Object> deleteCategory(Long id);



}
