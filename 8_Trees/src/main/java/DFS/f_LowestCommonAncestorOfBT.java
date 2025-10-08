package main.java.DFS;

public class f_LowestCommonAncestorOfBT {
      public class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
  }

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root == null){
            return null;
        }

        if(root == p || root ==q){
            return root;
        }

        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p,q);

        // Case 1 : Root Node is the answer
        if(left!=null && right!=null){
            return root;
        }

        return (left!=null) ? left:right;
    }

}
