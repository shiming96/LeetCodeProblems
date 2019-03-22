class Solution {
    public int lengthOfLastWord(String s) {
        int len = 0;
        for(int i = s.length() - 1; i >= 0; i--) {
            //过滤末尾空格
            if(s.charAt(i) == ' ' && len == 0) {
                continue;
            //碰到最后一个单词，开始计数
            }else if(s.charAt(i) != ' '){
                len++;
            //再次碰到空格，单词计数完毕结束循环
            } else {
                break;
            }
        }
        return len;
    }
}