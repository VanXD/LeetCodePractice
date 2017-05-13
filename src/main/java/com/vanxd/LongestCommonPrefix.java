package com.vanxd;

import java.util.Arrays;

/**
 * Write a function to find the longest common prefix string amongst an array of strings.
 * @author wyd on 2017/5/13.
 */
public class LongestCommonPrefix {

    public static void main(String[] args) {
        LongestCommonPrefix a = new LongestCommonPrefix();
        System.out.println(a.longestCommonPrefix2(new String[]{"abc","abc","abc"}));
        System.out.println(a.longestCommonPrefix2(new String[]{"abab","aba",""}));
        System.out.println(a.longestCommonPrefix2(new String[]{"flower","asflow","flight"}));
        System.out.println(a.longestCommonPrefix2(new String[]{"aba","c","b","a","ab"}));
        System.out.println(a.longestCommonPrefix2(new String[]{"abc", "abcd", "abcde", "abcdef", "abcdefg"}));
        System.out.println(a.longestCommonPrefix2(new String[]{"abc", "bcd", "gdf", "aer", "agd"}));
    }

    /**
     * 117 / 117 test cases passed.
     * Status: Accepted
     * Runtime: 10 ms
     * Your runtime beats 84.94 % of java submissions.
     * @param strs
     * @return
     */
    public String longestCommonPrefix(String[] strs) {
        if (null == strs || 0 == strs.length) {
            return "";
        }
        String prefix = strs[0];
        boolean isPrefix = false;
        while (prefix.length() > 0 && !isPrefix) {
            for (String str : strs) {
                if (prefix.length() > str.length()) {
                    prefix = prefix.substring(0, prefix.length() - (prefix.length() - str.length()));
                    isPrefix = false;
                    break;
                }
                if (!str.startsWith(prefix)) {
                    prefix = prefix.substring(0, prefix.length() - 1);
                    isPrefix = false;
                    break;
                }
                isPrefix = true;
            }
        }
        return prefix;
    }

    /**
     * Sorted the array, Java solution, 2 ms
     *
     * 1.排序，相同前缀的会被排在一起，所以第一个和最后一个的前缀必须是一样的
     * 2.取得第一个和最后一个的公共前缀即可
     *
     * @author cassandra9
     * @param strs
     * @return
     */
    public String longestCommonPrefix2(String[] strs) {
        StringBuilder result = new StringBuilder();

        if (strs != null && strs.length > 0) {

            Arrays.sort(strs);

            char[] a = strs[0].toCharArray();
            char[] b = strs[strs.length - 1].toCharArray();

            for (int i = 0; i < a.length; i++) {
                if (b.length > i && b[i] == a[i]) {
                    result.append(b[i]);
                } else {
                    return result.toString();
                }
            }
            return result.toString();
        }
        return "";
    }
}
