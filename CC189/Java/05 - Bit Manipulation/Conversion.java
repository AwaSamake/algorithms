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
class Conversion {
    public int convert(int A, int B) {
        int diff = A ^ B;
        int count = 0;
        while (diff != 0) {
            if ((diff & 1) == 1) {
                ++count;
            }
            diff >>= 1;
        }
        return count;
    }

    public int convert2(int A, int B) {
        int count = 0;
        for (int c = A ^ B; c != 0; c >>= 1) {
            count += (c & 1);
        }
        return count;
    }

    public int convert3(int A, int B) {
        int count = 0;
        for (int c = A ^ B; c != 0; c &= (c-1)) {
            ++count;
        }
        return count;
    }
    
	public static void main(String[] args) {
		
	}
}