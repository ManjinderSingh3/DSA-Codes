package main.java;
import java.util.*;

/*
Q- Binary Tree Zigzag Level Order Traversal
   https://leetcode.com/problems/binary-tree-zigzag-level-order-traversal/description/

Time Complexity - O(N)
Space Complexity - O(N)
 */

public class iv_ZigZagLevelOrderTraversal {
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

    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if(root == null){
            return result;
        }
        Deque<TreeNode> deque = new LinkedList<>();
        deque.offer(root);
        int levelCount = 0;

        while(!deque.isEmpty()){
            int eachLevelSize = deque.size();
            List<Integer> eachLevelSublist = new ArrayList<>(eachLevelSize);
            for(int i=0;i<eachLevelSize;i++){
                if(levelCount%2==0){
                    TreeNode currentNode = deque.pollFirst();
                    eachLevelSublist.add(currentNode.val);
                    if(currentNode.left!=null){
                        deque.addLast(currentNode.left);
                    }
                    if(currentNode.right!=null){
                        deque.addLast(currentNode.right);
                    }
                }
                else{
                    TreeNode currentNode = deque.pollLast();
                    eachLevelSublist.add(currentNode.val);
                    if(currentNode.right!=null){
                        deque.addFirst(currentNode.right);
                    }
                    if(currentNode.left!=null){
                        deque.addFirst(currentNode.left);
                    }
                }
            }
            levelCount++;
            result.add(eachLevelSublist);
        }
        return result;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(3,
                new TreeNode(9),
                new TreeNode(20, new TreeNode(15), new TreeNode(7)));


        iv_ZigZagLevelOrderTraversal solution = new iv_ZigZagLevelOrderTraversal();
        List<List<Integer>> levels = solution.zigzagLevelOrder(root);

        System.out.println("Zig Zag Level Order :");
        for (List<Integer> level : levels) {
            System.out.println(level);
        }
    }


}
