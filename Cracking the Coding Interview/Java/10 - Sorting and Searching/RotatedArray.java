/**
 *
 * 10.3 Search in Rotated Array
 *     Given a sorted array of n integers that has been rotated an unknown number of times, 
 *     write code to find an element in the array. You may assume that the array was 
 *     originally sorted in increasing order.
 *     EXAMPLE
 *     Input: find 5 in {15, 16, 19, 20, 1, 3, 4 , 5, 7, 10, 14}
 *     Output: 8 (the index of 5 in the array)
 */

class RotatedArray {
	public static int search(int a[], int lower, int uppper, int x) {
		int mid = (lower + uppper) >> 1;
		if (a[mid] == x) {
			return mid;
		}
		if (lower >= uppper) {
			return -1;
		}
		
		if (a[lower] < a[mid]) { // left is normal
			if (a[lower] <= x && x < a[mid]) {
				return search(a, lower, mid - 1, x);
			} else {
				return search(a, mid + 1, uppper, x);
			}
		} else if (a[uppper] > a[mid]) { // right is normal
			if (x <= a[uppper] && a[mid] < x) {
				return search(a, mid + 1, uppper, x);
			} else {
				return search(a, lower, mid - 1, x);
			}
		} else { // left and right are repeated
			int result = search(a, lower, mid - 1, x);
			return (result != -1) ? result : search(a, mid + 1, uppper, x);
		}
	}
	
	public static void main(String[] args) {
		int[] a = new int[] {10, 15, 20, 30, 40, 0, 5};
		
		int result = search(a, 0, a.length - 1, 10);
		System.out.println(result);
	}
}