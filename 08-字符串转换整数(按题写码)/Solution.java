import java.math.BigInteger;
class Solution {
    public int myAtoi(String str) {
        if(str == null || str.length() == 0)
            return 0;
        int index = 0;
        //去除头部空格
        for(int i = 0; i < str.length(); i++) {
            if(str.charAt(i) == ' ')
                continue;
            else {
                index = i;
                break;
            }
        }
        str = str.substring(index);
        if(str.length() == 0)
            return 0;
        StringBuilder sb = new StringBuilder();
        boolean symbol = false;// 正负号标记  false为 '+'
        if(str.charAt(0) == '-') {
            symbol = true;
        } else if(str.charAt(0) == '+') {
            //
        } else if(str.charAt(0) >= '0' && str.charAt(0) <= '9') {
            sb.append(str.charAt(0));
        } else {
            return 0;
        }
        for(int i = 1; i < str.length(); i++) {
            if(str.charAt(i) >= '0' && str.charAt(i) <= '9') {
                sb.append(str.charAt(i));    
            } else {
                break;
            }
        }
        
        if(sb.length() == 0)
            return 0;
        BigInteger bi = new BigInteger(sb.toString());
        BigInteger max = new BigInteger(String.valueOf(Integer.MAX_VALUE));
        //如果越界
        if(bi.compareTo(max) > 0) {
            if(symbol)
                return Integer.MIN_VALUE;
            else
                return Integer.MAX_VALUE;
        }
        
        int num = bi.intValue();
        return symbol ? -num : num;
        
    }
}