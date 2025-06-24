package main.java.BFS;
import java.util.*;

public class viii_SymmetricTree {
  public class TreeNode {
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
    
    public boolean isSymmetric(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        // Skipping Root node
        queue.offer(root.left);
        queue.offer(root.right);

        while(!queue.isEmpty()){
            TreeNode left = queue.poll();
            TreeNode right = queue.poll();

            // If both left and right odon't do anything
            if(left == null && right == null){
                continue;
            }

            if(left==null || right==null){
                return false;
            }

            if(left.val != right.val){
                return false;
            }

            queue.offer(left.left);
            queue.offer(right.right);
            queue.offer(left.right);
            queue.offer(right.left);
        }
        return true ;
    }
}
