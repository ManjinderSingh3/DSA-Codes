package main.java.DFS.Advance;

public class i_KthSmallestElementInBST {
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

// Brute - force solution
    /*
      public int kthSmallest(TreeNode root, int k) {

        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        helper (root, k, minHeap);
        int kthSmallestValue = 0;
        for(int i= 0; i<k;i++){
            kthSmallestValue = minHeap.poll();
        }
        return kthSmallestValue;
    }
    private void helper(TreeNode node, int k, PriorityQueue<Integer> minHeap){
        if(node == null){
            return;
        }
        helper(node.left, k, minHeap);
        minHeap.offer(node.val);
        helper(node.right, k, minHeap);
    }
  }
       */

  // Optimized Solution
  private int answer;
  private int k;
  public int kthSmallest(TreeNode root, int k) {
      this.k = k;
      helper(root);
      return answer;
  }
  private void helper(TreeNode node){
      if(node==null){
          return;
      }
      helper(node.left);
      k--;
      if(k==0){
          answer = node.val;
          return;
      }
      helper(node.right);
  }



}
