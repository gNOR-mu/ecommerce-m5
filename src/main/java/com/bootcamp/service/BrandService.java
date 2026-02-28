package com.bootcamp.service;

import com.bootcamp.dao.BrandDAO;
import com.bootcamp.model.Brand;

import java.util.List;

public class BrandService {
    private final BrandDAO brandDAO = new BrandDAO();

    public List<Brand> findAll(){
        return brandDAO.findAll();
    }
}
