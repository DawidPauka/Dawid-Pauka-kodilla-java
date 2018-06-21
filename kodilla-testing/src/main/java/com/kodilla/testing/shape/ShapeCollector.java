package com.kodilla.testing.shape;

import java.util.ArrayList;
import java.util.List;

public class ShapeCollector {

    private List<Shape> shapes = new ArrayList<>();


    public void addFigure(Shape shape) {

        shapes.add(shape);

    }

    public boolean removeFigure(Shape shape) {
        if(shapes.contains(shape)) {
            shapes.remove(shape);
            return true;
        }
        return false;

    }

    public Shape getFigure(int n) {

        if(n >= 0 && n < shapes.size()) {
            return shapes.get(n);
        }

        return null;
    }




    public void showFigures() {
        for (Shape shape : shapes) {
            System.out.println("Element : " + shape);
        }

        for(int n=0; n < shapes.size(); n++) {
            System.out.println("Element " + n + " : " + shapes.get(n));
        }

    }
}