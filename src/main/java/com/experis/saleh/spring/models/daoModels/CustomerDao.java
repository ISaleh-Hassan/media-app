package com.experis.saleh.spring.models.daoModels;
public class CustomerDao {
    private int customerId;
    private String firstName;
    private String lastName;
    private String country;
    private String postalCode;
    private String phone;


    public CustomerDao(int costomerId, String firstName, String lastName, String country, String postalCode, String phone){
        this.customerId = costomerId;
        this.firstName= firstName;
        this.lastName= lastName;
        this.country= country;
        this.postalCode= postalCode;
        this.phone= phone;

    }

    public int getCustomerId() {
        return customerId;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }


}
