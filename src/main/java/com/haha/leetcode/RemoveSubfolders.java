package com.haha.leetcode;

import java.util.*;

/**
 * 你是一位系统管理员，手里有一份文件夹列表 folder，你的任务是要删除该列表中的所有 子文件夹，并以 任意顺序 返回剩下的文件夹。
 */
public class RemoveSubfolders {

    public List<String> removeSubfolders(String[] folder) {

        //字符串从小到大排序
        Arrays.sort(folder, (item1, item2) -> item1.compareTo(item2));

        List<String> result = new ArrayList<>();

        //循环folder
        result.add(folder[0]);
        int index = 0;
        for (int i = 1; i < folder.length; i++) {
            //如果前面的数据，不是自己的子字符串，则添加到结果集
            if (folder[i].startsWith(result.get(index) + "/")) {
                result.add(folder[i]);
                index++;
            }
        }

        return result;

    }
}
