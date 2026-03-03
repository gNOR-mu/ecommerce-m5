package com.bootcamp.service;

import com.bootcamp.dao.CategoryDAO;
import com.bootcamp.model.Category;

import java.util.List;

/**
 * Servicio de categorías
 */
public class CategoryService {

    private final CategoryDAO categoryDAO = new CategoryDAO();

    /**
     * Obtiene todas las categorías
     * @return Listado con todas las categorías
     */
    public List<Category> findAll() {
        return categoryDAO.findAll();
    }
}
