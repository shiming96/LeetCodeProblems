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
            if(j == -1 || haystack.charAt(i) == needle.charAt(j)) {
                ++i;
                ++j;
            } else
                j = next[j];
        }

        if(j == needle.length())
            return i - j;
        return -1;

    }


    private void getNext(String p, int[] next) {
        next[0] = -1;
        int i = 0;
        int j = -1;

        while(i < p.length()) {
            if(j == -1 || p.charAt(i) == p.charAt(j)) {
                ++i;
                ++j;
                next[i] = j;
            } else
                j = next[j];
        }

    }

}