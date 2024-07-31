package io.mend.service;

import io.mend.conf.JdbcConfiguration;
import io.mend.model.User;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

public class SearchUser {
    private static final Logger logger = LogManager.getLogger("SearchUser");

    public static User getUserByNameSafe(String name) {
        String sqlQuery  = "SELECT * FROM \"user\" WHERE name=?";

        try (PreparedStatement statement = JdbcConfiguration.getConnection().prepareStatement(sqlQuery)) {
            statement.setString(1, name);
            ResultSet rs = statement.executeQuery();
            if(rs.next()) {
                return new User(rs.getString("name"), rs.getInt("age"));
            }
        } catch (Exception e) {
            logger.error("db error");
        }

        return null;
    }

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
}
