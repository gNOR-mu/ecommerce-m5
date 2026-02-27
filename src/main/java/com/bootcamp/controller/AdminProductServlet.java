package com.bootcamp.controller;

import com.bootcamp.dto.product.AdminProductListDTO;
import com.bootcamp.service.ProductService;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.List;

public class AdminProductServlet extends HttpServlet {
    private ProductService productService;

    @Override
    public void init() throws ServletException {
        productService = new ProductService();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String path = req.getPathInfo();

//        listar productos
        if (path == null || path.equals("/")) {
            List<AdminProductListDTO> products = productService.findAll();

            req.setAttribute("products", products);
            req.getRequestDispatcher("productList.jsp").forward(req, resp);
            return;
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getParameter("action");

        if(action.equalsIgnoreCase("delete")){
            //TODO
        }


        resp.sendRedirect(req.getContextPath() + "/admin/products");

    }
}
