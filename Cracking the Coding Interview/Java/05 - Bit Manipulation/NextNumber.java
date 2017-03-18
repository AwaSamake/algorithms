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
    
	public static void main(String[] args) {
		
	}
}