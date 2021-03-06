package com.experis.saleh.spring.data_access;

import com.experis.saleh.spring.models.daoModels.CustomerFavoriteGenreDao;
import com.experis.saleh.spring.models.daoModels.CustomerQuantityPerCountryDao;
import com.experis.saleh.spring.models.daoModels.CustomerSpentDao;
import com.experis.saleh.spring.models.entity.Customer;
import com.experis.saleh.spring.models.daoModels.CustomerDao;

import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;

public class CustomerRepository {
    private String URL = "jdbc:sqlite::resource:Chinook_Sqlite.sqlite";
    private Connection conn= null;

    public ArrayList<CustomerDao> getAllCustomers(){
        ArrayList<CustomerDao> customers = new ArrayList<>();

        try{
            conn= DriverManager.getConnection(URL);
            PreparedStatement prep =
                    conn.prepareStatement( "SELECT CustomerId,FirstName, LastName,Country, PostalCode,Phone From Customer");
            ResultSet set = prep.executeQuery();
            while (set.next()){
                customers.add (new CustomerDao(
                        set.getInt("customerId"),
                        set.getString("firstName"),
                        set.getString("lastName"),
                        set.getString("country"),
                        set.getString("postalCode"),
                        set.getString("phone")

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


    public ArrayList<CustomerQuantityPerCountryDao> getCustomerQuantityPerCountry(){
        ArrayList<CustomerQuantityPerCountryDao> customerQuantity = new ArrayList<>();

        try{
            conn= DriverManager.getConnection(URL);
            PreparedStatement prep =
                    conn.prepareStatement( "SELECT Customer.Country as Country, COUNT(*) as Quantity FROM Customer GROUP BY Customer.Country Order By COUNT(*) DESC");
            ResultSet set = prep.executeQuery();
            while (set.next()){
                customerQuantity.add (new CustomerQuantityPerCountryDao(
                        set.getString("Country"),
                        set.getInt("Quantity")
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
        return customerQuantity;
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
        return success;
    }

    public Boolean updateCustomer(Customer customer){
        Boolean success = false;
        try{

            conn = DriverManager.getConnection(URL);
            PreparedStatement prep =
                    conn.prepareStatement("UPDATE customer SET FirstName=?, LastName=?,Country=?, PostalCode=?, Phone=?,Email=?" +
                            " WHERE CustomerId=?");

            prep.setString(1,customer.getFirstName());
            prep.setString(2,customer.getLastName());
            prep.setString(3,customer.getCountry());
            prep.setString(4,customer.getPostalCode());
            prep.setString(5,customer.getPhone());
            prep.setString(6,customer.getEmail());
            prep.setInt(7,customer.getCustomerId());

            int result = prep.executeUpdate();
            success = (result != 0); // if res = 1; true

            System.out.println("Update went well!");

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
        return success;
    }

    public ArrayList<CustomerSpentDao> getAllTopSpenders(){
        ArrayList<CustomerSpentDao> allCustomers = new ArrayList<>();
        try{
            conn = DriverManager.getConnection(URL);
            PreparedStatement prep = conn.prepareStatement("select customer.firstName, customer.LastName, SUM(Total) as totalAmount from Invoice inner join Customer customer on Invoice.CustomerId = customer.CustomerId group by Invoice.CustomerId order by TotalAmount desc");
            ResultSet resultSet = prep.executeQuery();
            while(resultSet.next()) {
                allCustomers.add(new CustomerSpentDao(
                        resultSet.getString("firstName"),
                        resultSet.getString("lastName"),
                        resultSet.getString("totalAmount"))
                );
            }
        }
        catch (SQLException throwables){
            throwables.printStackTrace();
        }
        finally {
            try{
                conn.close();
            }
            catch (SQLException sqlException){
                sqlException.printStackTrace();
            }
        }
        return allCustomers;
    }

    public CustomerFavoriteGenreDao getCustomerFavoriteGenres(int customerId){
        CustomerFavoriteGenreDao customer = new CustomerFavoriteGenreDao();
        HashMap<String,Integer> favoriteGenresMap = new HashMap<>();
        try{
            conn = DriverManager.getConnection(URL);
            PreparedStatement prep = conn.prepareStatement("select customer.FirstName as firstName, customer.LastName as lastName, genre.Name as Genre ,count(*) as total from InvoiceLine inner join Invoice invoice on invoice.InvoiceId = InvoiceLine.InvoiceId inner join Customer customer on customer.CustomerId = invoice.CustomerId inner join Track track on InvoiceLine.TrackId = track.TrackId inner join Genre genre on track.GenreId = genre.GenreId where invoice.CustomerId = ? group by genre.Name order by total desc limit 2;");
            prep.setInt(1, customerId);
            ResultSet resultSet = prep.executeQuery();

            String firstName = resultSet.getString("firstName");
            String lastName  = resultSet.getString("lastName");
            int max = resultSet.getInt("total");
            while(resultSet.next()) {
                if(max == resultSet.getInt("total")){
                    favoriteGenresMap.put(resultSet.getString("Genre"),max);
                }
            }
            customer.setFirstName(firstName);
            customer.setLastName(lastName);
            customer.setFavoriteGenres(favoriteGenresMap);
        }
        catch (SQLException sqlException){
            sqlException.printStackTrace();
        }
        finally {
            try{
                conn.close();
            }
            catch (SQLException sqlException){
                sqlException.printStackTrace();
            }
        }
        return customer;
    }

}
