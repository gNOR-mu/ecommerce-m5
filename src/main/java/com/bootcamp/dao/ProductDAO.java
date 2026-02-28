package com.bootcamp.dao;

import com.bootcamp.config.DatabaseConnection;
import com.bootcamp.dto.product.AdminProductListDTO;
import com.bootcamp.dto.product.ProductFormDTO;
import com.bootcamp.dto.product.ProductInfoDTO;
import com.bootcamp.dto.product.ProductResumeDTO;
import com.bootcamp.model.Product;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.math.BigDecimal;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class ProductDAO {
    private static final Logger logger = LoggerFactory.getLogger(ProductDAO.class);
    private final DatabaseConnection db = DatabaseConnection.getInstance();

    /**
     * Obtiene los productos más vendidos
     *
     * @return Una lista con los 3 productos más vendidos
     */
    public List<ProductResumeDTO> getTopProducts() {
        List<ProductResumeDTO> topProductDTOS = new ArrayList<>();

        String sql = """
                    SELECT P.ID, P.NAME, P.SHORT_DESCRIPTION, P.URL_IMAGE, P.PRICE
                    FROM PRODUCTS P
                    JOIN ORDERS_ITEM OI ON P.ID = OI.PRODUCT_ID
                    GROUP BY P.ID, P.NAME, P.SHORT_DESCRIPTION, P.URL_IMAGE
                    ORDER BY SUM(OI.QUANTITY) DESC
                    LIMIT 3;
                """;

        try (PreparedStatement ps = db.getConnection().prepareStatement(sql)) {
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                topProductDTOS.add(new ProductResumeDTO(
                        rs.getLong("ID"),
                        rs.getString("NAME"),
                        rs.getString("SHORT_DESCRIPTION"),
                        rs.getString("URL_IMAGE"),
                        rs.getBigDecimal("PRICE")
                ));
            }
        } catch (Exception e) {
            logger.error("Error: ", e);
        }
        return topProductDTOS;
    }

    public List<ProductResumeDTO> findAllResume() {
        List<ProductResumeDTO> products = new ArrayList<>();
        String sql = """
                SELECT ID, NAME, SHORT_DESCRIPTION, URL_IMAGE, PRICE
                FROM PRODUCTS;
                """;

        try (PreparedStatement ps = db.getConnection().prepareStatement(sql)) {
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                products.add(new ProductResumeDTO(
                        rs.getLong("ID"),
                        rs.getString("NAME"),
                        rs.getString("SHORT_DESCRIPTION"),
                        rs.getString("URL_IMAGE"),
                        rs.getBigDecimal("PRICE")
                ));

            }
        } catch (Exception e) {
            logger.error("Error: ", e);
        }
        return products;
    }

    public List<AdminProductListDTO> findAll() {
        List<AdminProductListDTO> products = new ArrayList<>();

        String sql = """
                SELECT
                    B.NAME AS B_NAME,
                    C.NAME AS C_NAME,
                    P.ID,
                    P.PRICE,
                    P.STOCK,
                    P.NAME AS P_NAME
                FROM PRODUCTS P
                JOIN CATEGORIES C ON C.ID = P.CATEGORY_ID
                JOIN BRANDS B ON B.ID = P.BRAND_ID;
                """;

        try (PreparedStatement ps = db.getConnection().prepareStatement(sql)) {
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                AdminProductListDTO product = new AdminProductListDTO();
                product.setBrandName(rs.getString("B_NAME"));
                product.setCategoryName(rs.getString("C_NAME"));
                product.setId(rs.getLong("ID"));
                product.setPrice(rs.getBigDecimal("PRICE"));
                product.setName(rs.getString("P_NAME"));
                product.setStock(rs.getInt("STOCK"));

                products.add(product);
            }
        } catch (Exception e) {
            logger.error("Error: ", e);
        }
        return products;
    }

    public Product findById(Long id) {
        Product product = null;

        String sql = """
                SELECT *
                FROM PRODUCTS
                WHERE ID = ?;
                """;

        try (PreparedStatement ps = db.getConnection().prepareStatement(sql)) {
            ps.setLong(1, id);
            ResultSet rs = ps.executeQuery();


            while (rs.next()) {
                ObjectMapper mapper = new ObjectMapper();
                try {
                    String featuresJSON = rs.getString("FEATURES");
                    Map<String, Object> features = mapper.readValue(featuresJSON, new TypeReference<>() {
                    });

                    product = new Product(
                            rs.getLong("ID"),
                            rs.getLong("CATEGORY_ID"),
                            rs.getLong("BRAND_ID"),
                            rs.getBigDecimal("PRICE"),
                            features,
                            rs.getString("NAME"),
                            rs.getString("URL_IMAGE"),
                            rs.getString("DESCRIPTION"),
                            rs.getString("SHORT_DESCRIPTION"),
                            rs.getInt("STOCK"));

                } catch (Exception e) {
                    logger.error("Error al obtener las características de: {}", product, e);
                }
            }

        } catch (Exception e) {
            logger.error("Error: ", e);
        }

        return product;
    }

    public ProductInfoDTO findInfoById(Long id) {
        ProductInfoDTO productInfoDTO = null;

        String sql = """
                SELECT ID, PRICE, FEATURES, NAME, URL_IMAGE, DESCRIPTION, SHORT_DESCRIPTION
                FROM PRODUCTS
                WHERE ID = ?;
                """;

        try (PreparedStatement ps = db.getConnection().prepareStatement(sql)) {
            ps.setLong(1, id);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                productInfoDTO = new ProductInfoDTO();
                productInfoDTO.setId(rs.getLong("ID"));
                productInfoDTO.setPrice(rs.getBigDecimal("PRICE"));
                productInfoDTO.setName(rs.getString("NAME"));
                productInfoDTO.setUrlImage(rs.getString("URL_IMAGE"));
                productInfoDTO.setDescription(rs.getString("DESCRIPTION"));
                productInfoDTO.setShortDescription(rs.getString("SHORT_DESCRIPTION"));

                ObjectMapper mapper = new ObjectMapper();
                try {
                    String featuresJSON = rs.getString("FEATURES");
                    Map<String, Object> features = mapper.readValue(featuresJSON, new TypeReference<>() {
                    });
                    productInfoDTO.setFeatures(features);
                } catch (Exception e) {
                    logger.error("Error al obtener las características de: {}", productInfoDTO, e);
                }
            }


        } catch (Exception e) {
            logger.error("Error: ", e);
        }

        return productInfoDTO;
    }

    /**
     * Elimina un producto
     *
     * @param id Id del producto a eliminar
     */
    public void deleteById(Long id) {
        String sql = "DELETE FROM PRODUCTS WHERE ID = ?";

        try (PreparedStatement ps = db.getConnection().prepareStatement(sql)) {
            ps.setLong(1, id);

            ps.executeUpdate();

        } catch (Exception e) {
            logger.error("Error: ", e);
        }
    }

    public List<AdminProductListDTO> search(String searchText) {
        List<AdminProductListDTO> products = new ArrayList<>();
        String searchParam = "%" + searchText + "%";

        String sql = """
                SELECT
                        B.NAME AS B_NAME,
                        C.NAME AS C_NAME,
                        P.ID,
                        P.PRICE,
                        P.STOCK,
                        P.NAME AS P_NAME
                
                    FROM PRODUCTS P
                    JOIN CATEGORIES C ON C.ID = P.CATEGORY_ID
                    JOIN BRANDS B ON B.ID = P.BRAND_ID
                    WHERE P.NAME LIKE ?
                    OR C.NAME LIKE ?;
                """;

        try (PreparedStatement ps = db.getConnection().prepareStatement(sql)) {
            ps.setString(1, searchParam);
            ps.setString(2, searchParam);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                AdminProductListDTO product = new AdminProductListDTO();
                product.setBrandName(rs.getString("B_NAME"));
                product.setCategoryName(rs.getString("C_NAME"));
                product.setId(rs.getLong("ID"));
                product.setPrice(rs.getBigDecimal("PRICE"));
                product.setName(rs.getString("P_NAME"));
                product.setStock(rs.getInt("STOCK"));

                products.add(product);
            }
        } catch (Exception e) {
            logger.error("Error al intentar buscar {}", searchText, e);
        }

        return products;

    }

    public void save(ProductFormDTO product) {

        String sql = """
                INSERT INTO PRODUCTS (
                        BRAND_ID,
                        CATEGORY_ID,
                        URL_IMAGE,
                        STOCK,
                        NAME,
                        FEATURES,
                        PRICE,
                        DESCRIPTION,
                        SHORT_DESCRIPTION
                    )
                VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)
                """;

        try (PreparedStatement ps = db.getConnection().prepareStatement(sql)) {
            ps.setLong(1, product.getBrandId());
            ps.setLong(2, product.getCategoryId());
            ps.setString(3, product.getUrlImage());
            ps.setInt(4, product.getStock());
            ps.setString(5, product.getName());
            ps.setString(6, product.getFeatures());
            ps.setBigDecimal(7, product.getPrice());
            ps.setString(8, product.getDescription());
            ps.setString(9, product.getShortDescription());


            ps.executeUpdate();

        } catch (Exception e) {
            logger.error("Error: ", e);
        }
    }
}
