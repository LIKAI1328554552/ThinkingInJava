package com.likai.chapter13.practice;

import com.likai.chapter07.practice.C;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by likai on 2018/10/28.
 */
abstract class Shape {
    void draw() {
        System.out.println(this + ".draw()");
    }
    abstract public String toString() ;
}
class Circle extends Shape {

    @Override
    public String toString() {
        return "Circle";
    }
}
class Square extends Shape {

    @Override
    public String toString() {
        return "Square";
    }
}
class Triangle extends Shape {

    @Override
    public String toString() {
        return "Triangle";
    }
}
class Rhomboid extends Shape {

    @Override
    public String toString() {
        return "Rhomboid";
    }
}
public class Shapes {

    public static void rotate(Shape s) {
        if (!(s instanceof Circle)) {
            System.out.println(s + " rotate");
        }
    }
    public static void main(String [] args) {
        List<Shape> list = Arrays.asList(new Circle(),new Square(),new Triangle()) ;
        for (Shape shape : list) {
            shape.draw();
            rotate(shape);
        }
        Shape shape = new Rhomboid() ;
        Rhomboid r = (Rhomboid) shape ;
        r.draw();

        /*Circle c = (Circle) shape ;
        //强制转换异常 Rhomboid cannot be cast to Circle
        c.draw();*/

        if (shape instanceof Circle) {
            Circle c = (Circle) shape ;
            c.draw();
        }
    }
}
