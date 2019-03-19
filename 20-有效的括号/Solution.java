import java.util.Stack;
class Solution {
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        for(int i = 0; i < s.length(); i++) {
            if(s.charAt(i) == '(' || s.charAt(i) == '[' || s.charAt(i) == '{')
                stack.push(s.charAt(i));
            else {
                if(stack.isEmpty())
                    return false;
                char c = stack.peek();
                char temp = s.charAt(i);
                char match;
                if(temp == ')')
                    match = '(';
                else if(temp == ']')
                    match = '[';
                else 
                    match = '{';
                if(c == match) {
                    stack.pop();
                } else {
                    return false;
                }
            }
        }
        if(!stack.isEmpty())
            return false;
        else
            return true;
    }
}