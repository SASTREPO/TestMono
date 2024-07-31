package com.example.service;

import com.example.config.JdbcConfiguration;
import com.example.model.User;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class SearchUserService {

    private static final Logger logger = LogManager.getLogger(SearchUserService.class);

    public static User getUserByNameUnsafe(String name) {
        String sqlQuery  = "SELECT * FROM \"user\" WHERE name='" + name + "'";

        try (Statement statement = JdbcConfiguration.getConnection().createStatement()) {

            logger.info("Execute query");

            ResultSet rs = statement.executeQuery(sqlQuery); // SQLi SINK

            if(rs.next()) {
                return new User(rs.getString("name"), rs.getInt("age"));
            }

        } catch (Exception e) {
            logger.error("db error" + e.getMessage());
        }

        return null;
    }

    public static User getUserByNameUnsafeThrowsEx(String name) throws SQLException {
        String sqlQuery  = "SELECT * FROM \"user\" WHERE name='" + name + "'";

        try (Statement statement = JdbcConfiguration.getConnection().createStatement()) {

            logger.info("Execute query");

            ResultSet rs = statement.executeQuery(sqlQuery); // SQLi SINK

            if(rs.next()) {
                return new User(rs.getString("name"), rs.getInt("age"));
            }

        } catch (SQLException e) {
            logger.error("db error" + e.getMessage());
            throw new SQLException(e.getMessage());
        }

        return null;
    }
}
