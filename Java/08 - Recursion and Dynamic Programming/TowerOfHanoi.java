/**
 *
 * 8.6 Towers of Hanoi
 *     In the classic problem of the Towers of Hanoi, you have 3 towers and N disks of
 *     Different size which can slide onto any tower. The puzzle starts with disks sorted
 *     in ascending order of size from top to bottom (i.e., each disk sites on top of an 
 *     even larger one). You have the following constraints:
 *     (1) Only one disk can be moved at a time.
 *     (2) A disk is slid off the top of one tower onto another tower.
 *     (3) A disk cannot be placed on top of a smaller disk.
 *     Write a program to move the disks from the first tower to the last using Stacks.
 *
 */
import java.util.*;


class TowerOfHanoi {
	private static int moveCounter = 0;
	public static void run(Stack<Integer> A, Stack<Integer> B, Stack<Integer> C) {
		while (!(A.isEmpty() && B.isEmpty())) {
			// A B
			makeMove(A, B);			
			// A C
			makeMove(A, C);
			// B C
			makeMove(B, C);
		}
	}
	
	public static void makeMove(Stack<Integer> X, Stack<Integer> Y) {
		if (X.isEmpty() && Y.isEmpty()) {
			return;
		} else if (X.isEmpty()) {
			X.push(Y.pop());
			++moveCounter;
		} else if (Y.isEmpty()) {
			Y.push(X.pop());
			++moveCounter;
		} else {
			if (X.peek() < Y.peek()) {
				Y.push(X.pop());
				++moveCounter;
			} else {
				X.push(Y.pop());
				++moveCounter;
			}
		}
	}
	
	public static void main(String[] args) {
		Stack<Integer> source = new Stack<Integer>();
		Stack<Integer> spare = new Stack<Integer>();
		Stack<Integer> dest = new Stack<Integer>();
		
		source.push(5);
		source.push(4);
		source.push(3);
		source.push(2);
		source.push(1);

		run(source, spare, dest);

		while (!dest.isEmpty()) {
			System.out.println(dest.pop());
		}
		System.out.println("Total number of move:" + moveCounter);

	}
}