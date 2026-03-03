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

/**
 * Servicio de productos
 */
public class ProductService {
    private final ProductDAO productDAO = new ProductDAO();
    private final CategoryDAO categoryDAO = new CategoryDAO();
    private final BrandDAO brandDAO = new BrandDAO();

    /**
     * Obtiene los productos más vendidos
     * @return Una lista con los productos más vendidos
     */
    public List<ProductResumeDTO> getTopProducts() {
        return productDAO.getTopProducts();
    }

    /**
     * Obtiene un resumen de todos los productos
     * @return Una lista con el resumen de todos los productos
     */
    public List<ProductResumeDTO> findAllResume() {
        return productDAO.findAllResume();
    }

    /**
     * Busca todos los productos como administrador
     * @return Una lista de todos los productos
     */
    public List<AdminProductListDTO> findAll() {
        return productDAO.findAll();
    }

    /**
     * Busca la información de un producto por ID
     * @param id ID del producto
     * @return Información del producto
     */
    public ProductInfoDTO findInfoById(Long id) {
        return productDAO.findInfoById(id);
    }

    /**
     * Busca un producto por ID
     * @param id ID del producto
     * @return Producto con la id coincidente
     */
    public Product findById(Long id){
        return productDAO.findById(id);
    }

    /**
     * Elimina un producto
     * @param id ID del producto
     */
    public void deleteById(Long id) {
        productDAO.deleteById(id);
    }

    /**
     * Busca productos
     * @param searchText Texto a buscar
     * @return Listado con los productos coincidentes
     */
    public List<AdminProductListDTO> search(String searchText) {
        return productDAO.search(searchText);
    }

    /**
     * Crea un nuevo producto
     * @param product Producto a crear
     */
    public void create(ProductFormDTO product) {
        validateFields(product);
        productDAO.save(product);
    }

    /**
     * Edita un producto
     * @param product Producto a editar
     */
    public void edit(ProductFormDTO product) {
        validateFields(product);
        productDAO.edit(product);
    }

    /**
     * Valida los campos de un producto
     * @param product Producto a validar
     */
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
