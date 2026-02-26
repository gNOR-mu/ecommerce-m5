package com.bootcamp.controller;

import com.bootcamp.dto.product.ProductResumeDTO;
import com.bootcamp.service.ProductService;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.List;

public class IndexServlet extends HttpServlet {

    private ProductService productService;

    @Override
    public void init() throws ServletException {
        productService = new ProductService();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<ProductResumeDTO> topProductDTOS = productService.getTopProducts();

        req.setAttribute("products", topProductDTOS);
        req.getRequestDispatcher("index.jsp").forward(req, resp);
    }
}
