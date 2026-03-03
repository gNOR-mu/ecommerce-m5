package com.bootcamp.service;

import com.bootcamp.dao.BrandDAO;
import com.bootcamp.model.Brand;

import java.util.List;

/**
 * Servicio de marcas
 */
public class BrandService {
    private final BrandDAO brandDAO = new BrandDAO();

    /**
     * Obtiene todas las marcas
     * @return Listado con todas las marcas
     */
    public List<Brand> findAll(){
        return brandDAO.findAll();
    }
}
