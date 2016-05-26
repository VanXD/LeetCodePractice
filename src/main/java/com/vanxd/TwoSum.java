package com.vanxd;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

/**
 * Created by wyd on 2016/5/26.
 */
public class TwoSum {
    public static void main(String[] args) {
        int[] twoSum = new TwoSum().twoSum(new int[]{3, 2, -1, 4, -8}, -9);
        for(int i : twoSum) {
            System.out.println(i);
        }
    }

    /**
     * 1.sort nums for binary search
     * 2.traverse the whole array got one result if exist target - nums[i]
     * 3.there is a var aResult and is a Integer default null
     * 4.when 2 get anser save in aResult and bResult
     * 5.search index of aResult and bResult
     * 6.return res
     *
     * @param nums
     * @param target
     * @return
     */
    public int[] twoSum(int[] nums, int target) {
        int[] res = new int[2];
        int[] copyNums = Arrays.copyOf(nums, nums.length);
        Arrays.sort(nums);
        Integer aResult = null;
        int bResult = 0;
        int length = nums.length;
        int aTmplIndex = -1;
        for(int i = 0;i < length; i++) {
            aTmplIndex = Arrays.binarySearch(nums, target - nums[i]);
            if(aTmplIndex > -1) {
                aResult = nums[aTmplIndex];
                bResult = nums[i];
                break;
            }
        }
        if(aResult == null) {
            return res;
        }
        int index = 0;
        for(int i = 0;i < length; i++) {
            if(copyNums[i] == aResult || copyNums[i] == bResult) {
                if(index == 0) {
                    res[0] = i;
                    index++;
                } else {
                    if(copyNums[i] + copyNums[res[0]] == target) {
                        res[1] = i;
                        break;
                    }
                }
            }
        }
        return res;
    }
}
