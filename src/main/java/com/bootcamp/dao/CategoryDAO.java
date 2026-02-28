package com.bootcamp.dao;

import com.bootcamp.config.DatabaseConnection;
import com.bootcamp.model.Category;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class CategoryDAO {
    private static final Logger logger = LoggerFactory.getLogger(CategoryDAO.class);
    private final DatabaseConnection db = DatabaseConnection.getInstance();

    public List<Category> findAll() {
        List<Category> categories = new ArrayList<>();

        String sql = "SELECT ID, NAME FROM CATEGORIES";

        try (PreparedStatement ps = db.getConnection().prepareStatement(sql)) {
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                categories.add(new Category(
                        rs.getLong("ID"),
                        rs.getString("NAME")
                ));
            }
        } catch (Exception e) {
            logger.error("Error: ", e);
        }

        return categories;
    }
}
