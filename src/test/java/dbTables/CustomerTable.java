package dbTables;

import models.CustomerBuilder;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import services.DataBaseService;

import java.sql.ResultSet;

public class CustomerTable {
    Logger logger = LogManager.getLogger(DataBaseService.class);

    private DataBaseService dbService;
    public CustomerTable(DataBaseService dbService) {
        this.dbService = dbService;
    }
    public void createTable(){
        logger.info("create customers table");
        String createTableSQL = "" +
                "create table public.customers " +
                "(id SERIAL PRIMARY KEY," +
                "    firstname CHARACTER VARYING(30)," +
                "    lastname CHARACTER VARYING(30)," +
                "    email CHARACTER VARYING(30)," +
                "    age INTEGER" +
                ");";

        dbService.executeSQL(createTableSQL);
    }

    public void dropTable(){
        logger.info("delete customer table");

        String dropTableSQL = "drop table if exists customers;";

        dbService.executeSQL(dropTableSQL);
    }

    public ResultSet getCustomers(){
        String sql = "SELECT * FROM public.customers;";
        return  dbService.executeQuery(sql);
    }

    public ResultSet getCustomerById(int id){
        String sql = "SELECT * FROM public.customers WHERE id = " + id + ";";
        return  dbService.executeQuery(sql);
    }

    public void addCutomer(CustomerBuilder customerBuilder){
        String insertTableSQL = "INSERT INTO public.Customers(" +
                "firstname, lastname, email, age)" +
                "VALUES ('" + customerBuilder.getFirstname() + "', '" + customerBuilder.getLastname() +
                "', '" + customerBuilder.getEmail() + "', " + customerBuilder.getAge() + ");";
        dbService.executeSQL(insertTableSQL);
    }

    public void updateCutomer(CustomerBuilder customerBuilder){

    }
    public void deleteCutomer(int id){

    }
}
