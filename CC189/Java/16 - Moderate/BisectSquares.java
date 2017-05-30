/**
 *
 * 16.13 Bisect Squares
 *     Given two square on a two-dimensional plane, find a line that would cut these two
 *     squares in half. Assume that the top and the bottom sides of the square run 
 *     parallel to the x-axis.
 *
 */
import java.util.*;

class MyPoint extends Object {
	public double x;
	public double y;
	
	public MyPoint(double x, double y) {
		this.x = x;
		this.y = y;
	}
	
	public String toString() {
		return "(" + x + ", " + y + ")";
	}
	
	public double getSlope(MyPoint other) {
		return (other.y - this.y) / (other.x - this.x);
	}
}

class Square extends Object {
	public MyPoint[] points;
	
	public Square(MyPoint bottomLeft, double width) {
		points = new MyPoint[4];
		points[0] = new MyPoint(bottomLeft.x         , bottomLeft.y);         // bottom left
		points[1] = new MyPoint(bottomLeft.x         , bottomLeft.y + width); // top left
		points[2] = new MyPoint(bottomLeft.x + width , bottomLeft.y + width); // top right
		points[3] = new MyPoint(bottomLeft.x + width , bottomLeft.y);         // bottom right
	}
	
	public String toString() {
		return "[" + points[0] + ", " + points[1] + ", " + points[2] + ", " + points[3] + "]";
	}
	
	public MyPoint getCenter() {
		double x = (points[3].x + points[0].x) / 2;
		double y = (points[1].y + points[0].y) / 2;
		return new MyPoint(x, y);
	}
}

class BisectSquares {
	public static MyPoint[] getCuttingLine(Square square1, Square square2) {
		MyPoint[] line = new MyPoint[2];
		MyPoint center1 = square1.getCenter();
		MyPoint center2 = square2.getCenter();
		double slope = center1.getSlope(center2);
		
//		System.out.println("Slope:" + slope);
		double b = center1.y - slope * center1.x;
//		System.out.println("Line: y = " + slope + "x + " + b);
		
		double left = Math.min(square1.points[0].x, square2.points[0].x);
		double right = Math.max(square1.points[0].x, square2.points[0].x);
		
		line[0] = new MyPoint(left, getY(left, slope, b));
		line[1] = new MyPoint(right, getY(right, slope, b));
		
		return line;
	}
	
	public static double getY(double x, double slope, double b) {
		return slope * x + b;
	}
	
	public static void main(String[] args) {
		Square square1 = new Square(new MyPoint(10, 10), 5);
		Square square2 = new Square(new MyPoint( 2,  7), 5);
		
		MyPoint[] line = getCuttingLine(square1, square2);
		System.out.println("Line from " + line[0] + " to " + line[1] + " will cut two squares into half.");

	}
}