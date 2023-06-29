package com.example.demo3;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static com.example.demo3.Circle.*;
import static com.example.demo3.MainController.raschet;

public class CircleTest {
    static Circle circle1;
    static Circle circle2;
    static Circle circle3;
    static Circle circle4;
    static Circle circle5;
    static Circle circle6;
    static Circle circle7;
    static Circle circle8;
    @BeforeAll
    static void before(){

        circle1 = new Circle(2,9,2);
        circle2 = new Circle(8,9,2);

        circle3 = new Circle(8,9,2);
        circle4 = new Circle(3,9,2);

        circle5 = new Circle(4,4,2);
        circle6 = new Circle(4,9,2);

        circle7 = new Circle(4,9,2);
        circle8 = new Circle(4,4,2);
    }
    @Test
    void check(){
        check12(circle1, circle2);
        try {
            System.out.println(pointСheckY(circle1));
        } catch (MyNewException ex){
            System.out.println("false");
        }
        try {
            System.out.println(pointСheckY(circle2));
        } catch (MyNewException ex){
            System.out.println("false");
        }
//
//        System.out.println("Координаты 1го круга: ");
//        System.out.print(circle1.getX() + " ");
//        System.out.print(circle1.getY() + " ");
//        System.out.println(circle1.getR() + " ");
//        System.out.println("Координаты точки, в которой пересекается прямая с кругом: ");
//        System.out.print(circle1.xFounded + " ");
//        System.out.println(circle1.yFounded);
//
//        System.out.println();
//        System.out.println("Координаты 2го круга: ");
//        System.out.print(circle2.getX() + " ");
//        System.out.print(circle2.getY() + " ");
//        System.out.println(circle2.getR() + " ");
//        System.out.println("Координаты точки, в которой пересекается прямая с кругом: ");
//        System.out.print(circle2.x1Founded + " ");
//        System.out.println(circle2.y1Founded);
    } // для y == y
    @Test
    void check1(){
        check12(circle3, circle4);

        try {
            System.out.println(pointСheckY(circle3));
        } catch (MyNewException ex){
            System.out.println("false");
        }
        try {
            System.out.println(pointСheckY(circle4));
        } catch (MyNewException ex){
            System.out.println("false");
        }

//        System.out.println();
//        System.out.println("Координаты 1го круга: ");
//        System.out.print(circle3.getX() + " ");
//        System.out.print(circle3.getY() + " ");
//        System.out.println(circle3.getR() + " ");
//        System.out.println("Координаты точки, в которой пересекается прямая с кругом: ");
//        System.out.print(circle3.xFounded + " ");
//        System.out.println(circle3.yFounded);
//        System.out.print(circle3.x1Founded + " ");
//        System.out.println(circle3.y1Founded);
//
//        System.out.println();
//        System.out.println("Координаты 2го круга: ");
//        System.out.print(circle4.getX() + " ");
//        System.out.print(circle4.getY() + " ");
//        System.out.println(circle4.getR() + " ");
//        System.out.println("Координаты точки, в которой пересекается прямая с кругом: ");
//        System.out.print(circle4.xFounded + " ");
//        System.out.println(circle4.yFounded);
//        System.out.print(circle4.x1Founded + " ");
//        System.out.println(circle4.y1Founded);
    } // для y == y перевернутый
    @Test
    void check2(){
        check12(circle5, circle6);
        try {
            System.out.println(pointСheckX(circle5));
        } catch (MyNewException ex){
            System.out.println("false");
        }
        try {
            System.out.println(pointСheckX(circle6));
        } catch (MyNewException ex){
            System.out.println("false");
        }
//        System.out.println();
//        System.out.println("Координаты 1го круга: ");
//        System.out.print(circle5.getX() + " ");
//        System.out.print(circle5.getY() + " ");
//        System.out.println(circle5.getR() + " ");
//        System.out.println("Координаты точки, в которой пересекается прямая с кругом: ");
//        System.out.print(circle5.xFounded + " ");
//        System.out.println(circle5.yFounded);
//        System.out.print(circle5.x1Founded + " ");
//        System.out.println(circle5.y1Founded);
//
//        System.out.println();
//        System.out.println("Координаты 2го круга: ");
//        System.out.print(circle6.getX() + " ");
//        System.out.print(circle6.getY() + " ");
//        System.out.println(circle6.getR() + " ");
//        System.out.println("Координаты точки, в которой пересекается прямая с кругом: ");
//        System.out.print(circle6.xFounded + " ");
//        System.out.println(circle6.yFounded);
//        System.out.print(circle6.x1Founded + " ");
//        System.out.println(circle6.y1Founded);
    } // для x == x
    @Test
    void check3(){
        check12(circle7, circle8);
        try {
            System.out.println(pointСheckX(circle7));
        } catch (MyNewException ex){
            System.out.println("false");
        }
        try {
            System.out.println(pointСheckX(circle8));
        } catch (MyNewException ex){
            System.out.println("false");
        }
    } // для x == x перевернутый

    @Test
    void checking(){
//        Circle cir = new Circle(2,2,1);
//        Circle cir1 = new Circle(7,2,2);
//        Circle cir2 = new Circle(2,7,2);
        Circle cir = new Circle(3,3,2);
        Circle cir1 = new Circle(14,3,2);
        Circle cir2 = new Circle(14,9,3);
        check12(cir, cir1);
        check12(cir1, cir2);
        check12(cir2, cir);

        System.out.print(cir.xFounded + " ");
        System.out.println(cir.yFounded + " ");
        System.out.print(cir.x1Founded + " ");
        System.out.println(cir.y1Founded + " ");

        System.out.print(cir1.xFounded + " ");
        System.out.println(cir1.yFounded + " ");
        System.out.print(cir1.x1Founded + " ");
        System.out.println(cir1.y1Founded + " ");

        System.out.print(cir2.xFounded + " ");
        System.out.println(cir2.yFounded + " ");
        System.out.print(cir2.x1Founded + " ");
        System.out.println(cir2.y1Founded + " ");
    } // проверяет случаи, когда y == y, x == x, ожидаемые значения 3.0 2.0, 2.0 3.0, 0.0 0.0, 5.0 2.0, 2.0 5.0, 0.0 0.0

    @Test
    void calculation1Test(){
        Circle a = new Circle(7, 12, 6);
        Circle b = new Circle(22, 5, 4);
        calculation1(a, b);

        System.out.println(a.xFounded + " " + a.yFounded);
        System.out.println(a.x1Founded + " " + a.y1Founded);

        System.out.println(b.xFounded + " " + b.yFounded);
        System.out.println(b.x1Founded + " " + b.y1Founded);
    }
    @Test
    void calculation2Test(){
//        Circle a = new Circle(1, 1, 1);
//        Circle b = new Circle(5, 4, 1.5);
//        calculation2(a, b);
//        System.out.println(a.toString());
//        System.out.println(b.toString());

        Circle b = new Circle(3, 3, 2);
        Circle a = new Circle(14, 5, 4);
        calculation2(a, b);
        System.out.println(a.toString());
        System.out.println(b.toString());
    }
    @Test
    void raschetTest() {
        check12(circle1, circle2);
        raschet(circle1, circle2);
        System.out.println(Arrays.toString(raschet(circle1, circle2)));
    }
    @Test
    void raschetTest1() {
        raschet(circle1, circle2);
        System.out.println(Arrays.toString(raschet(circle1, circle2)));
    }

    @Test
    void calculation2Test1(){

    }
}
