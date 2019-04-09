class Solution {
    public static int divide2(int dividend, int divisor) {
        //异或决定符号位
        boolean navigate = (dividend ^ divisor) < 0;
        int result = 0;
        if (divisor == 1) {
            return dividend;
        }
        if (dividend == divisor) {
            return 1;
        }
        if (divisor == Integer.MIN_VALUE) {
            return 0;
        }
        //因为规定了最大的存储为32位，所以不能用long
        //如果被除数是负数最小值，在计算的时候是转化成正数然后除的，当除数长度和被除数相同时，被除数就会全部一起被转成正数，这个时候会溢出，要报错
        //所以在这里先判断是不是最小值，如果是，先减去一份除数，使result=1，这样就不会溢出了
        if (dividend == Integer.MIN_VALUE) {
            if (divisor == -1) {
                return Integer.MAX_VALUE;
            } else {
                dividend = dividend - divisor;
                result = 1;
            }
        }
        //这个时候被除数和除数都不可能溢出，将被除数和除数转成正数
        dividend = dividend < 0 ? 0 - dividend : dividend;
        divisor = divisor < 0 ? 0 - divisor : divisor;
        for (int i = 31; i >= 0; i--) {
            if (dividend >> i >= divisor) {
                result += 1 << i;
                //左移一位相当于乘2
                dividend -= divisor << i;
            }
        }
        return navigate ? 0 - result : result;
    }
}