package com.vanxd;

import sun.misc.Compare;
import sun.misc.Sort;

import java.util.Scanner;

/**
 * 给一个非负整数列表打印出排列数字最大的组合，如【188,6,0,9】，计算出最大组合961880。
 *
 * Created by wyd on 2016/8/5.
 */
public class MaxNumber {
    public static void main(String[] args) {
        System.out.println("请输入使用空格分割的数字集合");
        Scanner scanner = new Scanner(System.in);
        String number = "";
        while (!"".equals(number = scanner.nextLine())) {
            Integer[] numbers = getIntArray(number);
            sort(numbers);
            printArray(numbers);
        }
    }

    /**
     * 对数组进行排序
     * @param numbers
     */
    private static void sort(Integer[] numbers) {
        Sort.quicksort(numbers, new Compare() {
            public int doCompare(Object o, Object o1) {
                String numberA = o.toString();
                String numberB = o1.toString();

                return compareResultSimpleWay(numberA, numberB);
            }
        });
    }

    /**
     * 对数字A和数字B进行大小比较
     *
     * @param numberA 必须 String 数字的字符串形式
     * @param numberB 必须 String 数字的字符串形式
     * @return
     */
    private static int compareResultSimpleWay(String numberA, String numberB) {
        if(numberA.charAt(0) > numberB.charAt(0)) {
            return -1;
        } else if (numberA.charAt(0) < numberB.charAt(0)) {
            return 1;
        } else {
            if(numberA.length() == 1 || numberB.length() == 1) {
                if(numberA.length() < numberB.length()) {
                    return numberB.charAt(1) > numberA.charAt(0) ? 1 : -1;
                } else {
                    return numberA.charAt(1) > numberB.charAt(0) ? -1 : 1;
                }
            }
            return compareResultSimpleWay(numberA.substring(1, numberA.length()), numberB.substring(1, numberB.length()));
        }
    }

    /**
     * 将逗号分割数字的字符串格式化为整型数组
     * @param number
     * @return
     */
    private static Integer[] getIntArray(String number) {
        String[] numberStrArray = number.split(" ");
        Integer[] result = new Integer[numberStrArray.length];
        for(int i = 0, j = numberStrArray.length ;i < j;i++) {
            result[i] = Integer.parseInt(numberStrArray[i]);
        }
        return result;
    }

    /**
     * 打印数组
     * @param numbers 必须 Integer[] 需要打印的整型数组
     */
    private static void printArray(Integer[] numbers) {
        StringBuilder sb = new StringBuilder();
        for(Integer number : numbers) {
            sb.append(number);
        }
        System.out.println(sb);
    }
}
