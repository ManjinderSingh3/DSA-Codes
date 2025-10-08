package main.java.DFS.Advance;
import  java.util.*;

public class ii_ConstructBTfromPreorderAndInorder {
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

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        Map<Integer, Integer> map = new HashMap<>();
        for(int i=0; i<inorder.length; i++){
            map.put(inorder[i], i);
        }
        int[] index = {0};
        return helper(preorder, inorder, 0, preorder.length-1, map, index) ;
    }

    private TreeNode helper(int[] preorder, int[] inorder, int left, int right, Map<Integer,Integer> map, int[] index) {
        if(left > right){
            return null;
        }
        int current = preorder[index[0]];
        index[0]++;

        TreeNode node = new TreeNode(current);
        int mapIndex = map.get(current);

        if(left==right){
            return node;
        }

        node.left = helper(preorder, inorder, left, mapIndex-1, map, index);
        node.right = helper(preorder, inorder, mapIndex+1, right, map, index);

        return node;

    }
}
