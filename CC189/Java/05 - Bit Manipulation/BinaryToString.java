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
    
	public static void main(String[] args) {
		
	}
}