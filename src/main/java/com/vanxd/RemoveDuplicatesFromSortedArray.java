package com.vanxd;

public class RemoveDuplicatesFromSortedArray {
    public static void main(String[] args) {
        RemoveDuplicatesFromSortedArray instance = new RemoveDuplicatesFromSortedArray();
        System.out.println(instance.removeDuplicates(new int[]{1}));
    }

    /**
     * 快慢指针
     * 1.快指针遍历整个数组
     * 2.快 与 慢不相等时，++慢，将快的值复制到慢的位置
     * @param nums
     * @return 慢 + 1 (因为leetcode要的是取掉重复数字后数组的长度，所以数组的下标需要+1)
     */
    public int removeDuplicates(int[] nums) {
        int fast = 0, slow = 0;
        for (;fast < nums.length; fast++) {
            if (nums[fast] != nums[slow]) {
                nums[++slow] = nums[fast];
            }
        }
        return slow + 1;
    }
}
