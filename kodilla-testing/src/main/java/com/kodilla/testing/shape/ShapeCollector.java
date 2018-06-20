package com.kodilla.testing.shape;

import java.util.ArrayList;
import java.util.List;

public class ShapeCollector {

    private List<Shape> shapes = new ArrayList<>();

    private Shape shape;

    public ShapeCollector(Shape shape) {
        this.shape = shape;
    }


    public void addFigure(Shape shape) {

        shapes.add(shape);

    }

    public boolean removeFigure(Shape shape) {

        boolean result = false;
        if(shapes.contains(shape)) {
            shapes.remove(shape);
            result = true;
        }

        return result;

    }

    public Shape getFigure(int n) {

        Shape figure = null;

        if(n >= 0 && n < shapes.size()) {

            figure = shapes.get(n);
        }

        return figure;

    }

    public void showFigures() {

        for(int n=0; n < shapes.size(); n++) {

            Shape obiekt = shapes.get(n);

            System.out.println("Element " + n + " : " + obiekt);
        }

    }
}