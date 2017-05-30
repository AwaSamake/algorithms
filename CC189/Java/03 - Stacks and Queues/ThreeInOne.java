/**
 *
 * 3.1 Three in One
 *     Describe how you could use a single array to implement three stacks.
 *
 */

class ThreeInOne {
    private int numberOfStacks = 3;
    private int stackCapacity;
    private int[] stacks;                                // one single array
    private int[] sizes;                                 // size if each stack, not index of each top element

    public ThreeInOne(int capacity) {
        stackCapacity = capacity;
        stacks = new int[stackCapacity * numberOfStacks];
        sizes = new int[numberOfStacks];
    }

    public boolean push(int index, int value) {
        if (isFull(index)) { return false; }

        sizes[index]++;                                  // increment size first
        stacks[getPos(index)] = value;                   // then push to top
        return true;
    }

    public int pop(int index) {
        if (isEmpty(index)) { throw new EmptyStackException(); }

        int position = getPos(index);
        int val = stacks[position];                      // get value first
        stacks[position] = 0;                            // clear the element
        sizes[index]--;                                  // then decrement
        return val;
    }

    public int peek(int index) {
        if (isEmpty(index)) { throw new EmptyStackException(); }

        return stacks[getPos(index)];
    }

    private boolean isEmpty(int index) {
        return sizes[index] == 0;
    }

    private boolean isFull(int index) {
        return sizes[index] == stackCapacity;
    }

    private int getPos(int index) {
        return index * stackCapacity + sizes[index] - 1; // position is (size - 1)
    }
}

class Test {
	public static void main(String[] args) {
		
	}
}