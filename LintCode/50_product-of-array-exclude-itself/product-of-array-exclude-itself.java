/*
@Copyright:LintCode
@Author:   LLihao
@Problem:  http://www.lintcode.com/problem/product-of-array-exclude-itself
@Language: Java
@Datetime: 17-06-08 04:22
*/

public class Solution {
    /**
     * @param A: Given an integers array A
     * @return: A Long array B and B[i]= A[0] * ... * A[i-1] * A[i+1] * ... * A[n-1]
     */
    public ArrayList<Long> productExcludeItself(ArrayList<Integer> A) {
        long product = 1;
        int zeros = 0;
        for (int a : A) {
            if (a == 0) {
                if (++zeros > 1) {
                    break;
                }
            } else {
                product *= a;
            }
        }
        ArrayList<Long> products = new ArrayList<Long>();
        if (zeros > 0) {
            for (int a : A) {
                products.add((long)0);
            }
        }
        if (zeros > 1) {
            return products;
        } else if (zeros == 1) {
            for (int i = 0; i < A.size(); ++i) {
                if (A.get(i) == 0) {
                    products.set(i, product);
                    return products;
                }
            }
        } else {
            for (int a : A) {
                if (a == 0) {
                    products.add(product);
                } else {
                    products.add(product / a);
                }
            }
        }
        return products;
    }
}
