import java.util.*;

class MergeSort {
	public static void mergeSort(int[] numbers) {
		int size = numbers.length;
		int mid = size >> 1;
		mergeSort(numbers, 0, mid-1);
		mergeSort(numbers, mid, size-1);
		merge(numbers, 0, mid-1, mid, size-1);
	}
	
	public static void mergeSort(int[] numbers, int begin, int end) {
		if (end <= begin) { 
			return;
		} else if (end - begin == 1) {
			if (numbers[end] < numbers[begin]) {
				int temp = numbers[end];
				numbers[end] = numbers[begin];
				numbers[begin] = temp;
			}
			return;
		}
		int mid = (begin + end) >> 1;
		mergeSort(numbers, begin, mid-1);
		mergeSort(numbers, mid, end);
		merge(numbers, begin, mid-1, mid, end);
	}
	
	public static void merge(int[] numbers, int begin1, int end1, int begin2, int end2) {
		int start = begin1;
		int[] temp = new int[end2 - begin1 + 1];
		int index = 0;
		while (begin1 <= end1 && begin2 <= end2) {
			temp[index++] = (numbers[begin1] < numbers[begin2]) ? numbers[begin1++] : numbers[begin2++];
		}
		while (begin2 <= end2) { temp[index++] = numbers[begin2++]; }
		while (begin1 <= end1) { temp[index++] = numbers[begin1++];	}
		index = 0;
		for (int i = start; i <= end2; ++i) { numbers[i] = temp[index++]; }
	}
		
	public static void main(String[] args) {
		int[] numbers = new int[100];
		Random rand = new Random();
		for (int i = 0; i < 100; ++i) { numbers[i] = Math.abs(rand.nextInt() % 200); }
		System.out.println(Arrays.toString(numbers));
		mergeSort(numbers);
		System.out.println(Arrays.toString(numbers));
	}
}