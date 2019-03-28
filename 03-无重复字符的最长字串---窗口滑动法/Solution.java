import java.math.*;
import java.util.*;
class Solution {


    //--------------------------------------------------
    // 1.   暴力法   循环遍历 O(n3)
    // 2.   窗口滑动法  O(n) 
    //--------------------------------------------------
    public int lengthOfLongestSubstring(String s) {
        int n = s.length();
        Set<Character> set = new HashSet<>();
        int ans = 0;
        int i = 0;
        int j = 0;
        
        while(i < n && j < n) {
            if(!set.contains(s.charAt(j))) {
                set.add(s.charAt(j++));
                ans = Math.max(ans, j - i);
            } else {
                set.remove(s.charAt(i++));
            }
        }
        
        return ans;
        
    }
    //优化的窗口滑动法
    public int lengthOfLongestSubstring1(String s) {
        int n = s.length();
        int ans = 0;
        Map<Character, Integer> map = new HashMap<>();
        for(int j = 0, i = 0; j < n; j++) {
            if(map.containsKey(s.charAt(j))) {
                i = Math.max(map.get(s.charAt(j)), i);
            }
            ans = Math.max(ans, j - i + 1);
            map.put(s.charAt(j), j + 1);
        }
        return ans;
    }

}