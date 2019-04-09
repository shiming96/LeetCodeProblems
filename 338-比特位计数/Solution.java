class Solution {
    public int[] countBits(int num) {
        int[] ret = new int[num + 1];
        for (int i = 0; i <= num; i++) {
            int count = 0;
            int temp = i;
            while (temp != 0) {
                temp = temp & (temp - 1);
                count++;
            }
            ret[i] = count;
        }
        return ret;
    }

    //递推
    public int[] countBits1(int num) {
        int[] ret = new int[num + 1];
        // 0 不满足
        for (int i = 1; i <= num; i++) {
            ret[i] = ret[i & (i - 1)] + 1;
        }
        return ret;
    }

}