package com.kodilla.testing.shape;

public class Triangle implements Shape {

    double sideA;
    double sideB;
    double sideC;

    public Triangle(double sideA, double sideB, double sideC) {
        this.sideA = sideA;
        this.sideB = sideB;
        this.sideC = sideC;
    }

    public double getSideA() {
        return sideA;
    }

    public double getSideB() {
        return sideB;
    }

    public double getSideC() {
        return sideC;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Triangle triangle = (Triangle) o;

        if (Double.compare(triangle.sideA, sideA) != 0) return false;
        if (Double.compare(triangle.sideB, sideB) != 0) return false;
        return Double.compare(triangle.sideC, sideC) == 0;
    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        temp = Double.doubleToLongBits(sideA);
        result = (int) (temp ^ (temp >>> 32));
        temp = Double.doubleToLongBits(sideB);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        temp = Double.doubleToLongBits(sideC);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        return result;
    }

    @Override
    public String toString() {
        return "TRIANGLE {" +
                " side A = " + sideA +
                ", side B = " + sideB +
                ", side C = " + sideC +
                '}';
    }

    public String getShapeName() {

        return "TRIANGLE";

    }

    public double getField() {

        return sideA * sideB * 0.5;

    }
}