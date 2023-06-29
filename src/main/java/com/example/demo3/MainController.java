package com.example.demo3;

import javafx.fxml.FXML;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.paint.Color;

import java.util.ArrayList;
import java.util.Arrays;

import static com.example.demo3.Circle.check12;
import static java.lang.Math.acos;
import static java.lang.Math.sqrt;

public class MainController {
    @FXML
    private Canvas canvas;
    @FXML
    private TextField x1;
    @FXML
    private TextField x2;
    @FXML
    private TextField x3;
    @FXML
    private TextField y1;
    @FXML
    private TextField y2;
    @FXML
    private TextField y3;
    @FXML
    private TextField r1;
    @FXML
    private TextField r2;
    @FXML
    private TextField r3;
    @FXML
    private Label fix;
    GraphicsContext gc;
    private Circle circle1;
    private Circle circle2;
    private Circle circle3;

    @FXML
    private void initialize() {
        gc = canvas.getGraphicsContext2D();
        gc.setLineWidth(1);
        razmetka();
        gc.beginPath();
        gc.setStroke(Color.BLACK);
//        gc.moveTo(40, 360);
//        gc.lineTo (70, 330);
//        gc.lineTo(70, 210);
//        gc.stroke();
//
//        gc.moveTo(130, 210);
//        gc.fillOval(70, 120, 40, 40);
//
//        gc.strokeOval(70, 180, 40, 40);

    } // первичная инициализация

    private void razmetka() {
        gc.beginPath();
        gc.moveTo(40, 0);
        gc.lineTo(40, 360);
        gc.lineTo(600, 360);
        gc.stroke();
        int k = 0;
        int l = 1;
        for (int i = 40; i < 600; i = i + 30) {
            gc.fillText(String.valueOf(k), i, 380);
            k++;
        }
        for (int i = 70; i < 400; i = i + 30) {
            gc.fillText(String.valueOf(l), 20, 400 - i);
            l++;
        } // 0 0 находится в точке 40 360
        for (int i = 40; i < 600; i = i + 30) {
//            gc.fillOval(i, 360, 0, 0);
            gc.strokeOval(i, 360, 1, 1);
        }
        for (int i = 330; i > 0; i = i - 30) {
//            gc.fillOval(i, 360, 0, 0);
            gc.strokeOval(40, i, 1, 1);
        }
    } // ресуем разметку

    @FXML
    private void pressButton() {
        try {
            circle1 = new Circle(Integer.parseInt(x1.getText()), Integer.parseInt(y1.getText()), Integer.parseInt(r1.getText()));
            circle2 = new Circle(Integer.parseInt(x2.getText()), Integer.parseInt(y2.getText()), Integer.parseInt(r2.getText()));
            circle3 = new Circle(Integer.parseInt(x3.getText()), Integer.parseInt(y3.getText()), Integer.parseInt(r3.getText()));
            ovalRis(circle1);
            ovalRis(circle2);
            ovalRis(circle3);
            gc.setLineWidth(1);
            gc.stroke();
            lines();
            check12(circle1, circle2);
            check12(circle2, circle3);
            check12(circle1, circle3);
            obvodka();
//            proverka();
        } catch (NumberFormatException ex) {
            fix.setText("Какие-то значения не являются цифрой");
            System.out.println("+");
        } catch (Exception ex) {
            fix.setText("Что-то не то,\nпроверь значения");
            System.out.println(Arrays.toString(ex.getStackTrace()));
        }
    } // нажатие кнопки

    private void ovalRis(Circle circle) {
        gc.strokeOval(circle.getX1forCanvas(), circle.getY1forCanvas(), toCanvasR(circle.getR()) * 2, toCanvasR(circle.getR()) * 2);
        gc.strokeOval(toCanvasX(circle.getX()), toCanvasY(circle.getY()), 1, 1);
    }

    private void lines() {
        gc.setLineWidth(1);
        gc.moveTo(toCanvasX(circle1.getX()), toCanvasY(circle1.getY()));
        gc.lineTo(toCanvasX(circle2.getX()), toCanvasY(circle2.getY()));
        gc.lineTo(toCanvasX(circle3.getX()), toCanvasY(circle3.getY()));
        gc.lineTo(toCanvasX(circle1.getX()), toCanvasY(circle1.getY()));
        gc.stroke();
    }

    @FXML
    private void cleans() {
        gc.clearRect(0, 0, 601, 401);
        initialize();
    } // очистка

    private void obvodka() {
        gc.closePath();
        gc.beginPath();
        gc.setLineWidth(5);
        // обводка кругов
        double acos1 = acos(angle_point(circle1));
        double acos2 = acos(angle_point(circle2));
        double acos3 = acos(angle_point(circle3));
        gc.arc(toCanvasX(circle1.getX()), toCanvasY(circle1.getY()), toCanvasR(circle1.getR()), toCanvasR(circle1.getR()), opredelenieGr(circle1), 360 - Math.toDegrees(acos1));
        gc.stroke();
        gc.closePath();
        gc.beginPath();

        gc.arc(toCanvasX(circle2.getX()), toCanvasY(circle2.getY()), toCanvasR(circle2.getR()), toCanvasR(circle2.getR()), opredelenieGr(circle2), 360 - Math.toDegrees(acos2));
        gc.stroke();
        gc.closePath();
        gc.beginPath();

        gc.arc(toCanvasX(circle3.getX()), toCanvasY(circle3.getY()), toCanvasR(circle3.getR()), toCanvasR(circle3.getR()), opredelenieGr(circle3), 360 - Math.toDegrees(acos3));
        gc.stroke();
        gc.closePath();
        gc.beginPath();
        // обводка линий
        double[] result1 = raschet(circle1, circle2);
        raschet1(circle1, circle2, result1[0], result1[1]);
        double[] result2 = raschet(circle2, circle3);
        raschet1(circle2, circle3, result2[0], result2[1]);
        double[] result3 = raschet(circle3, circle1);
        raschet1(circle3, circle1, result3[0], result3[1]);
    }

    private double toCanvasX(double x) {
        return Math.round(x * 30 + 40);
    }

    private double toCanvasY(double y) {
        return Math.round(360 - (y) * 30);
    }

    private double toCanvasR(double r) {
        return Math.round(r * 30);
    }

    public static double[] raschet(Circle circle1, Circle circle2) {
        double[] result = new double[2];
        double res1Fin = sqrt(((circle2.xFounded - circle1.xFounded) * (circle2.xFounded - circle1.xFounded)) + ((circle2.yFounded - circle1.yFounded) * (circle2.yFounded - circle1.yFounded)));
        double res2Fin = sqrt(((circle2.xFounded - circle1.x1Founded) * (circle2.xFounded - circle1.x1Founded)) + ((circle2.yFounded - circle1.y1Founded) * (circle2.yFounded - circle1.y1Founded)));
        double res3Fin = sqrt(((circle2.x1Founded - circle1.xFounded) * (circle2.x1Founded - circle1.xFounded)) + ((circle2.y1Founded - circle1.yFounded) * (circle2.y1Founded - circle1.yFounded)));
        double res4Fin = sqrt(((circle2.x1Founded - circle1.x1Founded) * (circle2.x1Founded - circle1.x1Founded)) + ((circle2.y1Founded - circle1.y1Founded) * (circle2.y1Founded - circle1.y1Founded)));
        if ((res1Fin < res2Fin) && (res1Fin < res3Fin) && (res1Fin < res4Fin)) { // result1 самый маленький
            result[0] = 0;
            result[1] = 0;
            return result;
        } else if (res2Fin < res1Fin && res2Fin < res3Fin && res2Fin < res4Fin) {
            result[0] = 0;
            result[1] = 1;
            return result;
        } else if (res3Fin < res1Fin && res3Fin < res2Fin && res3Fin < res4Fin) {
            result[0] = 1;
            result[1] = 0;
            return result;
        } else {
            result[0] = 1;
            result[1] = 1;
            return result;
        }
    }

    private void raschet1(Circle circle1, Circle circle2, double a, double b) {
        if (a == 0 && b == 0) {
            gc.moveTo(toCanvasX(circle1.xFounded), toCanvasY(circle1.yFounded));
            gc.lineTo(toCanvasX(circle2.xFounded), toCanvasY(circle2.yFounded));
        } else if (a == 0 && b == 1) {
            gc.moveTo(toCanvasX(circle1.x1Founded), toCanvasY(circle1.y1Founded));
            gc.lineTo(toCanvasX(circle2.xFounded), toCanvasY(circle2.yFounded));
        } else if (a == 1 && b == 0) {
            gc.moveTo(toCanvasX(circle1.xFounded), toCanvasY(circle1.yFounded));
            gc.lineTo(toCanvasX(circle2.x1Founded), toCanvasY(circle2.y1Founded));
        } else {
            gc.moveTo(toCanvasX(circle1.x1Founded), toCanvasY(circle1.y1Founded));
            gc.lineTo(toCanvasX(circle2.x1Founded), toCanvasY(circle2.y1Founded));
        }
        gc.stroke();
        gc.closePath();
    }

    double angle_point(Circle circle1) {
        double x1 = circle1.xFounded - circle1.getX(), x2 = circle1.x1Founded - circle1.getX();
        double y1 = circle1.yFounded - circle1.getY(), y2 = circle1.y1Founded - circle1.getY();
        double d1 = sqrt(x1 * x1 + y1 * y1);
        double d2 = sqrt(x2 * x2 + y2 * y2);
        return (x1 * x2 + y1 * y2) / (d1 * d2);
        // a - это x y F
        // b - это центр
        // c - это x1 y1 F
    }
    double opredelenieGr(Circle circle) {
        double tochka0X = circle.getX() + circle.getR();
        double tochka0Y = circle.getY();
        double x1 = circle.xFounded - circle.getX(), x2 = tochka0X - circle.getX();
        double y1 = circle.yFounded - circle.getY(), y2 = tochka0Y - circle.getY();
        double d1 = sqrt(x1 * x1 + y1 * y1);
        double d2 = sqrt(x2 * x2 + y2 * y2);
        double gradFounded = Math.toDegrees(acos((x1 * x2 + y1 * y2) / (d1 * d2)));
        double x11 = circle.x1Founded - circle.getX(), x21 = tochka0X - circle.getX();
        double y11 = circle.y1Founded - circle.getY(), y21 = tochka0Y - circle.getY();
        double d11 = sqrt(x11 * x11 + y11 * y11);
        double d21 = sqrt(x21 * x21 + y21 * y21);
        double grad1Founded = Math.toDegrees(acos((x11 * x21 + y11 * y21) / (d11 * d21)));
        if (circle.yFounded <= circle.getY() && circle.y1Founded <= circle.getY()){
            gradFounded = 360 - gradFounded;
            grad1Founded = 360 - grad1Founded;
            if(gradFounded > grad1Founded){
                return  gradFounded;
            } else return  grad1Founded;
        } // если xy и xy1 ниже центра по У
        else if (circle.yFounded > circle.getY() && circle.y1Founded > circle.getY()) {
            if(gradFounded > grad1Founded){
                return  gradFounded;
            } else return  grad1Founded;
        }
        else if (circle.yFounded <= circle.getY() && circle.y1Founded > circle.getY()){
            if(gradFounded > grad1Founded){
                return  360 - gradFounded;
            } else return  grad1Founded;
        } else {
            if(gradFounded > grad1Founded){
                return  gradFounded;
            } else return 360 - grad1Founded;
        }
    }
}