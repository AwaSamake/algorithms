/**
 * Created by Lihao on 1/27/17.
 * Chapter 03 - Stacks and Queues
 */

import java.util.ArrayList;
import java.util.EmptyStackException;
import java.util.Stack;

/**
 *
 * 3.1 Three in One
 *     Describe how you could use a single array to implement three stacks.
 *
 */
class FixedMultiStack {
    private int numberOfStacks = 3;
    private int stackCapacity;
    private int[] stacks;                                // one single array
    private int[] sizes;                                 // size if each stack, not index of each top element

    public FixedMultiStack(int capacity) {
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


/**
 *
 * 3.2 Stack Min
 *     How would you design a stack which, in addition to push and pop, has a function min
 *     which returns the minimum element? Push, pop and min should all operate in O(1) time
 *
 */

class MinStack {
    private Stack stack;
    private Stack mins;

    public MinStack() {
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


/**
 *
 * 3.3 Stack of Plates
 *     Imagine a (literal) stack of plates. if the stack gets to high, it might tipple.
 *     Therefore, in real life, we would likely start a new stack when the previous stack
 *     exceeds some threshold. Implement a data structure SetOfStacks that mimics this.
 *     SetOfStacks should be composed of several stacks and should create a new stack once
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

/**
 *
 * 3.5 Sort Stack
 *     Write a program to sort a stack such that the smallest items are on the top.
 *     You can use an additional temporary stack, but you may not copy the elements into
 *     any other data structure (such as an array). The stack supports the following
 *     operations: push, pop, peak, and isEmpty.
 *
 */


/**
 *
 * 3.6 Animal Shelter
 *     An animal shelter, which holds only dogs and cats, operates on a strictly "first in,
 *      first out". basis. People must adopt either the "oldest"(based on arrival time)
 *      of all animals at the shelter, or the can select whether they should prefer a dog
 *      or a cat (and will receive the oldest animal of that type). They cannot select
 *      which specific animal they would like. Create the data structures to maintain
 *      this system and implement operations such as enqueue, dequeueAny, dequeueDog,
 *      and dequeueCat. You may use the build-in LinkedList data structure.
 *
 */