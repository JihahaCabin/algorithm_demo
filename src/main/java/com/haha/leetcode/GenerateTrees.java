package com.haha.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * 95. 不同的二叉搜索树 II
 * https://leetcode-cn.com/problems/unique-binary-search-trees-ii/
 * 给定一个整数 n，生成所有由 1 ... n 为节点所组成的 二叉搜索树 。
 * 二叉搜索树，每个节点的左子节点小于本身，每个节点的右子节点大于本身
 */
public class GenerateTrees {
    public List<TreeNode> generateTrees(int n) {
        //特判
        if (n < 1) {
            return new ArrayList<>();
        }

        return generateSubTrees(1, n);

    }

    /**
     * @param start 开始值
     * @param end   结束值
     * @return
     */
    private List<TreeNode> generateSubTrees(int start, int end) {
        List<TreeNode> result = new ArrayList<>();

        if (start > end) {
            result.add(null);
            return result;
        }

        for (int i = start; i <= end; i++) {
            //生成所有可能的左右子树
            List<TreeNode> leftTree = generateSubTrees(start, i - 1);
            List<TreeNode> rightTree = generateSubTrees(i + 1, end);

            for (TreeNode leftNode : leftTree) {
                for (TreeNode rightNode : rightTree) {
                    TreeNode treeNode = new TreeNode(i);
                    treeNode.left = leftNode;
                    treeNode.right = rightNode;
                    result.add(treeNode);
                }
            }
        }
        return result;
    }
}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode() {

    }

    TreeNode(int val) {
        this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}