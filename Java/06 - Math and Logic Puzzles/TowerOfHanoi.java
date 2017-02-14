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