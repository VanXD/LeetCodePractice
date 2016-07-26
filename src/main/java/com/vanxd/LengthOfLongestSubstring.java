package com.vanxd;

import com.sun.deploy.util.StringUtils;

import java.util.*;

/**
 *
 * Java Solution 5ms O(n) runtime O(1) space two pointers and one Loop
 * https://discuss.leetcode.com/topic/51503/java-solution-5ms-o-n-runtime-o-1-space-two-pointers-and-one-loop
 * Created by wyd on 2016/7/26.
 */
public class LengthOfLongestSubstring {

    public static void main(String[] args) {
//        System.out.println(new LengthOfLongestSubstring().lengthOfLongestSubstring("dvdf"));
//        System.out.println(new LengthOfLongestSubstring().lengthOfLongestSubstring("anviaj"));
        System.out.println(new LengthOfLongestSubstring().lengthOfLongestSubstring("uqinntq"));
    }

    public int lengthOfLongestSubstring(String s) {
        if (s.length() == 0) return 0;
        int i = 0, j = 0, ret = 0;
        int[] charIndex = new int[256];
        while (i < s.length()) {
            if (charIndex[s.charAt(i)] > j) {
                if (i - j > ret) ret = i - j;
                j = charIndex[s.charAt(i)];
            }
            charIndex[s.charAt(i)] = i + 1;
            i++;
        }
        return (i - j > ret) ? i - j : ret;
    }

}
