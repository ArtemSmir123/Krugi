package com.example.demo3;

public class Circle {
    private double x;
    private double y;
    private double r;

//    private double sinA;
    public double xFounded;
    public double yFounded;
    public double x1Founded;
    public double y1Founded;
    private boolean changedFounded = false;
    private boolean changed1Founded = false;
    Circle(double x, double y, double r){
        this.r = r;
        this.x = x;
        this.y = y;
    }
    public double getX1forCanvas() {
        return (x - r) * 30 + 40;
    }
    public double getY1forCanvas() {
        return 360 - (y + r) * 30;
    }
    public double getX() {
        return x;
    }
    public double getY() {
        return y;
    }
    public double getR() {
        return r;
    }

    public static void check12(Circle circle1, Circle circle2){
        if(circle1.x < circle2.x) {
            stack12(circle1, circle2);
        }
        else if (circle1.x == circle2.x){
            if(circle1.y > circle2.y){
                calculation4(circle1, circle2);
            }
            else {
                calculation4(circle2, circle1);
            }
        }
        else {
            stack12(circle2, circle1);
        }
    }
    public static void stack12(Circle circle1, Circle circle2){
        if (circle1.y < circle2.y){
            calculation1(circle1, circle2);
        } else if (circle1.y == circle2.y) {
            calculation3(circle1, circle2);
        } else {
            calculation2(circle1, circle2);
        }
    }
    public static void calculation1(Circle circle1, Circle circle2){
        double AP = circle1.y - circle2.y; // длина AP
        double BP = circle2.x - circle1.x;; // длина BP
        double AB = Math.sqrt(AP * AP + BP * BP); // длина AB
        double cosA = AP / AB; // косинус угла A
        double AS = circle1.r; // длина AS
        double AK = AS * cosA; // длина AK
        double sinA = BP / AB; // синус угла А
        double KS = AS * sinA;
        if (!circle1.changedFounded) {
            circle1.xFounded = circle1.x + KS;
            circle1.yFounded = circle1.y - AK;
            circle1.changedFounded = true;
        } else {
            circle1.x1Founded = circle1.x + KS;
            circle1.y1Founded = circle1.y - AK;
            circle1.changed1Founded = true;
        } // запись значения для circle1

        double cosB = BP / AB; // косинус угла В
        double BM = circle2.r; // длина BM
        double BN = BM * cosB; // длина BN
        double sinB = AP / AB; // косинус угла В
        double MN = BM * sinB; // длина MN
        if (!circle2.changedFounded) {
            circle2.xFounded = circle2.x - BN;
            circle2.yFounded = circle2.y + MN;
            circle2.changedFounded = true;
        } else {
            circle2.x1Founded = circle2.x - BN;
            circle2.y1Founded = circle2.y + MN;
            circle2.changed1Founded = true;
        } // запись значения для circle2
    } // для circle1.у1 > circle2.у1
    public static void calculation2(Circle circle1, Circle circle2){
        double AC = circle2.x - circle1.x;
        double BC = circle2.y - circle1.y;
        double AB = Math.sqrt(AC * AC + BC * BC);
        double sinA = BC / AB;
        double AK = circle1.r;
        double KS = AK * sinA;
        double cosA = AC / AB;
        double AS = AK * cosA;

        if (!circle1.changedFounded) {
            circle1.xFounded = circle1.x + AS;
            circle1.yFounded = circle1.y + KS;
            circle1.changedFounded = true;
        } else {
            circle1.x1Founded = circle1.x + AS;
            circle1.y1Founded = circle1.y + KS;
            circle1.changed1Founded = true;
        } // запись значения для circle1

        double sinB = AC / AB;
        double MB = circle2.r;
        double MN = MB * sinB;
        double cosB = BC / AB;
        double BN = MB * cosB;

        if (!circle2.changedFounded) {
            circle2.xFounded = circle2.x - MN;
            circle2.yFounded = circle2.y - BN;
            circle2.changedFounded = true;
        } else {
            circle2.x1Founded = circle2.x - MN;
            circle2.y1Founded = circle2.y - BN;
            circle2.changed1Founded = true;
        } // запись значения для circle1
    } // для circle1.у1 < circle2.у1
    public static void calculation3(Circle circle1, Circle circle2){
        if (!circle1.changedFounded) {
            circle1.xFounded = circle1.x + circle1.r;
            circle1.yFounded = circle1.y;
            circle1.changedFounded = true;
        } else {
            circle1.x1Founded = circle1.x + circle1.r;
            circle1.y1Founded = circle1.y;
            circle1.changed1Founded = true;
        }
        if (!circle2.changed1Founded){
            circle2.x1Founded = circle2.x - circle2.r;
            circle2.y1Founded = circle2.y;
            circle2.changed1Founded = true;
        } else {
            circle2.xFounded = circle2.x - circle2.r;
            circle2.yFounded = circle2.y;
            circle2.changedFounded = true;
        }
    } // для circle1.у1 == circle2.у1
    public static void calculation4(Circle circle1, Circle circle2){
        if (!circle1.changedFounded) {
            circle1.xFounded = circle1.x;
            circle1.yFounded = circle1.y - circle1.r;
            circle1.changedFounded = true;
        } else {
            circle1.x1Founded = circle1.x;
            circle1.y1Founded = circle1.y - circle1.r;
            circle1.changed1Founded = true;
        }
        if (!circle2.changed1Founded) {
            circle2.x1Founded = circle2.x;
            circle2.y1Founded = circle2.y + circle2.r;
            circle2.changed1Founded = true;
        } else {
            circle2.xFounded = circle2.x;
            circle2.yFounded = circle2.y + circle2.r;
            circle2.changedFounded = true;
        }
    } // для circle1.x1 == circle2.x1

    public static boolean pointСheckY(Circle circle) throws MyNewException {
        if(circle.x - circle.r == 0 || circle.y - circle.r == 0){
            throw new MyNewException("Система описала, что результат не достоверен, т.к. одно из получаемых значений == 0");
        }
        boolean b1 = (circle.getX() + circle.getR() == circle.xFounded || circle.getX() + circle.getR() == circle.x1Founded)
                        && (circle.getY() == circle.yFounded || circle.getY() == circle.y1Founded);
        boolean b2 = (circle.getX() - circle.getR() == circle.xFounded || circle.getX() - circle.getR() == circle.x1Founded)
                        && (circle.getY() == circle.yFounded || circle.getY() == circle.y1Founded);
        return b1 || b2;
    } //проверка на корректность точек для y == y
    public static boolean pointСheckX(Circle circle) throws MyNewException {
        if(circle.x - circle.r == 0 || circle.y - circle.r == 0){
            throw new MyNewException("Система описала, что результат не достоверен, т.к. одно из получаемых значений == 0");
        }
        boolean b1 = (circle.getY() + circle.getR() == circle.yFounded || circle.getY() + circle.getR() == circle.y1Founded)
                && (circle.getX() == circle.xFounded || circle.getX() == circle.x1Founded);
        boolean b2 = (circle.getY() - circle.getR() == circle.yFounded || circle.getY() - circle.getR() == circle.y1Founded)
                && (circle.getX() == circle.xFounded || circle.getX() == circle.x1Founded);
        return b1 || b2;
    } //проверка на корректность точек для x == x
    @Override
    public String toString(){
        return "X: " + this.x + " Y: " + this.y + " R: " + this.r + "\nxF: " + this.xFounded + "yF: " + this.yFounded + "\nx1F: " + this.x1Founded +"y1F: " + this.y1Founded;
    }
}
