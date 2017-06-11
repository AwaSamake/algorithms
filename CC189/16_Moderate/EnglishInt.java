/**
 *
 * 16.8 English Int
 *     Given any integer, print an English phrase that describes the integer(e.g., 
 *     "One Thousand, Two Hundred Thirty Four").
 *
 */

class EnglishInt {
	public static String[] smalls = new String[] {"ZERO", "ONE", "TWO", "THREE", "FOUR", "FIVE", "SIX", "SEVEN", "EIGHT", "NINE", "TEN", "ELEVEN", "TWELVE", "THIRTEEN", "FORTEEN", "FIFTEEN", "SIXTEEN", "SEVENTEEN", "EIGHTEEN", "NIGHTEEN", "TWENTY"};
	
	public static String[] tens = {"", "TWENTY", "THIRTY", "FORTY", "FIFTY", "SIXTY", "SEVENTY", "EIGHTY", "NINETY"};
	
	public static String[] big = {"", "THOUSAND", "MILLION", "BILLION"};
	public static String hundred = "HUNDRED";
	public static String negative = "NEGATIVE";
	
	public static String getEnglishInt(int number, int index) {
		if (number == 0) {
			return smalls[number];
		} else if (number < 0) {
			return negative + " " + getEnglishInt(-1 * number, index);
		}
		
		int __xx = number % 100;
		int _x__ = number % 1000 / 100;
				
		String english = "";
		if (__xx < 20) {
			english = smalls[__xx];
		} else {
			int ___x = __xx % 10;
			int __x_ = __xx / 10;
			english = tens[__x_] + " " + smalls[__x_];
		}
		
		if (_x__ > 0) {
			english = smalls[_x__] + " " + hundred + " " + english;
		}
		
		if (number / 1000 > 0) {
			return getEnglishInt(number / 1000, index + 1) + " " + big[index] + ", " + english;
		} else {
			return english;
		}
	}
	
	public static void main(String[] args) {
		System.out.println(getEnglishInt(19323984, 1));
	}
}