/**
 *
 * 16.1 Number Swapper
 *     Write a function to swap a number on place (that is, without temporary variables).
 *
 */

class NumberSwapper {
	public static void main(String[] args) {
		int a = 10, b = 15;
		
		System.out.println("a:" + a + ", b:" + b);
		
		// swap method 1:
		a = a + b;
		b = a - b;
		a = a - b;
		System.out.println("a:" + a + ", b:" + b);
		
		// swap method 2:
		a = a - b;
		b = a + b;
		a = b - a;
		System.out.println("a:" + a + ", b:" + b);
	}
}