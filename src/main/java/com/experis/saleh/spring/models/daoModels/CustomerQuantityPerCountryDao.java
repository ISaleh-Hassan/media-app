package com.experis.saleh.spring.models.daoModels;

public class CustomerQuantityPerCountryDao {
    private int numberOfCustomers;
    private String Country;

    public CustomerQuantityPerCountryDao(){

    }

    public CustomerQuantityPerCountryDao(String country, int numberOfCustomers) {
        Country = country;
        this.numberOfCustomers = numberOfCustomers;

    }

    public String getCountry() {
        return Country;
    }

    public void setCountry(String country) {
        Country = country;
    }

    public int getNumberOfCustomers() {
        return numberOfCustomers;
    }

    public void setNumberOfCustomers(int numberOfCustomers) {
        this.numberOfCustomers = numberOfCustomers;
    }
}
