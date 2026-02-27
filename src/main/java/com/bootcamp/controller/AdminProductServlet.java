package com.bootcamp.controller;

import com.bootcamp.dto.product.AdminProductListDTO;
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

    @Override
    public void init() throws ServletException {
        productService = new ProductService();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String path = req.getPathInfo();
        String action = req.getParameter("action");

//        listar productos
        if (path == null || path.equals("/")) {
            List<AdminProductListDTO> products;
            String searchText = req.getParameter("searchText");

            if (action != null && action.equalsIgnoreCase("search")
                    && searchText != null && !searchText.isBlank()) {
                products = productService.search(searchText);
            } else {
                products = productService.findAll();
            }

            req.setAttribute("products", products);
            req.getRequestDispatcher("productList.jsp").forward(req, resp);
            return;
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
}
