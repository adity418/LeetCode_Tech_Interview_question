// 20. Valid Parantheses

import java.util.*;

public class Solution20 {
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        Map<Character, Character> mapping = new HashMap<>();

        mapping.put(')', '(');
        mapping.put(']', '[');
        mapping.put('}', '{');

        for (char c : s.toCharArray()) {
            if (mapping.containsValue(c)) {
                stack.push(c);
            } else if (mapping.containsKey(c)) {
                if (stack.isEmpty() || mapping.get(c) != stack.pop()) {
                    return false;
                }
            }
        }
        return stack.isEmpty();
    }
}

// class Solution {
// public boolean isValid(String s) {
// int i=-1;
// char[] stack=new char[s.length()];
// for(char ch:s.toCharArray()){
// if(ch=='('||ch=='{'|| ch=='['){
// stack[++i]=ch;
// }
// else{
// if (i >= 0&& ((stack[i] == '(' && ch == ')')
// || (stack[i] == '{' && ch == '}')
// || (stack[i] == '[' && ch == ']')))

// i--;
// else
// return false;

// }
// }
// return i==-1;

// }
// }