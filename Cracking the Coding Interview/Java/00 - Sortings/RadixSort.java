/**
 *
 * 0.8 Radix Sort
 *     Time: O(N)
 *     Space: O(N+K)
 *     Runtime: 172ms
 *
 */
import java.util.*;

class RadixSort {
    public static int MAX_VALUE = 100000;

    public static void sort(int[] numbers) {
        int[] count = new int[MAX_VALUE];
        for (int num : numbers) {
            count[num]++;
        }
        for (int i = 1; i < count.length; ++i) {
            count[i] += count[i - 1];
        }
        int[] dup = numbers.clone();
        for (int i = 0; i < dup.length; ++i) {
            int val = dup[i];
            numbers[count[val] - 1] = val;
            count[val]--;
        }
    }

    public static void main(String[] args) {
        final int SIZE = 200000;
        int[] numbers = new int[SIZE];
        Random rand = new Random();

        for (int i = 0; i < SIZE; ++i) {
            numbers[i] = rand.nextInt(MAX_VALUE);
        }

        sort(numbers);
        System.out.println(Arrays.toString(numbers));
    }
}