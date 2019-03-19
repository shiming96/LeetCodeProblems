import java.util.HashMap;
class Solution {
    //这题懂了就非常简单。首先建立一个HashMap来映射符号和值，然后对字符串从左到右来，如果当前字符代表的值不小于其右边，就加上该值；否则就减去该值。以此类推到最左边的数，最终得到的结果即是答案
    public int romanToInt(String s) {
        HashMap<Character, Integer> map = new HashMap<>();
        map.put('I', 1);
        map.put('V', 5);
        map.put('X', 10);
        map.put('L', 50);
        map.put('C', 100);
        map.put('D', 500);
        map.put('M', 1000);
        
        int ret = 0;
        
        for(int i = 0; i < s.length() - 1; i++) {
            if(map.get(s.charAt(i)) >= map.get(s.charAt(i+1))) {
                ret += map.get(s.charAt(i));
            } else {
                ret -= map.get(s.charAt(i));
            }
        }
        ret += map.get(s.charAt(s.length() - 1));
        
        return ret;
    }
}