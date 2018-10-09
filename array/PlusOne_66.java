
class PlusOne_66{
	public int[] plusOne(int[] digits) {
        for(int i = digits.length - 1; i>=0; --i){
            if(digits[i] != 9){
                digits[i] = digits[i] + 1;
                return digits;
            }
            digits[i] = 0;
            if(0 == i){
                int[] result = new int[digits.length+1];
                result[0] = 1;
                return result;
            }
        }
        return digits;
    }
}