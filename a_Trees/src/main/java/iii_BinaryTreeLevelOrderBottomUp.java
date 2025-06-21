package main.java;
import java.util.*;
/*
Q- Binary Tree Level Order Traversal II
   https://leetcode.com/problems/binary-tree-level-order-traversal-ii/description/

Time Complexity - O(N)
Space Complexity - O(N)
 */

public class iii_BinaryTreeLevelOrderBottomUp {
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode() {}
        TreeNode(int val) { this.val = val; }
        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if(root ==null){
            return result;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while(!queue.isEmpty()){
            int eachLevelSize = queue.size();
            List<Integer> eachLevelList = new ArrayList<>(eachLevelSize);
            for(int i=0; i<eachLevelSize;i++){
                TreeNode currentNode = queue.poll();
                eachLevelList.add(currentNode.val);
                if(currentNode.left!=null){
                    queue.offer(currentNode.left);
                }
                if(currentNode.right!=null){
                    queue.offer(currentNode.right);
                }
            }
            result.add(eachLevelList);
        }
        Collections.reverse(result);
        return result;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(3,
                new TreeNode(9),
                new TreeNode(20, new TreeNode(15), new TreeNode(7)));


        iii_BinaryTreeLevelOrderBottomUp solution = new iii_BinaryTreeLevelOrderBottomUp();
        List<List<Integer>> levels = solution.levelOrderBottom(root);

        System.out.println("Bottom Up Level Order :");
        for (List<Integer> level : levels) {
            System.out.println(level);
        }
    }
}
