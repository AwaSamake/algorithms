/**
 *
 * 0.5 Quick Sort
 *     Time: O(N Log(N))
 *     Space: O(1)
 *     Runtime: 39s
 *
 */
import java.util.*;

class Bounds {
    public int lower;
    public int upper;

    public Bounds(int lower, int upper) {
        this.lower = lower;
        this.upper = upper;
    }
}

class QuickSort {
    public static void sort(int[] numbers) {
        LinkedList<Bounds> queue = new LinkedList<Bounds>();
        queue.add(new Bounds(0, numbers.length - 1));
        while (!queue.isEmpty()) {
            Bounds bounds = queue.removeFirst();
            int mid = quickSort(numbers, bounds.lower, bounds.upper);
            if ((mid - bounds.lower) > 1) {
                queue.add(new Bounds(bounds.lower, mid));
            }
            if ((bounds.upper - mid) > 1) {
                queue.add(new Bounds(mid, bounds.upper));
            }
        }
    }

    public static int quickSort(int[] numbers, int begin, int end) {
        int left = 0, right = end - 1;
        while (left < right) {
            if (numbers[left] < numbers[end]) {
                ++left;
            } else {
                swap(numbers, left, right);
                --right;
            }
        }
        if (numbers[left] >= numbers[end]) {
            swap(numbers, left, end);
        }
        return left;
    }

    public static void swap(int[] numbers, int i, int j) {
        numbers[i] += numbers[j];
        numbers[j] = numbers[i] - numbers[j];
        numbers[i] -= numbers[j];
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