package com.experis.saleh.spring.data_access;

import com.experis.saleh.spring.models.Customer;

import java.sql.*;
import java.util.ArrayList;

public class CustomerRepository {
    private String URL = "jdbc:sqlite::resource:Chinook_Sqlite.sqlite";
    private Connection conn= null;

    public ArrayList<Customer> getAllCustomers(){
        ArrayList<Customer> customers = new ArrayList<>();

        try{
            conn= DriverManager.getConnection(URL);
            PreparedStatement prep =
                    conn.prepareStatement( "SELECT CustomerId,FirstName, LastName,Country, PostalCode,Phone,Email From Customer");
            ResultSet set = prep.executeQuery();
            while (set.next()){
                customers.add (new Customer(
                        set.getInt("customerId"),
                        set.getString("firstName"),
                        set.getString("lastName"),
                        set.getString("country"),
                        set.getString("postalCode"),
                        set.getString("phone"),
                        set.getString("email")
                ));

                System.out.println("Get all went well!");
            }
        } catch (Exception exception) {
            System.out.println(exception.toString());
        }
          finally {
            try {
                conn.close();
            } catch (Exception exception){
                System.out.println(exception.toString());
            }
        }
        return customers;
    }

    public Boolean addCustomer(Customer customer){
        Boolean success = false;

        try{

            conn = DriverManager.getConnection(URL);
            PreparedStatement prep =
                    conn.prepareStatement("INSERT INTO Customer(CustomerId,FirstName, LastName,Country, PostalCode,Phone,Email)" +
                            " VALUES(?,?,?,?,?,?,?)");

            prep.setInt(1,customer.getCustomerId());
            prep.setString(2,customer.getFirstName());
            prep.setString(3,customer.getLastName());
            prep.setString(4,customer.getCountry());
            prep.setString(5,customer.getPostalCode());
            prep.setString(6,customer.getPhone());
            prep.setString(7,customer.getEmail());



            int result = prep.executeUpdate();
            success = (result != 0); // if res = 1; true

            System.out.println("Add went well!");

        }catch(Exception exception){
            System.out.println(exception.toString());
        }
        finally {
            try{
                conn.close();
            } catch (Exception exception){
                System.out.println(exception.toString());
            }
        }
        // ---
        return success;
    }
}
