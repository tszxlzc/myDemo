package lzc.demo.algorithm.leetcode;

public class MaxArea {
    public static void main(String[] args) {

    }

    public int maxArea(int[] height) {
        int maxArea = 0;
        for(int i=0; i< height.length-1;i++){
            for (int j=i+1;j<height.length; j++){
                maxArea = Math.max(maxArea,Math.min(height[i],height[j]) * (j-i));
            }
        }
        return maxArea;
    }
}