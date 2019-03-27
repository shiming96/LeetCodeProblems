class Solution {

    //--------------------------------------------------
    // 暴力查找  最坏情况下O(M*N)
    //--------------------------------------------------
    public int strStr(String haystack, String needle) {
        if("".equals(needle) || needle == null)
            return 0;
        
        int j = 0;
        
        for(int i = 0; i < haystack.length(); i++) {
            if(haystack.charAt(i) != needle.charAt(j)) {
                i = i - j;
                j = 0;
            } else {
                j++;
                if(j >= needle.length())
                    return i - j + 1;
            }
        }
        return -1;
    }

    //--------------------------------------------------
    // KMP算法  O(M+N)
    //--------------------------------------------------

    public int strStr1(String haystack, String needle) {
        int i = 0;
        int j = 0;
        int[] next = new int[needle.length() + 1];
        getNext(needle, next);
        while(i < haystack.length() && j < needle.length()) {
            //a b c a b c d e
            //b c d
            //j == -1是为了考虑第一个字符就不相等的情况
            //匹配, i、j一起走  不匹配  j回退一定位置(根据next数组)
            if(j == -1 || haystack.charAt(i) == needle.charAt(j)) {
                ++i;
                ++j;
            } else
                //next数组中的值代表字符串的前缀集合与后缀集合的交集中最长元素的长度
                //它记录了匹配失败时，下一次和主串对应位置比对的下标(回退)
                j = next[j];
        }

        if(j == needle.length())
            return i - j;
        return -1;

    }


    private void getNext(String p, int[] next) {
        next[0] = -1;//固定为-1
        int i = 0; //求解计数器
        int j = -1; // next[0] = -1, next数组中i位置对应的值，即next[i]

        while(i < p.length()) {
            // j i
            // 0 1 2 3 4 5 6
            // a b c a b c d
            //当 i = 1, j = 0 时， 0 != 1, j = next[0] = -1;
            //因此要添加判断条件 j == -1,考虑初始状态
            if(j == -1 || p.charAt(i) == p.charAt(j)) {
                ++i;//求解下一个值
                ++j; 
                next[i] = j;//如果i和j位置元素相同, j加1之后再赋值给next的下个位置
            } else
                //向前循环找短一点的相同前后缀
                j = next[j];
        }

    }

}