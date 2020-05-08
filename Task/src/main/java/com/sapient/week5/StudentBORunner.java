package com.sapient.week5;

public class StudentBORunner {
    public static void main(String[] args) {
        StudentBO studentBO = new StudentBOHandler();
        studentBO.read();
        studentBO.read();
        studentBO.read();
        studentBO.display();
        studentBO.displayNameWise();
        studentBO.displayCityWise();
        studentBO.display("Delhi");
        try {
            studentBO.display(3);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
