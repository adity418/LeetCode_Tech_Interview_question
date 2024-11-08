//  32. Longest Valid Parantheses

import java.util.Stack;

public class Solution32{
    public int longestValidParantheses(String s){
        Stack<Integer> stack = new Stack<>();
        stack.push(-1);
        int max_len = 0;

        for(int i = 0; i < s.length(); i++){
            if(s.charAt(i) == '('){
                stack.push(i);
            }else{
                stack.pop();
                if(stack.isEmpty()){
                    stack.push(i);
                }else{
                    max_len = Math.max(max_len, i - stack.peek());
                }
            }
        }
        return max_len;
    }
}