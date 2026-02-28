package com.bootcamp.service;

import com.bootcamp.dao.ProductDAO;
import com.bootcamp.dto.product.AdminProductListDTO;
import com.bootcamp.dto.product.ProductFormDTO;
import com.bootcamp.dto.product.ProductInfoDTO;
import com.bootcamp.dto.product.ProductResumeDTO;
import com.bootcamp.model.Product;

import java.util.List;

public class ProductService {
    private final ProductDAO productDAO = new ProductDAO();

    public List<ProductResumeDTO> getTopProducts() {
        return productDAO.getTopProducts();
    }

    public List<ProductResumeDTO> findAllResume() {
        return productDAO.findAllResume();
    }

    public List<AdminProductListDTO> findAll() {
        return productDAO.findAll();
    }

    public ProductInfoDTO findInfoById(Long id) {
        return productDAO.findInfoById(id);
    }

    public Product findById(Long id){
        return productDAO.findById(id);
    }

    public void deleteById(Long id) {
        productDAO.deleteById(id);
    }

    public List<AdminProductListDTO> search(String searchText) {
        return productDAO.search(searchText);
    }

    public void create(ProductFormDTO product) {
        productDAO.save(product);
    }

    public void edit(ProductFormDTO product) {
        productDAO.edit(product);
    }
}
