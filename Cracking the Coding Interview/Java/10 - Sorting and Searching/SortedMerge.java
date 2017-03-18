/**
 *
 * 10.1 Sorted Merge
 *     You are given two sorted arrays, A and B, where A has a large enough buffer at the
 *     end to hold B. Write a method to merge B into A in sorted order.
 *
 */
import java.util.*;

class SortedMerge {
    public static void merge(int[] a, int[] b, int lastA, int lastB) {
        if (lastB < 0) {
            return;
        } else if (lastA < 0) {
            for (int i = 0; i <= lastB; ++i) {
                a[i] = b[i];
            }
        }
        int last = lastA + lastB + 1;
        int i = lastA, j = lastB;
        while (j > -1) {
            System.out.println(last);
            if (i < 0 || a[i] < b[j]) {
                a[last--] = b[j--];
            } else {
                a[last--] = a[i--];
            }
        }
    }
    
    public static void main(String[] args) {
        int[] a = new int[] {1,3,5,7,9, 0, 0, 0, 0, 0};
        int[] b = new int[] {2,4,6,8,10};
        
        merge(a, b, 4, 4);
        
        System.out.println(Arrays.toString(a));
    }
}