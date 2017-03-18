/**
 *
 * 0.2 Bubble Sort
 *     Time: O(n^2)
 *     Space: O(1)
 *     Runtime: 1m, 52s
 *
 */
import java.util.*;

class BubbleSort {
    public static void sort(int[] numbers) {
        final int SIZE = numbers.length;
        boolean done;
        do {
            done = true;
            for (int i = 0; i < SIZE - 1; ++i) {
                if (numbers[i] > numbers[i + 1]) {
                    numbers[i] += numbers[i + 1];
                    numbers[i + 1] = numbers[i] - numbers[i + 1];
                    numbers[i] -= numbers[i + 1];
                    done = false;
                }
            }
        } while (!done);
    }

    public static void main(String[] args) {
        final int SIZE = 200000;
        int[] numbers = new int[SIZE];
        Random rand = new Random();

        for (int i = 0; i < SIZE; ++i) {
            numbers[i] = rand.nextInt(Integer.MAX_VALUE);
        }

        sort(numbers);
        System.out.println(Arrays.toString(numbers));
    }
}