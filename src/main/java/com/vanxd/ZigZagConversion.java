package com.vanxd;

/**
 * 之字形图案
 * convert("PAYPALISHIRING", 3) should return "PAHNAPLSIIGYIR".
 *  P   A   H   N
 *  A P L S I I G
 *  Y   I   R
 *
 * @author wyd on 2016/12/5.
 */
public class ZigZagConversion {

    public static void main(String[] args) {
        System.out.println(convert("PAYPALISHIRINGASDFAFDSA", 4));
    }

    public static String convert(String s, int numRows) {
        char[] c = s.toCharArray();
        int len = c.length;
        // 模拟二维字符串数组,形成之字图形
        StringBuilder[] sb = new StringBuilder[numRows];
        for (int i = 0; i < sb.length; i++) sb[i] = new StringBuilder();

        // 循环一遍，用c[i]来获取该坐标数据
        // 关键在于这个i要单独记，不能归0，后续在二维数组中做垂直方向的获取和斜向的获取
        // 向斜其实是顶部和底部不设置值
        // 一次while 设置两列值，第一个for设置从上往下的值，第二个for设置从下斜向上的值
        int i = 0;
        while (i < len) {
            for (int idx = 0; idx < numRows && i < len; idx++) {
                // 从上往下：其实只用按顺序获得每一位放入就行。
                sb[idx].append(c[i++]);
            }
            // 从下斜向上 获得二维数组的倒数第2行开始往上递减
            for (int idx = numRows - 2; idx >= 1 && i < len; idx--) {
                // obliquely up
                sb[idx].append(c[i++]);
            }
        }
        for (int idx = 1; idx < sb.length; idx++)
            sb[0].append(sb[idx]);
        return sb[0].toString();
    }
}
