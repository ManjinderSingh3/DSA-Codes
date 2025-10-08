package main.java.DFS;

public class b_InvertBinaryTree {
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

      public TreeNode invertTree(TreeNode root) {
          if(root == null){
              return null;
          }

          TreeNode leftTree = invertTree(root.left);
          TreeNode rightTree = invertTree(root.right);

          root.left = right;
          root.right = left;

          return root;
      }
  }
}
