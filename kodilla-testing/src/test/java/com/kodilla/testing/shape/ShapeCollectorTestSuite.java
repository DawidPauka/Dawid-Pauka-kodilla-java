package com.kodilla.testing.shape;

import org.junit.Assert;
import org.junit.Test;

public class ShapeCollectorTestSuite {

    @Test
    //test sprawdza czy figura została rzeczywiście usunięta z listy//
    public void testRemoveFigure() {

        //Given//
        Shape circle = new Circle(5);

        ShapeCollector collector = new ShapeCollector(circle);

        collector.addFigure(circle);

        //When//
        boolean result = collector.removeFigure(circle);

        //Then//
        Assert.assertTrue(result);

    }

    @Test
    //test sprawdza czy próba usunięcia nieistniejącej figury skończy się zwróceniem wyniku false//
    public void testRemoveFigureNonexistent() {

        //Given//
        Shape circle = new Circle(5);

        ShapeCollector collector = new ShapeCollector(circle);

        //When//
        boolean result = collector.removeFigure(circle);

        //Then//
        Assert.assertFalse(result);

    }

    @Test
    //  Sprawdza czy getter zwraca tę samą figurę, którą dodaliśmy do listy//

    public void testGetFigure() {

        //Given//
        Shape circle = new Circle(100);

        ShapeCollector collector = new ShapeCollector(circle);

        collector.addFigure(circle);

        //When//
        Shape figure;

        figure = collector.getFigure(0);

        //Then//
        Assert.assertEquals(circle, figure);

    }

    @Test
    //  sprawdza czy dodane figury zostaną poprawnie wyświetlone
    // poprzez met. showFigures//

    public void testShowFigures() {

        //Given//
        Shape circle = new Circle(5);

        Shape triangle = new Triangle(5, 10, 15);

        Shape square = new Square(5);

        ShapeCollector collector = new ShapeCollector(circle);

        collector.addFigure(circle);
        collector.addFigure(triangle);
        collector.addFigure(square);

        //When//
        collector.showFigures();

        Shape figure0;
        figure0 = collector.getFigure(0);

        Shape figure1;
        figure1 = collector.getFigure(1);

        Shape figure2;
        figure2 = collector.getFigure(2);


        //Then//
        Assert.assertEquals(circle, figure0);
        Assert.assertEquals(triangle, figure1);
        Assert.assertEquals(square, figure2);

    }

}