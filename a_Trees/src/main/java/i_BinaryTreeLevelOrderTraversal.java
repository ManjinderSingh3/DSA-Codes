package main.java;
import java.util.*;
/*
Question - Binary Tree Level Order Traversal

Time Complexity : O(N)
Space Complexity : O(N)
 */
public class i_BinaryTreeLevelOrderTraversal {
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
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if(root == null){
            return result;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while(!queue.isEmpty()){
            int eachLevelSize = queue.size();
            List<Integer> eachLevelList = new ArrayList<>();
            for(int i=0; i<eachLevelSize; i++){
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
        return result;

    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1,
                new TreeNode(2, new TreeNode(4), null),
                new TreeNode(3, new TreeNode(5), new TreeNode(6)));

        i_BinaryTreeLevelOrderTraversal solution = new i_BinaryTreeLevelOrderTraversal();
        List<List<Integer>> levels = solution.levelOrder(root);

        System.out.println("Level order traversal:");
        for (List<Integer> level : levels) {
            System.out.println(level);
        }

    }
}
