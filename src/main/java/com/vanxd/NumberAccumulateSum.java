package com.vanxd;

import java.util.Scanner;

/**
 * 给一个数字计算并打印每位累加之和。如数字1234，计算出1+2+3+4 =10。
 *
 * Created by wyd on 2016/8/5.
 */
public class NumberAccumulateSum {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String number;
        while (!"".equals(number = scanner.nextLine())) {
            System.out.println(number);
            System.out.println(getNumberAccumulateSum(number));
        }
    }

    /**
     * 将给定的数字的每一位进行累加
     * @param number 必须 String 数字的字符串形式
     * @return 累加之和
     */
    private static int getNumberAccumulateSum(String number) {
        int sum = 0;
        for (int i = 0, j = number.length(); i < j ; i++) {
            char currentChar = number.charAt(i);
            // 排除小数点
            if('.' == currentChar) {
                continue;
            }
            // 排除负号
            else if('-' == currentChar) {
                continue;
            }
            sum += Integer.parseInt(String.valueOf(currentChar));
        }
        return sum;
    }
}
