package com.vanxd;

/**
 * Given a roman numeral, convert it to an integer.
 * Input is guaranteed to be within the range from 1 to 3999.
 *
 * I(1),V(5),X(10),L(50),C(100),D(500),M(1000)
 *
 * GET: SWITCH比MAP快
 * @author wyd on 2017/3/31.
 */
public class RomanToInteger {
    public static void main(String[] args) {
        RomanToInteger roman = new RomanToInteger();
        System.out.println(roman.romanToInt("MMMDLXXXVI"));
        System.out.println(roman.romanToInt("XCIX"));
        System.out.println(roman.romanToInt("LV"));
        System.out.println(roman.romanToInt("XL"));
        System.out.println(roman.romanToInt("CMXCIX"));
    }

    /**
     * 答案都正确
     * @param s 罗马数字
     * @return
     */
    public int romanToInt(String s) {
        char[] chars = s.toCharArray();
        int length = chars.length;
        int total = getValue(chars[length - 1]);
        int last = total;
        for (int i = length - 2; i >= 0; i--) {
            int current = getValue(chars[i]);
            if (current < last) {
                total -= current;
            } else {
                total += current;
                last = current;
            }
        }
        return total;
    }

    /**
     * SWITCH比MAP快
     * @param c
     * @return
     */
    public int getValue(char c) {
        switch (c) {
            case 'I':
                return 1;
            case 'V':
                return 5;
            case 'X':
                return 10;
            case 'L':
                return 50;
            case 'C':
                return 100;
            case 'D':
                return 500;
            case 'M':
                return 1000;
            default:
                return 0;
        }
    }
}
