package com.kodilla.testing.shape;

public   class Triangle implements Shape {

    private double sideA;
    private double height;


    public Triangle(double sideA, double height) {
        this.sideA = sideA;
        this.height = height;

    }

    public double getSideA() {
        return sideA;
    }

    public double getHeight() {
        return height;
    }


    public String getShapeName() {

        return "TRIANGLE";

    }

    public double getField() {

        return sideA * height;

    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Triangle triangle = (Triangle) o;

        if (Double.compare(triangle.sideA, sideA) != 0) return false;
        if (Double.compare(triangle.height, height) != 0) return false;
        return Double.compare(triangle.height, height) == 0;
    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        temp = Double.doubleToLongBits(sideA);
        result = (int) (temp ^ (temp >>> 32));
        temp = Double.doubleToLongBits(height);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        return result;
    }

    @Override
    public String toString() {
        return "TRIANGLE {" +
                " side A = " + sideA +
                ", height = " + height +
                '}';
    }


}