package com.qa.solid;

public class Rectangle implements Shape {
    private double length;
    private double width;

    public double getLength() {
        return length;
    }

    public void setLength(double length) {
        this.length = length;
    }

    public double getWidth() {
        return width;
    }

    public void setWidth(double width) {
        this.width = width;
    }

	@Override
	public double calculateArea() {
		// TODO Auto-generated method stub
		return length * width;
	}
}
