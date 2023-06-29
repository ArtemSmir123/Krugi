package com.example.demo3;

public class Triangle {
    private double x1; //A
    private double y1; //A
    private double x2; //B
    private double y2; //B
    private double x3; //C
    private double y3; //C
    private double AB;
    private double BC;
    private double AC;

    Triangle (Circle circle1, Circle circle2, Circle circle3){
        x1 = circle1.getX();
        y1 = circle1.getY();
        x2 = circle2.getX();
        y2 = circle2.getY();
        x3 = circle3.getX();
        y3 = circle3.getY();
    }
}
