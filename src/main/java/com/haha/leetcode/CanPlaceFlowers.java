package com.haha.leetcode;

/**
 * 605. 种花问题
 * https://leetcode-cn.com/problems/can-place-flowers/
 */
public class CanPlaceFlowers {

    public static void main(String[] args) {
        CanPlaceFlowers canPlaceFlowers = new CanPlaceFlowers();
        canPlaceFlowers.canPlaceFlowers(new int[]{1, 0, 0, 0, 1}, 1);
    }

    public boolean canPlaceFlowers(int[] flowerbed, int n) {

        //初始化一个数组，用于保存之前的种花结果
        int[] preFlower = new int[flowerbed.length];
        int count = 0;
        for (int i = 0; i < flowerbed.length; i++) {
            //判断前一个位置、当前位置是否有花以及下个位置是否有花
            if (!hasFlower(preFlower, i - 1) && !hasFlower(flowerbed, i) && !hasFlower(flowerbed, i + 1)) {
                //没有花，则种花
                count++;
                preFlower[i] = 1;

            } else {
                //有花，则跳过
                preFlower[i] = flowerbed[i];
            }

            if (count >= n) {
                return true;
            }

        }
        return false;
    }

    private boolean hasFlower(int[] flowered, int index) {
        if (index >= 0 && index < flowered.length) {
            return flowered[index] == 1;
        }
        return false;
    }
}
