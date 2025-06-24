package main.java.DFS;

import java.util.*;

public class e_FlattenBinaryTreeToLinkedList {
    public class TreeNode {
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

    Queue<TreeNode> queue = new LinkedList<>();

    /*
     Time Complexity : O(n)
     Space Complexity : O(n)
    */
    public void flattenApproach1(TreeNode root) {
        if (root == null) {
            return;
        }
        insertInQueue(root);
        TreeNode previousNode = queue.poll();
        while (!queue.isEmpty()) {
            TreeNode currentNode = queue.poll();
            previousNode.left = null;
            previousNode.right = currentNode;
            previousNode = currentNode;
        }
    }

    private void insertInQueue(TreeNode node) {
        if (node == null) {
            return;
        }
        queue.offer(node);
        insertInQueue(node.left);
        insertInQueue(node.right);
    }


    /*
     Better Space Complexity Solution

     Time Complexity : O(n)
     Space Complexity : O(1)
     */
    public void flatten(TreeNode root) {
        if(root==null){
            return;
        }
        TreeNode current = root;
        while(current!=null){
            if(current.left!=null){
                TreeNode temp = current.left;
                while(temp.right!=null){
                    temp = temp.right;
                }
                temp.right = current.right;
                current.right = current.left;
                current.left=null;
            }
            current = current.right;
        }
    }


}
