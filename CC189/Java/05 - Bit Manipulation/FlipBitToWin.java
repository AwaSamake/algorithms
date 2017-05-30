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
    
	public static void main(String[] args) {
		
	}
}