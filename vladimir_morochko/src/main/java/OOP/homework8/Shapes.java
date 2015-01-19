package OOP.homework8;

import java.util.ArrayList;

/**
 * Написать приложение с иерархией фигур (треугольник, круг, квадрат, прямоугольник)
Реализовать методы вычисления периметра, площади, вывода фигуры в консоль (по желанию).
Посчитать общую площадь всех фигур.
 *
 */

public class Shapes {

	public static void main(String[] args) {
		ArrayList<Shape> myList = new ArrayList<Shape>();
		myList.add(new Square(5));
		myList.add(new Rectangle(5, 4));
		myList.add(new Triangle(6, 4, Math.atan(4.0 / 3)));
		myList.add(new Circle(5));

		double sumArea = 0;

		for (Shape myShape : myList) {
			sumArea += myShape.getArea();
			myShape.print();
		}
		System.out.println(String.format("Total area is: %.2f", sumArea));
	}
}

class Square extends Shape {

	public Square() {
		super(0, 0, "Square");
	}

	public Square(double width) {
		super(width, width, "Square");
	}

	@Override
	public double getArea() {
		return getWidth() * getHeight();
	}

	@Override
	public double getPerimiter() {
		return getWidth() * 2 + getHeight() * 2;
	}

	@Override
	public String getView() {
		String myView = "";
		for (int i = 0; i < (int) getHeight(); i++) {
			for (int j = 0; j < (int) getWidth(); j++) {
				if (i == 0 || j == 0 || i == (int) getHeight() - 1
						|| j == (int) getWidth() - 1) {
					myView += "*";
				} else {
					myView += " ";
				}
			}
			myView += "\n";
		}
		return myView;
	}

}

class Rectangle extends Shape {

	public Rectangle() {
		super(0, 0, "Rectangle");
	}

	public Rectangle(double width, double height) {
		super(width, height, "Rectangle");
	}

	@Override
	public double getArea() {
		return getWidth() * getHeight();
	}

	@Override
	public double getPerimiter() {
		return getWidth() * 2 + getHeight() * 2;
	}

	@Override
	public String getView() {
		String myView = "";
		for (int i = 0; i < (int) getHeight(); i++) {
			for (int j = 0; j < (int) getWidth(); j++) {
				if (i == 0 || j == 0 || i == (int) getHeight() - 1
						|| j == (int) getWidth() - 1) {
					myView += "*";
				} else {
					myView += " ";
				}
			}
			myView += "\n";
		}
		return myView;
	}

}

class Triangle extends Shape {
	private double angleA;

	public Triangle() {
		super(0, 0, "Triangle");
	}

	public Triangle(double width, double height, double angleA) {
		super(width, height, "Triangle");
		setAngleA(angleA);
	}

	@Override
	public double getArea() {
		return 0.5 * getWidth() * getHeight();
	}

	@Override
	public double getPerimiter() {
		double WidthA = getHeight() / Math.tan(getAngleA());
		double WidthB = getWidth() - WidthA;
		double SideA = Math.sqrt((WidthA * WidthA + getHeight() * getHeight()));
		double SideB = Math.sqrt((WidthB * WidthB + getHeight() * getHeight()));
		return getWidth() + SideA + SideB;
	}

	@Override
	public String getView() {
		String myView = "";
		for (int i = 0; i < getHeight(); i++) {
			for (int j = 0; j < getWidth(); j++) {
				if (i == (int) getHeight() - 1 || j == 0
						|| i == (int) (j * getHeight() / getWidth())) {
					myView += "*";
				} else {
					myView += " ";
				}
			}
			myView += "\n";
		}
		return myView;
	}

	public double getAngleA() {
		return angleA;
	}

	public void setAngleA(double angleA) {
		this.angleA = angleA;
	}

}

class Circle extends Shape {

	public Circle() {
		super(0, 0, "Circle");
	}

	public Circle(double diameter) {
		super(diameter, diameter, "Circle");
	}

	@Override
	public double getArea() {
		return Math.PI * getWidth() * getHeight() / 4;
	}

	@Override
	public double getPerimiter() {
		return Math.PI * getWidth();
	}

	@Override
	public String getView() {
		String myView = "";
		for (int i = 0; i <= (int) getHeight(); i++) {
			for (int j = 0; j <= (int) getWidth(); j++) {
				if ((i - (int) (getHeight() / 2))
						* (i - (int) (getHeight() / 2))
						+ +(j - (int) (getHeight() / 2))
						* (j - (int) (getHeight() / 2)) == (int) (getHeight()
						* getWidth() / 4)) {
					myView += "*";
				} else {
					myView += " ";
				}
			}
			myView += "\n";
		}
		return myView;
	}

}

abstract class Shape {
	private double height;
	private double width;
	private String name;

	public Shape(double width, double height, String name) {
		setWidth(width);
		setHeight(height);
		setName(name);
	}

	public Shape() {
		setWidth(0);
		setHeight(0);
		setName(null);
	}

	abstract double getArea();

	abstract double getPerimiter();

	abstract String getView();

	public double getHeight() {
		return height;
	}
	
	public void print () {
		System.out.println(String.format(
				"We have: %s, perimeter is: %.2f, area is: %.2f",
				getName(), getPerimiter(),	getArea()));
	}

	public void setHeight(double height) {
		if (height >= 0) {
			this.height = height;
		}
	}

	public double getWidth() {
		return width;
	}

	public void setWidth(double width) {
		if (width >= 0) {
			this.width = width;
		}
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
