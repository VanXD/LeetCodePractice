package com.vanxd;

/**
 * 判断是否为回文数
 *
 * 1.回文数其实就是一个数，正序，逆序都是同一个数，所以只需要逆序然后判断是否相等就行了。
 * 2.负数不是回文数
 * @author wyd on 2017/3/14.
 */
public class PalindromeNumber {
    public static void main(String[] args) {
        PalindromeNumber pn = new PalindromeNumber();
        System.out.println(pn.isPalindrome(123321));
        System.out.println(pn.isPalindrome(-123321));
    }

    public boolean isPalindrome(int x) {
        if ( x < 0 ) return false;
        int y = x;
        int res = 0;
        while (y != 0) {
            res = res * 10 + y % 10;
            y /= 10;
        }
        return res == x;
    }
}
