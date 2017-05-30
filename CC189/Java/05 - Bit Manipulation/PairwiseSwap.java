/**
 *
 * 5.7 Pairwise Swap
 *     Write a program to swap odd and even bits in an integer with as few instructions as
 *     possible (e.g., bit 0 and bit 1 are swapped, bit 2 and bit 3 are swapped, and so on).
 *
 */
class PairwiseSwap {
    public int swap(int a) {
        int oddMask = 0xaaaaaaaa;
        int evenMask = 0x55555555;
        int oddShifted = (a & oddMask) >> 1;
        int evenShifted = (a & evenMask) << 1;
        return oddShifted | evenShifted;
    }
    
	public static void main(String[] args) {
		
	}
}