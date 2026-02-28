package com.bootcamp.service;

import com.bootcamp.dao.CategoryDAO;
import com.bootcamp.model.Category;

import java.util.List;

public class CategoryService {
    private final CategoryDAO categoryDAO = new CategoryDAO();

    public List<Category> findAll() {
        return categoryDAO.findAll();
    }
}
