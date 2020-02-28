package com.biggw.LeetCode;

import java.util.Stack;

public class 有效的括号 {
    public static void main(String[] args) {

    }

    class Solution {
        public boolean isValid(String s) {
            int len = s.length();
            if (len==0) return true;
            if (s.charAt(0)=='}' || s.charAt(0)==']' || s.charAt(0)==')'){
                return false;
            }
            Stack<Character> stack = new Stack<>();
            for (int i = 0; i < len; i++) {
                if (stack.empty()){
                    stack.push(s.charAt(i));
                } else if (isSym(stack.peek(),s.charAt(i))){
                    stack.pop();
                } else {
                    stack.push(s.charAt(i));
                }
            }
            return stack.empty();
        }

        private boolean isSym(char c1, char c2) {
            return (c1 == '(' && c2 == ')') || (c1 == '[' && c2 == ']') || (c1 == '{' && c2 == '}');
        }
    }
}
