package com.frank.study.algorithm;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @ClassName: ValidataBinarySearchTree
 * @Description: TODO
 * @Author: 菜包子（孙中伟）
 * @Date: 2020/4/23 20:33
 * @Version: 1.0
 */
public class ValidataBinarySearchTree {

    public static void main(String[] args) {
        TreeNode root = stringToTreeNode("[2,1,3]");
        System.out.println(isValidBST(root));
        root = stringToTreeNode("[5,1,4,null,null,3,6]");
        System.out.println(isValidBST(root));
        root = stringToTreeNode("[10,5,15,null,null,6,20]");
        System.out.println(isValidBST(root));
    }

    public static boolean isValidBST(TreeNode root) {
        if(root == null){
            return false;
        }
        return recursor(root.left,root.val,root.val,true) && recursor(root.right,root.val,root.val,false);
    }


    public static boolean recursor(TreeNode node,Integer leftMax,Integer rightMin,Boolean ifLeft){
        if(node != null){
            if(ifLeft){
                if(node.val < leftMax){
                    return recursor(node.left,node.val,node.val,true) && recursor(node.right,node.val,node.val,false);
                }else{
                    return false;
                }
            }else {
                if(node.val > rightMin){
                    return recursor(node.left,node.val,node.val,true) && recursor(node.right,node.val,node.val,false);
                }else{
                    return false;
                }
            }
        }
        return true;
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
