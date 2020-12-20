package com.haha.leetcode;

/**
 * 665. 非递减数列
 * https://leetcode-cn.com/problems/non-decreasing-array/description/
 */
public class CheckPossibility {

    public static void main(String[] args) {
        CheckPossibility checkPossibility = new CheckPossibility();
        checkPossibility.checkPossibility(new int[]{3, 4, 2, 3});
    }

    public boolean checkPossibility(int[] nums) {

        int changeTime = 0;
        //循环数组
        for (int i = 1; i < nums.length; i++) {
            //如果是非递减，则继续
            if (nums[i] >= nums[i - 1]) {
                continue;
            }
            if (i - 2 >= 0 && nums[i - 2] > nums[i]) {
                //如果前第2个数大于当前数，则必须把当前数修改为nums[i-1],保持这三个数为非递减的
                nums[i] = nums[i - 1];
            } else {
                //如果前第二个数小于当前数，则将nums[i-1]修改为nums[i],这样三个数也为非递减的
                nums[i - 1] = nums[i];
            }

            changeTime++;//记录修改次数+1;
            //快速停止
            if (changeTime > 1) {
                return false;
            }
        }

        return true;
    }
}
