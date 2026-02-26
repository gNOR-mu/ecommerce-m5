package com.bootcamp.controller;

import com.bootcamp.dto.product.ProductInfoDTO;
import com.bootcamp.dto.product.ProductResumeDTO;
import com.bootcamp.model.Product;
import com.bootcamp.service.ProductService;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.List;

public class ProductServlet extends HttpServlet {
private ProductService productService;

    @Override
    public void init() throws ServletException {
        productService = new ProductService();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String idParam = req.getParameter("id");

        //en caso de que haya id lo mando a la página del producto
        if(idParam != null && !idParam.isBlank()){
            ProductInfoDTO product = productService.findById(Long.parseLong(idParam));

            req.setAttribute("product", product);
            req.getRequestDispatcher("productId.jsp").forward(req, resp);
            return;
        }

        List<ProductResumeDTO> products = productService.findAllResume();
        req.setAttribute("products", products);
        req.getRequestDispatcher("products.jsp").forward(req, resp);
    }
}
