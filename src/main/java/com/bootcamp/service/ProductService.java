package com.bootcamp.service;

import com.bootcamp.dao.BrandDAO;
import com.bootcamp.dao.CategoryDAO;
import com.bootcamp.dao.ProductDAO;
import com.bootcamp.dto.product.AdminProductListDTO;
import com.bootcamp.dto.product.ProductFormDTO;
import com.bootcamp.dto.product.ProductInfoDTO;
import com.bootcamp.dto.product.ProductResumeDTO;
import com.bootcamp.model.Product;

import java.math.BigDecimal;
import java.util.List;

public class ProductService {
    private final ProductDAO productDAO = new ProductDAO();
    private final CategoryDAO categoryDAO = new CategoryDAO();
    private final BrandDAO brandDAO = new BrandDAO();

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
        validateFields(product);
        productDAO.save(product);
    }

    public void edit(ProductFormDTO product) {
        validateFields(product);
        productDAO.edit(product);
    }

    private void validateFields(ProductFormDTO product) {
        if (product.getName() == null || product.getName().isBlank()) {
            throw new IllegalArgumentException("El nombre del producto no puede ser vacío ni estar en blanco");
        }

        if (product.getPrice() == null || product.getPrice().compareTo(BigDecimal.ZERO) <= 0) {
            throw new IllegalArgumentException("El precio debe ser mayor a 0");
        }

        if (product.getStock() < 0) {
            throw new IllegalArgumentException("El stock no puede ser negativo");
        }

        if (product.getCategoryId() == null || !categoryDAO.existsById(product.getCategoryId())) {
            throw new IllegalArgumentException("La ID de categoría no existe");
        }

        if (product.getBrandId() == null || !brandDAO.existsById(product.getBrandId())) {
            throw new IllegalArgumentException("La ID de marca no existe");
        }
    }
}
