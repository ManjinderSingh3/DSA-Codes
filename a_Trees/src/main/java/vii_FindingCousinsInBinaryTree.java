package main.java;
import java.util.*;

public class vii_FindingCousinsInBinaryTree {
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

    public boolean isCousins(TreeNode root, int x, int y) {
        if(root==null){
            return false;
        }
        TreeNode xNode = findNode(root,x);
        TreeNode yNode = findNode(root,y);

        return((level(root,xNode,0)==level(root,yNode,0)) && (!isSibling(root, xNode, yNode)));
    }

    TreeNode findNode(TreeNode node, int x){
        if(node == null){
            return null;
        }

        if(node.val == x){
            return node;
        }

        TreeNode nodeInLeftTree = findNode(node.left,x);
        if(nodeInLeftTree != null){
            return nodeInLeftTree;
        }
        return findNode(node.right, x);
    }



    boolean isSibling(TreeNode node, TreeNode x, TreeNode y ){
        if(node==null){
            return false;
        }
        return ( (node.left == x && node.right == y) || (node.left == y && node.right ==x )
                || isSibling(node.left,x,y) || isSibling(node.right,x,y));

    }

    int level(TreeNode node, TreeNode x, int level){
        if(node==null){
            return 0;
        }

        if(node==x){
            return level;
        }

        int lev = level(node.left,x,level+1);
        if(lev!=0){
            return lev;
        }
        return level(node.right,x,level+1);

    }
}
