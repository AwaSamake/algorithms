/**
 *
 * 0.4 Heap Sort
 *     Time: O()
 *     Space: O()
 *     Runtime: ms
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
        
        for (int i = SIZE - 1; i > -1; --i) {
            System.out.println(Arrays.toString(numbers));
            swap(numbers, i, 0);            int parentIndex = 0;
            int leftChild = leftChild(0);
            int rightChild = rightChild(0);
            
            while (true) {
                
            }
            System.out.println(Arrays.toString(numbers));
            System.out.println("max:" + numbers[i] + " swaped to end\n\n");

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
        final int SIZE = 20;
        int[] numbers = new int[SIZE];
        Random rand = new Random();
        for (int i = 0; i < SIZE; ++i) {
            numbers[i] = Math.abs(rand.nextInt() % 100);
        }
        sort(numbers);
        System.out.println(Arrays.toString(numbers));
	}
}

/*

final int SIZE = 200000;
int[] numbers = new int[SIZE];
Random rand = new Random();
for (int i = 0; i < SIZE; ++i) {
    numbers[i] = Math.abs(rand.nextInt() % 10000);
}
sort(numbers);

*/