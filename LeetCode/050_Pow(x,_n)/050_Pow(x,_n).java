/**
 *
 *  050. Pow(x, n) 
 *    Implement pow(x, n).
 *    
 */
import java.util.*;

public class Solution {
	public double myPow(double x, int n) {
		if (n == 0 || x == 1) {
			return 1;
		}
		if (n < 0) {
			if (n == Integer.MIN_VALUE) {
				n = (-(n + 1)) - 1;
			} else {
				n = -n;
			}
			x = 1 / x;
		}
		double result1 = 1, result2 = x;
		while (n > 1) {
		    while(n % 2 == 0) {
		        result2 *= result2;
		        n /= 2;
		    }
		    if (n > 1) {
		        result1 *= result2;
		        --n;
		    }
		}
		return result2 * result1;
	}
}