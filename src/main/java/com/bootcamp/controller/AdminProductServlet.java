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
import java.math.BigDecimal;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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

        switch (action) {
            case "delete" -> {
                String idParam = req.getParameter("id");
                try {
                    Long id = Long.parseLong(idParam);
                    productService.deleteById(id);

                } catch (Exception e) {
                    logger.error("Error al intentar eliminar con una 'id' = '{}'", idParam, e);
                }
            }
            case "save" -> {
                try {
                    String idParam = req.getParameter("id");
                    Product product = new Product();

                    product.setCategoryId(Long.parseLong(req.getParameter("categoryId")));
                    product.setBrandId(Long.parseLong(req.getParameter("brandId")));
                    product.setPrice(new BigDecimal(req.getParameter("price")));
                    product.setName(req.getParameter("name"));
                    product.setUrlImage(req.getParameter("urlImage"));
                    product.setDescription(req.getParameter("description"));
                    product.setShortDescription(req.getParameter("shortDescription"));

                    if(idParam != null && !idParam.isEmpty()){
                        product.setId(Long.parseLong(idParam));
                    }

                    var features = product.getFeatures();

                    String[] keys = req.getParameterValues("featureKeys");
                    String[] values = req.getParameterValues("featureValues");

                    if (keys != null && values != null) {
                        for (int i = 0; i < keys.length; i++) {
                            features.put(keys[i], values[i]);
                        }
                    }

                    if(product.getId() == null){
                        productService.create(product);
                    }else{
                        productService.edit(product);
                    }
                } catch (Exception e) {
                    logger.error("Error (create):", e);
                }

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
        req.setAttribute("categories", categoryService.findAll());
        req.setAttribute("brands", brandService.findAll());

        req.getRequestDispatcher("productForm.jsp").forward(req, resp);
    }

    private void edit(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String idParam = req.getParameter("id");

        if (idParam == null || idParam.isBlank()) {
            logger.info("INFO (edit): Acceso a editar con una id inválida '{}'", idParam);
            resp.sendError(HttpServletResponse.SC_BAD_REQUEST, "Id inválida");
            return;
        }

        try {
            Product product = productService.findById(Long.parseLong(idParam));

            req.setAttribute("product", product);
            req.setAttribute("categories", categoryService.findAll());
            req.setAttribute("brands", brandService.findAll());
            req.getRequestDispatcher("productForm.jsp").forward(req, resp);
        } catch (NumberFormatException e) {
            logger.error("Error (edit) al intentar convenrtir la id a número {}:", idParam, e);

        } catch (Exception e) {
            logger.error("Error (edit):", e);
        }
    }

}
