/**
 * Created by Lihao on 1/29/17.
 * Chapter 05 - Bit Manipulation
 */

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
 *         Input:  N = 10000000000, M = 10011, i = 2, j =6
 *         Output: N = 10001001100
 *
 *
 */
class Insertion {
    // My Solution
    public int updateBits(int m, int n, int i, int j) {
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
    public int updateBits2(int m, int n, int i, int j) {
        int AllOne = ~0;
        int leftMask = (AllOne << (j + 1));
        int rightMask = (1 << i) - 1;
        int mask = leftMask | rightMask;
        int n_cleared = n & mask;
        int m_shifted = m << i;
        int answer = n_cleared | m_shifted;
        return answer;
    }


}

/**
 *
 * 5.2 Binary to String
 *     Given a real number between 0 and 1 (e.g., 0.72) that is passed in as a double,
 *     print the binary representation, if the number cannot be represented accurately
 *     in binary with at most 32 characters, print "ERROR"
 *
 */

class BinaryToString {
    public String printBinary(double num) {
        if (num < 0 || num > 1) {
            return "ERROR";
        }

        StringBuilder binary = new StringBuilder();
        binary.append('.');
        while (num > 0) {
            if (binary.length() >= 32) {
                return "ERROR";
            }
             num *= 2;
            if (num > 1) {
                binary.append('1');
                num -= 1;
            } else {
                binary.append('0');
            }
        }
        return binary.toString();
    }
}


/**
 *
 * 5.3 Flip Bit to Win
 *     You have an integer and you can flip exactly one bit from a 0 to a 1. Write code
 *     to find the length of the longest sequence of 1s you could create.
 *
 */


class FlipBitToWin {
    public int flipBit(int a) {
        if (~a == 0) {
            // if all 1s, no need to flip
            // return size of integer in bit
            return Integer.BYTES * 8;
        }
        int previousLength = 0;
        int currentLength = 0;
        int maxLength = 0;
        boolean previousBitZero = false;

        while (a != 0) {
            if ((a & 1) == 1) {
                ++currentLength;
                previousBitZero = false;
            } else if ((a & 1) == 0) {
                previousLength = (previousBitZero) ? 0 : currentLength;
                currentLength = 0;
                previousBitZero = true;
            }
            // length = previous + current + flip
            maxLength = Math.max(maxLength, previousLength + currentLength + 1);
            a >>>= 1;
        }
        return maxLength;
    }
}

/**
 *
 * 5.4 Next Number
 *     Given a positive integer, print the next smallest and the next largest number that
 *     have the same number of 1 bits in their binary representation.
 *
 */
class NextNumber {
    int getNext(int n) {
        if (n == 0) { return -1; }

        int temp = n;
        // count number of 0s
        int count0 = 0;
        while ((temp & 1) == 0) {
            ++count0;
            temp >>= 1;
        }

        // count number of 1s
        int count1 = 0;
        while ((temp & 1) == 1) {
            ++count1;
            temp >>= 1;
        }

        int p = count0 + count1;
        // check Error
        if (count0 + count1 == 31) {
            return  -1;
        }

        // flip bit at p to 1
        n |= (1<<p);
        // clear right side of p to 0
        n &= ~((1 << p) - 1);
        // set c-1 number of bit on the right to 1
        n |= (1 << (count1-1)) - 1;
        return n;
    }

    int getPrev(int n ) {
        int temp = n;
        // count number of 1s
        int count1 = 0;
        while ((temp & 1) == 1) {
            ++count1;
            temp >>= 1;
        }

        // check 000...111 case
        if (temp == 0) { return -1; }

        // count number of 0s
        int count0 = 0;
        while ((temp & 1) == 0 && (temp != 0)) {
            ++count0;
            temp >>= 1;
        }

        int p = count0 + count1;
        // clear bit p and right side of p to 0
        n &= ((~0) << (p+1));

        int mask = ~((1 << (count0 - 1)) - 1);
        n |= mask;
        return n;

    }

}

/**
 *
 * 5.5 Debugger
 *     Explain what the following code does: (((n&(n-1))==0).
 *
 */

// n is power of 2

/**
 *
 * 5.6 Conversion
 *     Write a function to determine the number of bits you would need to flip to convert
 *     integer A to integer B.
 *     Example:
 *     Input:  29 (or: 11101), 15 (orL 01111)
 *     Output: 2
 *
 */


/**
 *
 * 5.7 Pairwise Swap
 *     Write a program to swap odd and even bits in an integer with as few instructions as
 *     possible (e.g., bit 0 and bit 1 are swapped, bit 2 and bit 3 are swapped, and so on).
 *
 */


/**
 *
 * 5.8 Draw Line
 *     A monochrome screen is stored as a single array of bytes, allowing eight consecutive
 *     pixels to be stored in one byte. The screen has width w, where w is divisible by 8
 *     (that is, no byte will be slop across rows). The height of the screen, of course,
 *     can be derived from the length of the array and the width. Implement of function
 *     that draw a horizontal line from (x1, y) to (x2, y).
 *     The method signature should look something like:
 *     drawLine(byte[] screen, int width, int x1, int x2, int y)
 *
 */
