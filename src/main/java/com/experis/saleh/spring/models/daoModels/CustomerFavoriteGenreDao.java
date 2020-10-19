package com.experis.saleh.spring.models.daoModels;

import java.util.Map;

public class CustomerFavoriteGenreDao {

    private String firstName;
    private String lastName;
    private Map<String,Integer> favoriteGenres;


    public CustomerFavoriteGenreDao() {
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

    public Map<String, Integer> getFavoriteGenres() {
        return favoriteGenres;
    }

    public void setFavoriteGenres(Map<String, Integer> favoriteGenres) {
        this.favoriteGenres = favoriteGenres;
    }
}
