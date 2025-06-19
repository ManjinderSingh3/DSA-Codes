package main.java;
import java.util.*;

public class ii_AverageOfLevelsInBinaryTree {
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

    public List<Double> averageOfLevels(TreeNode root) {
        List<Double> result = new ArrayList<>();
        if(root == null){
            return result;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        while(!queue.isEmpty()){
            int eachLevelSize = queue.size();
            double eachLevelAverage = 0, eachLevelSum =0;
            for(int i=0; i<eachLevelSize; i++){
                TreeNode currentNode = queue.poll();
                eachLevelSum += currentNode.val;
                if(currentNode.left!=null){
                    queue.offer(currentNode.left);
                }
                if(currentNode.right!=null){
                    queue.offer(currentNode.right);
                }
            }
            eachLevelAverage = eachLevelSum/eachLevelSize;
            result.add(eachLevelAverage);
        }
        return result;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(3,
                new TreeNode(9, new TreeNode(9), null),
                new TreeNode(3, new TreeNode(5), new TreeNode(6)));

        ii_AverageOfLevelsInBinaryTree solution = new ii_AverageOfLevelsInBinaryTree();
        List<Double> averages = solution.averageOfLevels(root);

        System.out.println("Average of Each Level");
        for (Double average : averages) {
            System.out.println(average);
        }
    }
}
