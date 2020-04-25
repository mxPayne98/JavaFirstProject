package com.sapient.shapes;

public class Shapes {
    int numdberOfSides;

    public void calculateShapeArea(int numdberOfSides, int sideLength) {
        if (numdberOfSides == 1) {
            Circle c = new Circle();
            System.out.println("The Area of the Circle is " + c.calculateArea(sideLength));
        } else if (numdberOfSides == 3) {
            Triangle t = new Triangle();
            System.out.println("The Area of the Triangle is " + t.calculateArea(sideLength));
        } else if (numdberOfSides == 4) {
            Square s = new Square();
            System.out.println("The Area of the Square is " + s.calculateArea(sideLength));
        } else {
            System.out.println("No Shapes Present");
        }
    }

    public static void main(String[] args) {
        Shapes shape = new Shapes();
        shape.calculateShapeArea(3, 12);
        shape.calculateShapeArea(4, 15);
        shape.calculateShapeArea(5, 15);
    }
}
