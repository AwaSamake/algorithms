/**
 *
 * 3.3 Stack of Plates
 *     Imagine a (literal) stack of plates. if the stack gets to high, it might tipple.
 *     Therefore, in real life, we would likely start a new stack when the previous stack
 *     exceeds some threshold. Implement a data structure SetOfStacks that mimics this.
 *     SetOfStacks should be composed fo several stacks and should create a new stack once
 *     the previous one exceeds capacity. SetOfStacks.push() and SetOfStacks.pop() should
 *     behave identically to a single stack (that is, pop() should return the same values
 *     as it would if there were just a single stack).
 *     FOLLOW UP
 *     Implement a function popAt(int index) which performs a pop operation on a specific
 *     sub-stack.
 *
 */

class SetOfStacks {
    private int capacity;
    private ArrayList<Stack> stacks;

    public SetOfStacks(int capacity) {
        this.capacity = capacity;
        stacks.add(new Stack());
    }


    public void push(int val) {
        Stack last = lastStack();
        if (last.size() >= capacity) {
            stacks.add(new Stack());
            lastStack().push(val);
        } else {
            last.push(val);
        }
    }

    public int pop() {
        Stack last = lastStack();
        if (last.isEmpty()) {
            throw new EmptyStackException();
        }
        int val = (int) last.pop();
        if (last.isEmpty()) {
            stacks.remove(stacks.size() - 1);
        }
        return val;
    }

    public int popAt(int index) {
        if (index >= 0 && index < stacks.size()) {
            int val = (int) stacks.get(index).pop();
            if (stacks.get(index).isEmpty()) {
                stacks.remove(index);
            }
            return val;
        }
        throw new EmptyStackException();
    }

    public Stack lastStack() {
        if (stacks.size() == 0) { return null; }

        return stacks.get(stacks.size() - 1);
    }
}

class Test {
	public static void main(String[] args) {
		
	}
}