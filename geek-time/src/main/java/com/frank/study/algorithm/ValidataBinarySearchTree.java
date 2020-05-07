package com.frank.study.algorithm;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @ClassName: ValidataBinarySearchTree
 * @Description:
 * 98. 验证二叉搜索树
 * 给定一个二叉树，判断其是否是一个有效的二叉搜索树。
 *
 * 假设一个二叉搜索树具有如下特征：
 *
 * 节点的左子树只包含小于当前节点的数。
 * 节点的右子树只包含大于当前节点的数。
 * 所有左子树和右子树自身必须也是二叉搜索树。
 * 示例 1:
 *
 * 输入:
 *     2
 *    / \
 *   1   3
 * 输出: true
 * 示例 2:
 *
 * 输入:
 *     5
 *    / \
 *   1   4
 *      / \
 *     3   6
 * 输出: false
 * 解释: 输入为: [5,1,4,null,null,3,6]。
 *      根节点的值为 5 ，但是其右子节点值为 4 。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/validate-binary-search-tree
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @Author: frank
 * @Date: 2020/4/23 20:33
 * @Version: 1.0
 */
public class ValidataBinarySearchTree {

    public static void main(String[] args) {
        TreeNode root = stringToTreeNode("[2,1,3]");
        System.out.println(isValidBST(root));
        root = stringToTreeNode("[5,1,4,null,null,3,6]");
        System.out.println(isValidBST(root));
        TreeNode root2 = stringToTreeNode("[10,5,15,null,null,6,20]");
        System.out.println(isValidBST(root2));
        TreeNode root3 = stringToTreeNode("[3,1,5,0,2,4,6,null,null,null,3]");
        System.out.println(isValidBST(root3));
        TreeNode root4 = stringToTreeNode("[3,2,null,1,-2147483648]");
        System.out.println(isValidBST(root4));
        TreeNode root5 = stringToTreeNode("[3,1,5,0,2,4,6]");
        System.out.println(isValidBST(root5));
        TreeNode root6 = stringToTreeNode("[3,1,5,0,2,4,6,null,null,null,3]");
        System.out.println(isValidBST(root6));
    }

    public static boolean isValidBST(TreeNode root) {
        if(root == null){
            return false;
        }
        return  recursor(root.left,root.val,null) && recursor(root.right,null,root.val);
    }


    public static boolean recursor(TreeNode node,Integer upperLimit,Integer downLimit){
        if(node == null){
            return true;
        }
        if( upperLimit == null || (upperLimit != null && node.val < upperLimit)){
            if(downLimit == null || (downLimit != null && node.val > downLimit)){
                return  recursor(node.left,node.val,downLimit) && recursor(node.right,upperLimit,node.val);
            }
        }
        return false;
    }

    public static TreeNode stringToTreeNode(String input) {
        input = input.trim();
        input = input.substring(1, input.length() - 1);
        if (input.length() == 0) {
            return null;
        }

        String[] parts = input.split(",");
        String item = parts[0];
        TreeNode root = new TreeNode(Integer.parseInt(item));
        Queue<TreeNode> nodeQueue = new LinkedList<>();
        nodeQueue.add(root);

        int index = 1;
        while(!nodeQueue.isEmpty()) {
            TreeNode node = nodeQueue.remove();

            if (index == parts.length) {
                break;
            }

            item = parts[index++];
            item = item.trim();
            if (!item.equals("null")) {
                int leftNumber = Integer.parseInt(item);
                node.left = new TreeNode(leftNumber);
                nodeQueue.add(node.left);
            }

            if (index == parts.length) {
                break;
            }

            item = parts[index++];
            item = item.trim();
            if (!item.equals("null")) {
                int rightNumber = Integer.parseInt(item);
                node.right = new TreeNode(rightNumber);
                nodeQueue.add(node.right);
            }
        }
        return root;
    }


    static class TreeNode{
        private Integer val;
        private TreeNode left;
        private TreeNode right;

        public TreeNode(Integer data) {
            this.val = data;
        }

        public Integer getData() {
            return val;
        }

        public TreeNode getLeft() {
            return left;
        }

        public void setLeft(TreeNode left) {
            this.left = left;
        }

        public TreeNode getRight() {
            return right;
        }

        public void setRight(TreeNode right) {
            this.right = right;
        }
    }
}
