package lzc.demo.algorithm.leetcode;

public class 验证回文串 {
    public static void main(String[] args) {


    }

    public static  boolean isPalindrome(String str){
        str = str.trim();
        str = str.toLowerCase();

        int i=0;
        int j= str.length() -1;
        while (i< str.length()/2){
            if(Character.isLetterOrDigit(str.charAt(i))){
                i++;
                continue;
            }
            if(Character.isLetterOrDigit(str.charAt(j))){
                j--;
                continue;
            }
            if(str.charAt(i++) != str.charAt(j--)){
                return false;
            }
        }

        return true;
    }
}