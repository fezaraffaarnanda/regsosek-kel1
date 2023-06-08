package database;

import java.sql.*;
import java.util.List;
import java.util.Map;

public class Database {
    private final QueryRunner queryRunner;

    private final String DB_TYPE = "mysql";
    private final String DB_HOST = "localhost";
    private final String DB_PORT = "3306";
    private final String DB_NAME = "kelduareg";
    private final String DB_USER = "kelduareg";
    private final String DB_PASS = "kelduareg";

    private static Database instance;

    public Database() {
        this.queryRunner = new QueryRunnerImpl();
    }

    public static synchronized Database getInstance() {
        if (instance == null) {
            instance = new Database();
        }

        return instance;
    }

    public void run(String query, List<Object> params) throws SQLException {
        this.queryRunner.run(getConnection(), query, params);
    }

    public void run(String query) throws SQLException {
        this.queryRunner.run(getConnection(), query);
    }

    public List<Map<String, Object>> query(String query, List<Object> params) throws SQLException {
        return this.queryRunner.query(getConnection(), query, params);
    }

    public List<Map<String, Object>> query(String query) throws SQLException {
        return this.queryRunner.query(getConnection(), query);
    }

    public Connection getConnection() throws SQLException {
        return DriverManager.getConnection(String.format(
            "jdbc:%s://%s:%s/%s",
                DB_TYPE,
                DB_HOST,
                DB_PORT,
                DB_NAME
        ), DB_USER, DB_PASS);
    }
}
