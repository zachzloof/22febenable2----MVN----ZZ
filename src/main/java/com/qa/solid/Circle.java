package com.qa.solid;

public class Circle implements Shape{
    private double radius;

    public double getRadius() {
        return radius;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }

	@Override
	public double calculateArea() {
		// TODO Auto-generated method stub
		return radius * radius * Math.PI;
	}
    
}
