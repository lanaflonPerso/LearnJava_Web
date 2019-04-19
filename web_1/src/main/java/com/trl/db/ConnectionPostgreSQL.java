package com.trl.db;

import org.apache.log4j.Logger;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public final class ConnectionPostgreSQL {

    private static final Logger LOG = Logger.getLogger(ConnectionPostgreSQL.class);

    private ConnectionPostgreSQL() { }

    public static Connection getConnection() throws ExceptionParameterNotExist {
        Connection connection = null;
        try {
            Class.forName("org.postgresql.Driver");
            connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/test", "developer", "1,5Lht.nt!o0#");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return connection;
    }

}
