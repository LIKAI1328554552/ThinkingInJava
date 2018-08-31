package com.likai.chapter07.practice;

import com.sun.org.apache.xml.internal.serialize.LineSeparator;

/**
 * Created by likai on 2018/08/12.
 */
class Shape{
    public Shape(int i) {
        System.out.println("Shape构造器");
    }

    public void dispose() {
        System.out.println("Shape dispose");
    }

}

class Circle extends Shape {
    public Circle(int i) {
        super(i) ;
        System.out.println("Drawing Circle");
    }

    public void dispose() {
        System.out.println("Erasing Circle");
        super.dispose();
    }
}

class Triangle extends Shape {
    public Triangle(int i) {
        super(i);
        System.out.println("Drawing Triangle");
    }

    public void dispose() {
        System.out.println("Erasing Triangle");
        super.dispose();
    }
}

class Line extends Shape {
    private int start ;
    private int end ;
    public Line(int start,int end) {
        super(start);
        this.start = start ;
        this.end = end ;
        System.out.println("Drawing Line: " + this.start + ", " + this.end);
    }

    public void dispose() {
        System.out.println("Erasing Line: " + this.start + ", " + this.end);
        super.dispose();
    }
}

public class CADSystem extends Shape {
    private Circle circle ;
    private Triangle triangle ;
    private Line [] lines = new Line[3] ;
    public CADSystem(int i) {
        super(i + 1);
        for(int j = 0 ; j < lines.length; j ++) {
            lines[j] = new Line(j,j * j) ;
        }
        circle = new Circle(1) ;
        triangle = new Triangle(1) ;
        System.out.println("Combined构造器");
    }

    public void dispose() {
        System.out.println("CADSystem dispose");
        triangle.dispose();
        circle.dispose();
        for (Line line : lines) {
            line.dispose();
        }
        super.dispose();
    }
    public static void main(String [] args) {
        CADSystem cadSystem = null ;
        try {
            cadSystem = new CADSystem(47) ;
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            cadSystem.dispose();
        }
    }
}
