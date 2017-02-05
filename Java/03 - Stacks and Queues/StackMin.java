/**
 *
 * 3.2 Stack Min
 *     How would you design a stack which, in addition to push and pop, has a function min
 *     which returns the minimum element? Push, pop and min should all operate in O(1) time
 *
 */
class StackMin {
    private Stack stack;
    private Stack mins;

    public StackMin() {
        stack = new Stack();
        mins = new Stack();
        mins.push(Integer.MAX_VALUE);
    }

    public void push(int value) {
        stack.push(value);
        if (value <= (int) mins.peek()) {
            mins.push(value);
        }
    }

    public int pop() {
        int val = (int) stack.pop();
        if ((int) mins.peek() == val) {
            mins.pop();
        }
        return val;
    }

    public int min() {
        return (int) mins.peek();
    }
}

class Test {
    public static void main(String[] args) {
        
    }
}
