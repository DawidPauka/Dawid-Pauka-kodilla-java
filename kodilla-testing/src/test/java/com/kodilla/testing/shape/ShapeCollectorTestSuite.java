package com.kodilla.testing.shape;

import org.junit.*;

public class ShapeCollectorTestSuite {

    private static int testCounter = 0;

    @BeforeClass
    public static void beforeAllTests() {
        System.out.println("This is the beginning of tests.");
    }

    @AfterClass
    public static void afterAllTests() {
        System.out.println("All tests are finished.");
    }

    @Before
    public void beforeEveryTest() {
        testCounter++;
        System.out.println("Preparing to execute test #" + testCounter);
    }
    @Test
    public void testAddFigure() {
        //Given
        ShapeCollector shapeCollector = new ShapeCollector();
        Shape shape1 = new Circle(3);
        Shape shape2 = new Triangle(3, 4);
        Shape shape3 = new Square(4);

        //When
        shapeCollector.addFigure(shape1);
        shapeCollector.addFigure(shape2);
        shapeCollector.addFigure(shape3);

        //Then
        Assert.assertEquals(3, shapeCollector.getShapes().size());
    }

    @Test
    public void testRemoveFigure() {
        //Given
        ShapeCollector shapeCollector = new ShapeCollector();
        Shape shape1 = new Circle(3);
        Shape shape2 = new Triangle(3, 4);
        Shape shape3 = new Square(4);
        shapeCollector.addFigure(shape1);
        shapeCollector.addFigure(shape2);
        shapeCollector.addFigure(shape3);

        //When
        shapeCollector.removeFigure(shape3);
        shapeCollector.removeFigure(shape2);
        shapeCollector.removeFigure(shape1);

        //Then
        Assert.assertEquals(0, shapeCollector.getShapes().size());

    }

    @Test
    public void testGetFigure() {
        //Given
        ShapeCollector shapeCollector = new ShapeCollector();

        shapeCollector.addFigure(new Circle(3));
        shapeCollector.addFigure(new Triangle(3, 4));
        shapeCollector.addFigure(new Square(4));

        //When
        Shape circle = shapeCollector.getFigure(0);
        Shape triangle = shapeCollector.getFigure(1);
        Shape square = shapeCollector.getFigure(2);

        //Then
        Assert.assertEquals(new Circle(3), circle);
        Assert.assertEquals(new Triangle(3, 4), triangle);
        Assert.assertEquals(new Square(4), square);
        Assert.assertEquals(null, shapeCollector.getFigure(3));
        Assert.assertEquals(null, shapeCollector.getFigure(-1));
    }

}