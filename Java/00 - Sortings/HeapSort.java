/**
 *
 * 0.4 Heap Sort
 *     Time: O(N Log(N))
 *     Space: O(1)
 *     Runtime: 200ms
 *
 */
import java.util.Random;
import java.util.Arrays;

class HeapSort {
    public static void sort(int[] numbers) {
        final int SIZE = numbers.length;
        for (int i = 1; i < SIZE; ++i) {
            int parentIndex = parentOf(i), childIndex = i;
            while (parentIndex != -1 && numbers[parentIndex] < numbers[childIndex]) {
                swap(numbers, parentIndex, childIndex);
                childIndex = parentIndex;
                parentIndex = parentOf(parentIndex);
            }
        }
        
        int parentIndex, leftChild, rightChild, swapIndex;
        for (int i = SIZE - 1; i > -1; --i) {
            swap(numbers, i, 0);            
            parentIndex = 0;
            leftChild = leftChild(0);
            rightChild = rightChild(0);
            swapIndex = 0;
            while (true) {
                if (leftChild < i && rightChild < i 
                    && (numbers[parentIndex] < numbers[leftChild] 
                        || numbers[parentIndex] < numbers[rightChild])) {
                    if (numbers[leftChild] < numbers[rightChild]) {
                        swapIndex = rightChild;
                    } else {
                        swapIndex = leftChild;
                    }
                } else if (leftChild < i && numbers[parentIndex] < numbers[leftChild] ) {
                    swap(numbers, parentIndex, leftChild);
                    break;
                } else {
                    break;
                }
                swap(numbers, parentIndex, swapIndex);
                parentIndex = swapIndex;
                leftChild = leftChild(parentIndex);
                rightChild = rightChild(parentIndex);
            }

        }
    }
    
    public static void swap(int[] numbers, int i, int j) {
        numbers[i] += numbers[j];
        numbers[j] = numbers[i] - numbers[j];
        numbers[i] -= numbers[j];
    }
    
    public static int parentOf(int child) {
        if (child <= 0) {
            return -1;
        }
        return (child - 1) >> 1;
    }
    
    public static int leftChild(int parent) {
        if (parent < 0) {
            return -1;
        }
        return (parent << 1) + 1;
    }

    public static int rightChild(int parent) {
        if (parent < 0) {
            return -1;
        }
        return (parent << 1) + 2;
    }

    public static void main(String[] args) {
        final int SIZE = 200000;
        int[] numbers = new int[SIZE];
        Random rand = new Random();
        for (int i = 0; i < SIZE; ++i) {
            numbers[i] = Math.abs(rand.nextInt() % 10000);
        }
        sort(numbers);
//        System.out.println(Arrays.toString(numbers));
	}
}