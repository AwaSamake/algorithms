/**
 *
 * 0.7 Bucket Sort
 *     Time: O()
 *     Space: O()
 *     Runtime: 450ms
 *
 */
import java.util.*;

class BucketSort {
    public static void sort(int[] numbers) {
        int mask = 1;
        LinkedList<Integer> zeroQueue = new LinkedList<Integer>();
        LinkedList<Integer> oneQueue = new LinkedList<Integer>();
        for (int i = Integer.BYTES * 4 - 1; i > -1; --i) {
            for (int num : numbers) {
                if ((num & mask) == 0) {
                    zeroQueue.add(num);
                } else {
                    oneQueue.add(num);
                }
            }
            int index = 0;
            while (!zeroQueue.isEmpty()) {
                numbers[index++] = zeroQueue.removeFirst();
            }
            while (!oneQueue.isEmpty()) {
                numbers[index++] = oneQueue.removeFirst();
            }
            mask <<= 1;
        }
    }

    public static void main(String[] args) {
        final int SIZE = 200000;
        int[] numbers = new int[SIZE];
        Random rand = new Random();
        
        for (int i = 0; i < SIZE; ++i) {
            numbers[i] = Math.abs(rand.nextInt() % 100000);
        }
        
        sort(numbers);
        System.out.println(Arrays.toString(numbers));
    }
}