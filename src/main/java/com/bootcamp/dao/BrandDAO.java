package com.bootcamp.dao;

import com.bootcamp.config.DatabaseConnection;
import com.bootcamp.model.Brand;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class BrandDAO {
    private static final Logger logger = LoggerFactory.getLogger(CategoryDAO.class);
    private final DatabaseConnection db = DatabaseConnection.getInstance();

    public List<Brand> findAll() {
        List<Brand> brands = new ArrayList<>();

        String sql = "SELECT ID, NAME FROM BRANDS";

        try (PreparedStatement ps = db.getConnection().prepareStatement(sql)) {
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                brands.add(new Brand(
                        rs.getLong("ID"),
                        rs.getString("NAME")
                ));
            }
        } catch (Exception e) {
            logger.error("Error: ", e);
        }

        return brands;
    }

    public boolean existsById(Long id) {
        String sql = "SELECT 1 FROM BRANDS WHERE ID = ?";
        try (PreparedStatement ps = db.getConnection().prepareStatement(sql)) {
            ps.setLong(1, id);
            ResultSet rs = ps.executeQuery();
            return rs.next();
        } catch (Exception e) {
            logger.error("Error: ", e);
            return false;
        }
    }
}
