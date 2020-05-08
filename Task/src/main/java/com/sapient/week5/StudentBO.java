package com.sapient.week5;

public interface StudentBO {
    public void read();

    public void display();

    public void display(String city);

    public void displayNameWise();

    public void displayCityWise();

    public void display(int id) throws Exception;
}
