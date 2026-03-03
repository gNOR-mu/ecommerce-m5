package com.bootcamp.controller;

import com.bootcamp.dto.product.AdminProductListDTO;
import com.bootcamp.dto.product.ProductFormDTO;
import com.bootcamp.model.Brand;
import com.bootcamp.model.Category;
import com.bootcamp.model.Product;
import com.bootcamp.service.BrandService;
import com.bootcamp.service.CategoryService;
import com.bootcamp.service.ProductService;
import com.fasterxml.jackson.databind.ObjectMapper;
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

    /**
     * {@inheritDoc}
     */
    @Override
    public void init() throws ServletException {
        productService = new ProductService();
        brandService = new BrandService();
        categoryService = new CategoryService();
    }

    /**
     * {@inheritDoc}
     */
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

    /**
     * {@inheritDoc}
     */
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getParameter("action");

        switch (action) {
            case "delete" -> {
                String idParam = req.getParameter("id");
                try {
                    Long id = Long.parseLong(idParam);
                    productService.deleteById(id);
                    req.getSession().setAttribute("successMessage", "Producto eliminado correctamente.");
                } catch (Exception e) {
                    logger.error("Error al intentar eliminar con una 'id' = '{}'", idParam, e);
                    req.getSession().setAttribute("errorMessage", "Error al eliminar el producto.");
                }
                resp.sendRedirect(req.getContextPath() + "/admin/products");
            }

            case "save" -> {
                try {
                    ObjectMapper mapper = new ObjectMapper();
                    String idParam = req.getParameter("id");
                    ProductFormDTO product = new ProductFormDTO();

                    product.setCategoryId(Long.parseLong(req.getParameter("categoryId")));
                    product.setBrandId(Long.parseLong(req.getParameter("brandId")));
                    product.setPrice(new BigDecimal(req.getParameter("price")));
                    product.setName(req.getParameter("name"));
                    product.setUrlImage(req.getParameter("urlImage"));
                    product.setDescription(req.getParameter("description"));
                    product.setShortDescription(req.getParameter("shortDescription"));

                    if (idParam != null && !idParam.isEmpty()) {
                        product.setId(Long.parseLong(idParam));
                    }

                    String[] keys = req.getParameterValues("featureKeys");
                    String[] values = req.getParameterValues("featureValues");

                    Map<String, Object> featuresMap = new HashMap<>();
                    if (keys != null && values != null) {
                        for (int i = 0; i < keys.length; i++) {
                            featuresMap.put(keys[i], values[i]);
                        }
                    }

                    String jsonFeatures = mapper.writeValueAsString(featuresMap);
                    product.setFeatures(jsonFeatures);

                    if (product.getId() == null) {
                        productService.create(product);
                    } else {
                        productService.edit(product);
                    }
                    req.getSession().setAttribute("successMessage", "Producto guardado correctamente.");
                } catch (Exception e) {
                    logger.error("Error (create):", e);
                    req.getSession().setAttribute("errorMessage", "Error al guardar el producto: " + e.getMessage());
                }

                resp.sendRedirect(req.getContextPath() + "/admin/products");
            }
        }
    }

    /**
     * Realiza una búsqueda de productos, basado en los campos searchText, utiliza productList.jsp
     * @param req Request
     * @param resp Response
     * @throws ServletException
     * @throws IOException
     */
    private void search(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<AdminProductListDTO> products;
        String searchText = req.getParameter("searchText");
        products = productService.search(searchText);

        req.setAttribute("products", products);
        req.getRequestDispatcher("productList.jsp").forward(req, resp);
    }

    /**
     * Realiza una búsqueda de todos los productos, utiliza productList.jsp
     * @param req Request
     * @param resp Response
     * @throws ServletException
     * @throws IOException
     */
    private void list(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<AdminProductListDTO> products;
        products = productService.findAll();
        req.setAttribute("products", products);
        req.getRequestDispatcher("productList.jsp").forward(req, resp);
    }

    /**
     * Utiliza productForm.jsp para crear una nueva categoría
     *
     * @param req Request
     * @param resp Response
     * @throws ServletException
     * @throws IOException
     */
    private void create(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setAttribute("categories", categoryService.findAll());
        req.setAttribute("brands", brandService.findAll());

        req.getRequestDispatcher("productForm.jsp").forward(req, resp);
    }

    /**
     *
     * @param req Request
     * @param resp Response
     * @throws ServletException
     * @throws IOException
     */
    private void edit(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String idParam = req.getParameter("id");

        if (idParam == null || idParam.isBlank()) {
            logger.info("INFO (edit): Intento de editar con una id inválida '{}'", idParam);
            return;
        }

        try {
            Product product = productService.findById(Long.parseLong(idParam));

            req.setAttribute("product", product);
            req.setAttribute("categories", categoryService.findAll());
            req.setAttribute("brands", brandService.findAll());
            req.getRequestDispatcher("productForm.jsp").forward(req, resp);
        } catch (NumberFormatException e) {
            logger.error("Error (edit) al intentar convertir la id a número {}:", idParam, e);
            resp.sendRedirect(req.getContextPath() + "/admin/products");

        } catch (Exception e) {
            logger.error("Error (edit):", e);
            resp.sendRedirect(req.getContextPath() + "/admin/products");
        }
    }

}
