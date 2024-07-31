package com.example.config;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class JdbcConfiguration {

    private static final Logger logger = LogManager.getLogger("JdbcConfiguration");

    private static Connection connection;

    private static final String url = "jdbc:h2:mem:testdb;INIT=CREATE SCHEMA IF NOT EXISTS TESTDB";

    public static Connection getConnection() {

        if (connection == null) {
            try {
                Class.forName ("org.h2.Driver");
                connection = DriverManager.getConnection(url, "sa", "password");

                try (Statement statement = connection.createStatement()) {
                    statement.executeUpdate("DROP TABLE IF EXISTS \"user\"");
                    statement.execute("CREATE TABLE \"user\" (id int NOT NULL AUTO_INCREMENT, name varchar(50), age int, PRIMARY KEY (id));");
                    statement.execute("INSERT INTO \"user\" (name, age) VALUES ('james', 35)");
                } catch (Exception e) {
                    logger.error("db initialization error: " + e.getMessage());
                }
            } catch (Exception e) {
                logger.error("db error: " + e.getMessage());
            }
        }
        return connection;
    }
}
