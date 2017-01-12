package com.vanxd;

/**
 *
 * Reverse digits of an integer.
 *
 * Example1: x = 123, return 321
 * Example2: x = -123, return -321
 *
 * @author wyd on 2017/1/12.
 */
public class ReverseInteger {

    public static void main(String[] args) {
        ReverseInteger r = new ReverseInteger();
        System.out.println(r.reverse(-123));
        System.out.println(r.reverse(1534236469));
    }


    public int reverse(int x) {
        if ( x > Integer.MAX_VALUE || x < Integer.MIN_VALUE) {
            return  0;
        }
        long result = 0;
        while ( x != 0 ) {
            result = result * 10 + x % 10;
            x /= 10;
            if ( result > Integer.MAX_VALUE || result < Integer.MIN_VALUE) {
                return  0;
            }
        }
        return (int)result;
    }
}

