package main.java.DFS;

public class a_DiameterOfBinaryTree {

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

     int diameter = 0;
     public int diameterOfBinaryTree(TreeNode root) {
         height(root);
         return diameter;
     }

     int height(TreeNode node){
         if(node==null){
             return 0;
         }

         int left = height(node.left);
         int right = height(node.right);

         int dia = left+right+1;
         diameter = Math.max(diameter, dia);

         return Math.max(left,right)+1;
     }
  }

}
