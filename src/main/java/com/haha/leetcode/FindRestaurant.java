package com.haha.leetcode;

import java.util.*;
import java.util.stream.Stream;

public class FindRestaurant {

    public static void main(String[] args) {
        FindRestaurant findRestaurant = new FindRestaurant();
        String[] list1 = new String[]{"Shogun", "Tapioca Express", "Burger King", "KFC"};
        String[] list2 = new String[]{"KFC", "Shogun", "Burger King"};
        findRestaurant.findRestaurant(list1, list2);
    }

    public String[] findRestaurant(String[] list1, String[] list2) {

        //记录每个餐厅的索引
        Map<String, Integer> map1 = new HashMap<>();

        for (int i = 0; i < list1.length; i++) {
            map1.put(list1[i], i);
        }

        List<String> res = new ArrayList<>();
        int count = Integer.MAX_VALUE;

        for (int j = 0; j < list2.length; j++) {
            if (map1.containsKey(list2[j])) {
                Integer index = map1.get(list2[j]);
                if (index + j < count) {
                    res.clear();
                    res.add(list2[j]);

                }
                if (index + j == count) {
                    res.add(list2[j]);
                }

                count = index + j;
            }
        }

        String[] result = new String[res.size()];
        for (int i = 0; i < res.size(); i++) {
            result[i] = res.get(i);
        }
        return result;
    }
}
