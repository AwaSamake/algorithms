/**
 *
 * 5.1 Insertion
 *     You are given two 32-bit numbers, N and M, and two bit positions, i and j. Write a
 *     method to inert M into N such that M starts at bit j and ends at bit i. You can
 *     assume that the bit j though i have enough space to fit all of M. That is, if
 *     M = 10011, you can assume that there are at least 5 bit between j and i. You would
 *     not, for example, have j = 3 and i = 2, because M could not fully fit between bit
 *     3 and bit 2.
 *     Example:
 *         Input:  N = 10000000000, M = 10011, j = 2, j =6
 *         Output: N = 10001001100
 *
 *
 */

class Insertion {
    // My Solution
    public static int updateBits(int m, int n, int i, int j) {
        int mask = 0;
        for (int index = i; index <= j; ++index) {
            mask |= (1 << i);
        }
        mask = ~ mask;
        n &= mask;

        m = (m << i);
        n |= m;
        return n;
    }

    // Book Solution
    public static int updateBits2(int m, int n, int i, int j) {
        int AllOne = ~0;
        int leftMask = (AllOne << (j + 1));
        int rightMask = (1 << i) - 1;
        int mask = leftMask | rightMask;
        int n_cleared = n & mask;
        int m_shifted = m << i;
        int answer = n_cleared | m_shifted;
        return answer;
    }
    
	public static void main(String[] args) {
		
	}
}