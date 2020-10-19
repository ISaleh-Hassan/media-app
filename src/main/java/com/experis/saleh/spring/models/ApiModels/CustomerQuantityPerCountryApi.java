package com.experis.saleh.spring.models.ApiModels;

public class CustomerQuantityPerCountryApi {
    private int numberOfCustomers;
    private String Country;

    public CustomerQuantityPerCountryApi(){

    }

    public CustomerQuantityPerCountryApi(String country, int numberOfCustomers) {
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
