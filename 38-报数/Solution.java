class Solution {
    public String countAndSay(int n) {
        String last = "1";
        for(int i = 2; i <= n; i++) {
            char cur = last.charAt(0);
            int cnt = 1;
            StringBuilder sb = new StringBuilder();
            for(int j = 1; j < last.length(); j++) {
                if(last.charAt(j) != cur) {
                    sb.append(cnt).append(cur);
                    cur = last.charAt(j);
                    cnt = 1;
                } else {
                    cnt++;
                }
            }
            sb.append(cnt).append(cur);
            last = sb.toString();   
        }
        return last;
    }
}