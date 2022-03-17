
package com.qa.solid;

public class Runner {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Circle circle = new Circle();
		circle.setRadius(15);
		Rectangle rectangle = new Rectangle();
		rectangle.setLength(25);
		rectangle.setWidth(125);
		AreaCalculator AC = new AreaCalculator();
		System.out.println(AC.calculateShapeArea(rectangle));

	}

}
