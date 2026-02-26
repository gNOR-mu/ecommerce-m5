package com.bootcamp.service;

import com.bootcamp.dao.ProductDAO;
import com.bootcamp.dto.product.ProductInfoDTO;
import com.bootcamp.dto.product.ProductResumeDTO;
import com.bootcamp.model.Product;

import java.util.List;

public class ProductService {
    private final ProductDAO productDAO = new ProductDAO();

    public List<ProductResumeDTO> getTopProducts(){
        return productDAO.getTopProducts();
    }

    public List<ProductResumeDTO> findAllResume(){
        return productDAO.findAllResume();
    }

    public ProductInfoDTO findById(Long id) {
        return productDAO.findById(id);
    }
}
