package lzc.demo.algorithm.leetcode;

import java.util.HashSet;
import java.util.Set;

/**
 * 最长子串的长度
 */
public class LengthOfLongestSubString {

    public static void main(String[] args) {
        System.out.print(longest("123cafbffsfk"));
    }

   private static int longest(String s){
        int length = s.length();
        Set<Character> window = new HashSet<>();
        int longest = 0;
        int i=0,j=0;
        while (i<length && j< length){
            if(!window.contains(s.charAt(j))){
                window.add(s.charAt(j++));
                longest = Math.max(longest,j-i);
            }else {
                window.remove(s.charAt(i++));
            }
        }

        return longest;
   }
}