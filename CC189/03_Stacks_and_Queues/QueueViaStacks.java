/**
 *
 * 3.4 Queue via Stacks
 *     Implement a MyQueue class which implements a queue using two stacks.
 *
 */
class MyQueue <T> {
    private Stack<T> out;
    private Stack<T> in;

    public MyQueue() {
        out = new Stack<T>();
        in = new Stack<T>();
    }

    public int size() {
        return in.size() + out.size();
    }

    public void enqueue(T val) {
        in.push(val);
    }

    public T dequeue() {
        shift();
        return out.pop();
    }

    public T peek() {
        shift();
        return out.peek();
    }

    private void shift() {
        if (out.isEmpty()) {
            while (!in.isEmpty()) {
                out.push(in.pop());
            }
        }
    }
}

class QueueViaStacks {
	public static void main(String[] args) {
		
	}
}