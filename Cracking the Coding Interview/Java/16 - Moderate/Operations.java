/**
 *
 * 16.9 Operations
 *     Write methods to implement the multiply, subtract, and divide operations for integers.
 *     The results of all of these are integers. Use only the add operator.
 *
 */

class Operations {
	public static void main(String[] args) {
		System.out.println(negate(10));
		System.out.println(subtract(10, 5));
		System.out.println(multiply(5, 6));
		System.out.println(divide(13, -3));
	}

	/*===================================
	=            Subtraction            =
	===================================*/
	public static int subtract(int o1, int o2) {
		return o1 + negate(o2);
	}
	
	/*======================================
	=            Multiplication            =
	======================================*/
	public static int multiply(int o1, int o2) {
		int a = abs(o1);
		int b = abs(o2);
		
		if (a > b) {
			return multiply(o2, o1);
		}
		
		if (o1 < 0 ^ o2 < 0) {
			a = negate(a);
		}
		
		int product = 0;
		for (int i = b; i > 0; i = subtract(i, 1)) {
			product += a;
		}
		
		return product;
	}
	
	/*================================
	=            Division            =
	================================*/
	public static int divide(int o1, int o2) {
		if (o2 == 0) {
			throw new java.lang.ArithmeticException("Division by Zero");
		}
		int abs1 = abs(o1);
		int abs2 = abs(o2);
		
		int count = 0;
		int product = 0;
		while (product + abs2 <= abs1) {
			count++;
			product += abs2;
		}
		
		if ((o1 < 0 && o2 < 0) || (o1 > 0 && o2 > 0)) {
			return count;
		} else {
			return negate(count);
		}
	}	
		
	/*===============================
	=            Helpers            =
	===============================*/
	public static int abs(int num) {
		if (num < 0) {
			return negate(num);
		}
		return num;
	}
	
	public static int negate(int num) {
		int neg = 0;
		int incrementOrDecrement = (num < 0) ? 1 : -1;
		while (num != 0) {
			num += incrementOrDecrement;
			neg += incrementOrDecrement;
		}
		return neg;
	}

}