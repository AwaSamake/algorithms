/**
 *
 * 3.5 Sort Stack
 *     Write a program to sort a stack such that the smallest items are on the top.
 *     You can use an additional temporary stack, but you may not copy the elements into
 *     any other data structure (such as an array). The stack supports the following
 *     operations: push, pop, peak, and isEmpty.
 *
 */
class SortStack {
    public void sort(Stack<Integer> s1) {
        Stack<Integer> s2 = new Stack<Integer>();

        while (!s1.isEmpty()) {
            int temp = s1.pop();
            while (!s2.isEmpty() && s2.peek() > temp) {
                s1.push(s2.pop());
            }
            s2.push(temp);
        }

        while (!s2.isEmpty()) {
            s1.push(s2.pop());
        }
    }
    
	public static void main(String[] args) {
		
	}
}