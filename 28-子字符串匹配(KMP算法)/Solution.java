class Solution {

    //--------------------------------------------------
    // 暴力查找  最坏情况下O(M+N)
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
}