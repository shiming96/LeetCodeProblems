class Solution {
    //n & (n - 1)  清零最低位的1 
    // n & -n    得到最低位的1
    // x & 1 == 1 OR == 0 判断奇偶
    public boolean isPowerOfTwo(int n) {
        return n > 0 && (n & (n - 1)) == 0;
    }
}