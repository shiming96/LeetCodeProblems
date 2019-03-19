import java.util.ArrayList;
class Solution {
    public boolean isPalindrome(int x) {
        if(x < 0)
            return false;
        if(x == 0)
            return true;
        
        ArrayList<Integer> list = new ArrayList<>();
        
        while(x != 0) {
            list.add(x % 10);
            x /= 10;
        }
        
        int len = list.size();
        int start = 0;
        int end = len - 1;
        
        while(start <= end) {
            if(list.get(start) == list.get(end)) {
                start++;
                end--;
            }else {
                return false;
            }
        }
        return true;
        
    }

    public boolean isPalindrome1(int x) {
        if(x < 0 || (x % 10 == 0 && x != 0))
            return false;
        
        int revertedNumber = 0;
        while(x > revertedNumber) {
            revertedNumber = revertedNumber * 10 + x % 10;
            x /= 10;
        }
               // �����ֳ���Ϊ����ʱ�����ǿ���ͨ�� revertedNumber/10 ȥ��������λ�����֡�
        // ���磬������Ϊ 12321 ʱ���� while ѭ����ĩβ���ǿ��Եõ� x = 12��revertedNumber = 123��
        // ���ڴ�����λ�����ֲ�Ӱ����ģ����������Լ���ȣ����������ǿ��Լ򵥵ؽ���ȥ���� 
        return x == revertedNumber || x == revertedNumber / 10;
        
    }

}
