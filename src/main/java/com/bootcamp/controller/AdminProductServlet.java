package com.bootcamp.controller;

import com.bootcamp.dto.product.AdminProductListDTO;
import com.bootcamp.model.Brand;
import com.bootcamp.model.Category;
import com.bootcamp.model.Product;
import com.bootcamp.service.BrandService;
import com.bootcamp.service.CategoryService;
import com.bootcamp.service.ProductService;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.util.List;

public class AdminProductServlet extends HttpServlet {
    private static final Logger logger = LoggerFactory.getLogger(AdminProductServlet.class);
    private ProductService productService;
    private BrandService brandService;
    private CategoryService categoryService;

    @Override
    public void init() throws ServletException {
        productService = new ProductService();
        brandService = new BrandService();
        categoryService = new CategoryService();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getParameter("action");

        switch (action) {
            case null -> list(req, resp);
            case "search" -> search(req, resp);
            case "create" -> create(req, resp);
            case "edit" -> edit(req, resp);
            default -> resp.sendError(HttpServletResponse.SC_BAD_REQUEST, "Acción inválida");
        }

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getParameter("action");
        String idParam = req.getParameter("id");

        if (action.equalsIgnoreCase("delete")) {
            try {
                Long id = Long.parseLong(idParam);
                productService.deleteById(id);

            } catch (Exception e) {
                logger.error("Error al intentar eliminar con una 'id' = '{}'", idParam, e);
            }
        }


        resp.sendRedirect(req.getContextPath() + "/admin/products");

    }

    private void search(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<AdminProductListDTO> products;
        String searchText = req.getParameter("searchText");
        products = productService.search(searchText);

        req.setAttribute("products", products);
        req.getRequestDispatcher("productList.jsp").forward(req, resp);
    }

    private void list(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<AdminProductListDTO> products;
        products = productService.findAll();
        req.setAttribute("products", products);
        req.getRequestDispatcher("productList.jsp").forward(req, resp);
    }

    private void create(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("productForm.jsp").forward(req, resp);
    }

    private void edit(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String idParam = req.getParameter("id");

        if (idParam == null || idParam.isBlank()) {
            resp.sendError(HttpServletResponse.SC_BAD_REQUEST, "Id inválida");
            return;
        }

        Product product = productService.findById(Long.parseLong(idParam));
        List<Brand> brands = brandService.findAll();
        List<Category> categories = categoryService.findAll();


        req.setAttribute("product", product);
        req.setAttribute("categories", categories);
        req.setAttribute("brands", brands);
        req.getRequestDispatcher("productForm.jsp").forward(req, resp);
    }

}
