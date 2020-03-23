package lzc.demo.algorithm.leetcode;

public class MaxDepth {
    public static void main(String[] args) {

    }

    public static int maxDepth(TreeNode root){
        if(root == null){
            return 0;
        }
        int right = maxDepth(root.right);
        int left = maxDepth(root.left);
        return Math.max(right,left) + 1;
    }

    public static int minDepth(TreeNode root){

        if(root == null){
            return 0;
        }
        if((root.left == null) && (root.right == null)){
            return 1;
        }

        int minDepth = Integer.MAX_VALUE;
        if(root.left != null){
            minDepth = Math.min(minDepth,minDepth(root.left));
        }
        if(root.right != null){
            minDepth = Math.min(minDepth,minDepth(root.right));
        }

        return minDepth + 1;
    }

}