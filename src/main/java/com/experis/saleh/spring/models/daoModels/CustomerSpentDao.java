package com.experis.saleh.spring.models.daoModels;


public class CustomerSpentDao {

    private String firstName;
    private String lastName;
    private String totalAmount;


    public CustomerSpentDao(){

    }

    public CustomerSpentDao(String firstName, String lastName, String totalAmount){
        this.firstName = firstName;
        this.lastName = lastName;
        this.totalAmount = totalAmount;
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

    public String getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(String totalAmount) {
        this.totalAmount = totalAmount;
    }
}
