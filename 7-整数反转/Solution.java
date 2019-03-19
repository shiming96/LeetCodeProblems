class Solution {
    public int reverse(int x) {
        
        long ret = 0;

        while(x != 0) {
            int temp = x % 10;
            x = x / 10;
            ret = ret * 10 + temp;
            
        }
        
        if(ret > Integer.MAX_VALUE || ret < Integer.MIN_VALUE)
            return 0;
        else {
                return (int)ret;
        }
    }
}