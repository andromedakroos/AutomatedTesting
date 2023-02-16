package tests.db;

import baseEntities.BaseApiTest;
import dbServices.CustomerService;
import dbTables.CustomerTable;
import models.Customer;
import models.CustomerBuilder;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.Test;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class SImpleDBTest extends BaseApiTest {
    Logger logger = LogManager.getLogger(SImpleDBTest.class);


    @Test
    public void simpleDBTest(){
        String sql = "SELECT * FROM public.customers;";
        ResultSet rs = dbService.executeQuery(sql);
        try {
            while(rs.next()){
                int userID = rs.getInt("id");
                String firstname = rs.getString("firstname");
                String lastname = rs.getString("lastname");
                String email = rs.getString("email");
                int age = rs.getInt(5);

                logger.info("ID: " + userID);
                logger.info("firstname: " + firstname);
                logger.info("lastname: " + lastname);
                logger.info("email: " + email);
                logger.info("age: " + age + "\n");
            }
        }catch (SQLException e){
            throw  new RuntimeException();
        }
    }
    @Test
    public void advancedDBTest() throws SQLException {
        CustomerTable customerTable = new CustomerTable(dbService);

        customerTable.dropTable();
        customerTable.createTable();

        customerTable.addCutomer(CustomerBuilder.builder()
                .firstname("Andrew")
                .lastname("Moroz")
                .email("adasda@sabre.com")
                .age(19)
                .build());

        customerTable.addCutomer(CustomerBuilder.builder()
                .firstname("Olya")
                .lastname("Dyatlova")
                .email("dasasddasdasddasa@sabre.com")
                .age(93)
                .build());

        customerTable.addCutomer(CustomerBuilder.builder()
                .firstname("Olya")
                .lastname("Lis")
                .email("dasd11111111dasa@sabre.com")
                .age(38)
                .build());

        ResultSet rs = customerTable.getCustomers();

        try {
            while(rs.next()){
                int userID = rs.getInt("id");
                String firstname = rs.getString("firstname");
                String lastname = rs.getString("lastname");
                String email = rs.getString("email");
                int age = rs.getInt(5);

                logger.info("ID: " + userID);
                logger.info("firstname: " + firstname);
                logger.info("lastname: " + lastname);
                logger.info("email: " + email);
                logger.info("age: " + age + "\n");
            }
        }catch (SQLException e){
            throw  new RuntimeException();
        }

        rs = customerTable.getCustomerById(2);
        rs.next();
        logger.info(rs.getString("id"));
        logger.info(rs.getString("firstname"));
        logger.info(rs.getString("lastname"));
        logger.info(rs.getString("age"));
        logger.info(rs.getString("email"));
    }

    @Test
    public void hibernateTest() {
        CustomerService customerService = new CustomerService();
        Customer customer = new Customer("Ivan", "Grigoriev", "grtest@test.com", 30);

        customerService.saveUser(customer);

        List<Customer> customerList = customerService.findAllUsers();
        for (Customer user : customerList) {
            System.out.println(user.toString());
        }
    }
}
