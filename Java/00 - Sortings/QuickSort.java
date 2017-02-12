/**
 *
 * 0.5 Quick Sort
 *     Time: O()
 *     Space: O()
 *     Runtime: ms
 *
 */
class QuickSort {
    public static void sort(int numbers) {
                
    }

    public static void main(String[] args) {
	final int SIZE = 200000;
        int[] numbers = new int[SIZE];
        Random rand = new Random();

        for (int i = 0; i < SIZE; ++i) {
            numbers[i] = Math.abs(rand.nextInt() % 10000);
        }

        sort(numbers);
    }
}