package com.vanxd;

import java.util.Stack;

/**
 * Given a string containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.
 * The brackets must close in the correct order, "()" and "()[]{}" are all valid but "(]" and "([)]" are not.
 *
 * 栈的基本使用，有一个输入就有一个对应的入栈匹配
 * @author wyd on 2017/7/24.
 */
public class ValidParentheses {

    public static void main(String[] args) {
        ValidParentheses o = new ValidParentheses();
    }

    public boolean isValid(String s) {
        Stack<Character> cStack = new Stack<>();
        for (Character c : s.toCharArray()) {
            if (c.equals('(')) {
                cStack.push(')');
            } else if (c.equals('{')) {
                cStack.push('}');
            } else if (c.equals('[')) {
                cStack.push(']');
            } else if (cStack.isEmpty() || !cStack.pop().equals(c)) {
                return false;
            }
        }
        return cStack.isEmpty();
    }
}
