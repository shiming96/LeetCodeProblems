class Solution {
    public int[] plusOne(int[] digits) {
        
        int carryBit = 1;
        for(int i = digits.length - 1; i >= 0; i--) {
            int num = digits[i] + carryBit;
            carryBit = num / 10;
            digits[i] = num % 10;
            if(carryBit == 0)
                break;
        }
        int[] ret = new int[digits.length+1];
        ret[0] = 1;
        //如果最高位还有进位
        if(digits[0] == 0) {
            for(int i = 0; i < digits.length; i++)
                ret[i+1] = digits[i];
            return ret;
        }
        return digits;
    }
}