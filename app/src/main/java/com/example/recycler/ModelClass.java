package com.example.recycler;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import java.io.Serializable;

public class ModelClass implements Serializable {
    String firstName,lastName,position,country,smallImg,largeImg;

    public ModelClass(String firstName, String lastName, String position, String country, String smallImg, String largeImg) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.position = position;
        this.country = country;
        this.smallImg = smallImg;
        this.largeImg = largeImg;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getPosition() {
        return position;
    }

    public String getCountry() {
        return country;
    }

    public String getSmallImg() {
        return smallImg;
    }

    public String getLargeImg() {
        return largeImg;
    }
}