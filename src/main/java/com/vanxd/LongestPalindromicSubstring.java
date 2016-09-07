package com.vanxd;

/**
 * 以中心为圆点扩展进行判断，从而获得子字符串。
 *
 * @author wyd on 2016/9/7.
 */
public class LongestPalindromicSubstring {
    public static void main(String[] args) {
        LongestPalindromicSubstring test = new LongestPalindromicSubstring();
        System.out.println(test.longestPalindrome("hfghreabccbabvasrtg"));
//        System.out.println(test.longestPalindrome("abccbaabccbaa"));
//        System.out.println(test.longestPalindrome("abbaddabccba"));
//        System.out.println(test.longestPalindrome("abccbadabccbaabccbadabccbaabccbaabccbad"));

    }

    public String longestPalindrome(String s) {
        int start = 0, end = 0;
        for (int i = 0; i < s.length(); i++) {
            // 该步用来判断当回文字符串长度是奇数时的情况
            int len1 = expandAroundCenter(s, i, i);
            // 该步用来判断当回文字符串长度是偶数时的情况
            int len2 = expandAroundCenter(s, i, i + 1);
            int len = Math.max(len1, len2);
            // 如果长度大于之前记录的，就计算新的开始/结束下标
            if (len > end - start) {
                System.out.println(len + " || " + start + " || " + end);
                // 因为i是回文的中点，所以计算开始坐标需要 i - 长度/2， len - 1是为了下标从0开始计算
                start = i - (len - 1) / 2;
                // 因为i是回文的中点，所以计算结束坐标需要 i + 长度/2
                end = i + len / 2;
                System.out.println(start + " || " + end);
            }
        }
        return s.substring(start, end + 1);
    }

    /**
     * 以left, right为两个基点，向左右扩展判断字符是否相等，从而判断是否回文
     * @param s
     * @param left
     * @param right
     * @return 返回left, right的距离
     */
    private int expandAroundCenter(String s, int left, int right) {
        int L = left, R = right;
        while (L >= 0 && R < s.length() && s.charAt(L) == s.charAt(R)) {
            L--;
            R++;
        }
        return R - L - 1;
    }
}
