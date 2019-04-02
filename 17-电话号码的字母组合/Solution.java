class Solution {
    public List<String> letterCombinations(String digits) {
        if(digits == null || digits.length() == 0)
            return Collections.EMPTY_LIST;
        Map<Character, String> map = new HashMap<>();
        map.put('2', "abc");
        map.put('3', "def");
        map.put('4', "ghi");
        map.put('5', "jkl");
        map.put('6', "mno");
        map.put('7', "pqrs");
        map.put('8', "tuv");
        map.put('9', "wxyz");
        String[] str = new String[digits.length()];
        for(int i = 0; i < digits.length(); i++) {
            str[i] = map.get(digits.charAt(i));
        }
        ArrayList<String> retList = new ArrayList<>();
        for(int i = 0; i < digits.length(); i++) {
            String temp = str[i];
            //第一个数字单独考虑
            if(i == 0) {
                for(int b = 0; b < temp.length(); b++) {
                    retList.add(temp.charAt(b) + "");
                }
            } else {//双重循环首先处理前两个数字，组合成一个整体，再跟后面一个数字拼接
                ArrayList<String> tempList = (ArrayList<String>) retList.clone();
                retList.clear();
                for(int j = 0; j < tempList.size(); j++) {
                    for(int k = 0; k < temp.length(); k++) {
                        retList.add(tempList.get(j) + temp.charAt(k));
                    }
                }
            }
        }
        return retList;
    }
}