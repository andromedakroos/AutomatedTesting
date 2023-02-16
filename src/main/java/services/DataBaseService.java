package services;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.*;

public class DataBaseService {
    static final String DB_TYPE = "postgresql";
    static final String SERVER_NAME = "localhost";
    static final String DB_PORT = "5432";
    static final String DB_NAME  = "postgres";
    static final String DB_USERNAME  = "postgres";
    static final String DB_PASSWORD  = "postgres";
    Connection connection;
    Logger logger = LogManager.getLogger(DataBaseService.class);

    public DataBaseService() {
        try{
            Class.forName("org.postgresql.Driver");
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }

        String jdbc = "jdbc:" + DB_TYPE + "://" + SERVER_NAME + ":" + DB_PORT + "/" + DB_NAME;

        try {
           connection = DriverManager.getConnection(jdbc, DB_USERNAME, DB_PASSWORD);
           logger.info("Connect SUCCESS");
        } catch (SQLException e) {
            logger.info("ERROR unable to connect");
            throw new RuntimeException(e);
        }
    }

    public Statement getStatement(){
        try {
            return this.connection.createStatement();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void executeSQL(String sql){
        try {
            getStatement().execute(sql);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    public ResultSet executeQuery(String sql){
        try {
            return getStatement().executeQuery(sql);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void closeConnection(){
        if(connection != null){
            try {
                connection.close();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
