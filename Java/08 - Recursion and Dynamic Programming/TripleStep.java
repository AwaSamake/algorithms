/**
 *
 * 8.1 Triple Step
 *     A child is running up a staircase with n steps and can hop either 1 step, 2 steps,
 *     or 3 steps at a time. Implement a method to count how many method to count how many 
 *     possible ways the child can run up the stairs.
 *
 */
class TripleStep {
	/**
	 * Recursion, Brute Force
	 */
	public static int waysToGo(int steps) {
		if (steps < 0) {
			return 0;
		}
		if (steps == 0) {
			return 1;
		}

		return waysToGo(steps - 1) + waysToGo(steps - 2) + waysToGo(steps - 3);
	}
	
	
	public static void main(String[] args) {
		System.out.println(waysToGo(6));
	}
}