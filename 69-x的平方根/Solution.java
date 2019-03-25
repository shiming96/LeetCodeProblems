class Solution {

    //--------------------------------------------------
    // 暴力查找
    //--------------------------------------------------
    public int mySqrt(int x) {
        for(int i = 1; i <= x; i++) {
            //注意：(i+1)*(i+1)可能会溢出
            if(((i * i) <= x) && ((double)(i+1)*(i+1) > x))
                return i;
        }
        return 0;
    }
    //--------------------------------------------------
    // 二分查找
    //--------------------------------------------------
    public int mySqrt1(int x) {
        if( x <= 1)
            return x;
        int low = 0;
        int high = x;
        int mid;
        while(low <= high) {
            mid = low + (high - low) / 2;
            //注意: 如果写成 mid * mid < x 会存在溢出问题
            if(mid < x / mid)
                low = mid + 1;
            else if(mid > x / mid)
                high = mid - 1;
            else
                return mid;
        }
        return high;
    }
    //--------------------------------------------------
    // 牛顿迭代法求根   https://blog.csdn.net/tassardge/article/details/84929990
    //--------------------------------------------------
    public int mySqrt2(int x) {
        double x0 = 1, x1 = 0;
        x1 = (double)(x0 * x0 + x)/(2 * x0);
        while(Math.abs(x0 - x1) > 0.000001){
            x0 = x1;
            x1 = (double)(x0 * x0 + x)/(2 * x0);
        }
        return (int)x1;
    }

}