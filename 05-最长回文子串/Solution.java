class Solution {

    //--------------------------------------------------
    // 1.   暴力法O(n3)   循环遍历所有的字串，判断其回文特性
    //--------------------------------------------------
    public String longestPalindrome(String s) {
        int len = s.length();
        int max = 0;
        String ret = "";
        for(int i = 0; i < len; i++) {
            for(int j = i + 1; j <= len; j++) {
                String str = s.substring(i, j);
                int num = isPalindrome(str);
                if(num > max) {
                    max = num;
                    ret = str;
                }
            }
        }
        return ret;
    }
    
    private int isPalindrome(String str) {
        int i = 0;
        int j = str.length() - 1;
        while(i <= j) {
            if(str.charAt(i) == str.charAt(j)) {
                i++;
                j--;
            } else {
                return 0;
            }
        }
        return str.length();
    }

    //--------------------------------------------------
    // 2.   动态规划-中心扩展算法   
    //--------------------------------------------------
    public String longestPalindrome1(String s) {
        if(s == null || s.length() < 1)
            return "";
        int start = 0;
        int end = 0;
        for(int i = 0; i < s.length(); i++) {
            int len1 = expandAroundCenter(s, i, i);//奇数中心扩展
            int len2 = expandAroundCenter(s, i, i+1);//偶数中心扩展 所含字母数为偶数的回文的中心可以处于两字母之间
            int len = Math.max(len1, len2);
            if(len > end - start) {
                start = i - (len - 1) / 2;
                end = i + len / 2;
            }
        }
        return s.substring(start, end + 1);
    }
    
    private int expandAroundCenter(String s, int left, int right) {
        int L = left;
        int R = right;
        while(L >= 0 && R < s.length() && s.charAt(L) == s.charAt(R)) {
            L--;
            R++;
        }
        return R - L - 1;
    }

}