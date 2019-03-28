class Solution {


    //--------------------------------------------------
    // 1. 自己写的最拙劣最丑陋的解法
    //--------------------------------------------------
    public String convert(String s, int numRows) {
        if(numRows == 1)
            return s;
        char[][] arr = new char[numRows][s.length()];
        
        int i = 0;
        int j = 0;
        //flag  2:竖着走    1：斜着走
        int flag = 2;
        for(int k = 0; k < s.length(); k++) {
            arr[i][j] = s.charAt(k);
            if(flag == 2)
                i++;
            if(i >= numRows) {
                flag = 1;
                i = numRows - 1;
            }
            if(flag == 1) {
                i--;
                j++;
                if(i < 0) {
                    i = 1;
                    flag = 2;
                }
            }
        }
        StringBuilder sb = new StringBuilder();
        for(int m = 0; m < numRows; m++) {
            for(int n = 0; n < s.length(); n++) {
                if(arr[m][n] >= ' ') {
                    sb.append(arr[m][n]);
                }
            }
        }
        return sb.toString();
    }

    //--------------------------------------------------
    // 1. 参考官方题解
    //--------------------------------------------------
    public String convert1(String s, int numRows) {
        if(numRows == 1)
            return s;
        
        ArrayList<StringBuilder> list = new ArrayList<>();
        
        for(int i = 0; i < Math.min(numRows, s.length()); i++) {
            list.add(new StringBuilder());
        }
        
        int curRow = 0;
        //方向控制
        boolean goDown = false;
        
        for(int i = 0; i < s.length(); i++) {
            list.get(curRow).append(s.charAt(i));
            if(curRow == 0 || curRow == numRows - 1)
                goDown = !goDown;
            curRow += goDown ? 1 : -1;
        }
        
        StringBuilder ret = new StringBuilder();
        for(StringBuilder sb : list) {
            ret.append(sb);
        }
        return ret.toString();
    }

}