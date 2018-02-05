package com.example.everaldo.carros.entities;

import android.graphics.drawable.Drawable;
import android.renderscript.Allocation;

/**
 * Created by EVERALDO on 03/02/2018.
 */

//Classe para atributos do carro
public class Car {

    public int id;
    public String model;
    public String manufacturer;
    public int horsePower;
    public Double price;
    public Drawable picture;


    public Car(int id, String model, String manufacturer, int horsePower, Double price, Drawable picture) {
        this.id = id;
        this.model = model;
        this.manufacturer = manufacturer;
        this.horsePower = horsePower;
        this.price = price;
        this.picture = picture;
    }
}
