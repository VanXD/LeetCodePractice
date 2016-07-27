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
//        System.out.println(new LengthOfLongestSubstring().lengthOfLongestSubstring("uqinntq"));
        System.out.println(new LengthOfLongestSubstring().lengthOfLongestSubstring("abababcd"));
    }

    /**
     * 思路：有点桶排序的感觉？
     *    将字符串里的字符转成char,其实就是个int值，再将该字符的序号放在桶里，
     * 之后如果有重复的，则将该序号记录到j,j就是记录最长的重复序号,最后用i - j 得到他们的距离（字符串长度-最长的重复=最长的不重复子字符串）。
     * @param s
     * @return
     */
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
