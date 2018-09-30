package com.vanxd;

import java.util.Arrays;

/**
 * 给定字符串J 代表石头中宝石的类型，和字符串 S代表你拥有的石头。 S 中每个字符代表了一种你拥有的石头的类型，你想知道你拥有的石头中有多少是宝石。
 *
 * J 中的字母不重复，J 和 S中的所有字符都是字母。字母区分大小写，因此"a"和"A"是不同类型的石头。
 *
 * 示例 1:
 *
 * 输入: J = "aA", S = "aAAbbbb"
 * 输出: 3
 * 示例 2:
 *
 * 输入: J = "z", S = "ZZ"
 * 输出: 0
 * 注意:
 *
 * S 和 J 最多含有50个字母。
 * J 中的字符不重复。
 */
public class JewelsandStones {
    public static void main(String[] args) {
        JewelsandStones a = new JewelsandStones();
        System.out.println(a.numJewelsInStones3("bcd", "cba"));
        System.out.println(a.numJewelsInStones3("dbca", "beb"));
        System.out.println(a.numJewelsInStones3("aA", "aAAbbbb"));
        System.out.println(a.numJewelsInStones3("z", "ZZ"));
    }

    /**
     * 还是最简单的快, 但是应该和数据长度有关系,
     * 下面两种方法,数据越长重复的越多效果越好
     *
     * 执行用时: 19 ms, 在Jewels and Stones的Java提交中击败了59.22% 的用户
     * @param J
     * @param S
     * @return
     */
    public int numJewelsInStones3(String J, String S) {
        int count = 0;
        for (char c : S.toCharArray()){
            if(J.indexOf(c) != -1){
                count++;
            }
        }
        return count;
    }

    /**
     * 执行用时: 22 ms, 在Jewels and Stones的Java提交中击败了45.31% 的用户
     * @param J
     * @param S
     * @return
     */
    public int numJewelsInStones2(String J, String S) {
        char[] sArray = S.toCharArray();
        Arrays.sort(sArray);
        S = String.valueOf(sArray);
        char[] jArray = J.toCharArray();
        Arrays.sort(jArray);
        int count = 0;
        for (int i = 0; i < sArray.length;) {
            int pos = Arrays.binarySearch(jArray, sArray[i]);
            if (pos > -1) {
                int lastPos = S.lastIndexOf(sArray[i]) + 1;
                int gap = lastPos - i;
                count += gap;
                i+= gap;
            } else {
                i++;
            }
        }
        return count;
    }

    /**
     * 28 ms
     * @param J
     * @param S
     * @return
     */
    public int numJewelsInStones1(String J, String S) {
        char[] sArray = S.toCharArray();
        Arrays.sort(sArray);
        S = String.valueOf(sArray);
        char[] chars = J.toCharArray();
        int count = 0;
        for (int i = 0; i < chars.length; i++) {
            int tmp = 0;
            int lastPos = S.lastIndexOf(chars[i]);
            if (lastPos == -1) {
                continue;
            } else {
                tmp = (lastPos + 1) - S.indexOf(chars[i]);
            }
            count += tmp;
        }
        return count;
    }
}
