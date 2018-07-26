package com.kodilla.testing.shape;

import java.util.ArrayList;
import java.util.List;

public class ShapeCollector {

    private List<Shape> shapes = new ArrayList<>();

    public void addFigure(Shape shape){
        shapes.add(shape);
    }

    public boolean removeFigure(Shape shape) {
        return shapes.remove(shape);
    }

    public Shape getFigure(int n) {
        Shape shape = null;

        if (shapes.size() > n && n >= 0) {
            shape = shapes.get(n);
        }
        return shape;
    }

    public List<Shape> getShapes() {
        return shapes;
    }
}