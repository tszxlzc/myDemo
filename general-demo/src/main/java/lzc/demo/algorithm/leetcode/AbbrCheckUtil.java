package lzc.demo.algorithm.leetcode;

/**
 * 题目 ： 缩写校验（建议时间复杂度 O(n) ）
 * 给定⼀一个⾮非空字符串串 s 和⼀一个缩写 abbr，请校验它们是否匹配。
 * 假设字符串串中只包含⼩小写字⺟母，缩写中只包含⼩小写字⺟母和数字。缩写中的数字
 * 表示其缩略略的字符数；连续多位数字表示⼀一个多位数。
 * 例例如，字符串串 “word” 的缩写有且仅有以下这些：[“word", "1ord", "w1rd",
 * "wo1d", "wor1", "2rd", "w2d", "wo2", "1o1d", "1or1", "w1r1", "1o2", "2r1", "3d",
 * "w3", “4"]。
 * 例例 1：输⼊入：s = “internationalization"，abbr = "i12iz4n"
 * 返回：true
 * 解释：abbr 中的 12 表示有⼗十⼆二个字符被缩略略了了。
 * 例例 2：输⼊入：s = “apple"，abbr = “a2e"
 * 返回：false
 * 需要实现的⽅方法原型：boolean valid(String word, String abbr)
 * @author liuzongchang
 * @version 1.0  2019/6/6 17:58
 */
public class AbbrCheckUtil {
    public static void main(String[] args) {

//        String word = "internationalization";
//        String abbr = "i12iz4n";

        String word = "word";
        String abbr = "1ord";
        String abbr1 = "w1rd";
        String abbr2 = "wo1d";
        String abbr3 = "wor1";
        String abbr4 = "2rd";
        String abbr5 = "w2d";
        String abbr6 = "wo2";
        String abbr7 = "1o1d";
        String abbr8 = "1or1";
        String abbr9 = "w1r1";
        String abbr10 = "1o2";
        String abbr11 = "2r1";
        String abbr12 = "3d";
        String abbr13 = "w3";
        String abbr14 = "4";

        System.out.println(valid(word,word));
        System.out.println(valid(word,abbr));
        System.out.println(valid(word,abbr1));
        System.out.println(valid(word,abbr2));
        System.out.println(valid(word,abbr3));
        System.out.println(valid(word,abbr4));
        System.out.println(valid(word,abbr5));
        System.out.println(valid(word,abbr6));
        System.out.println(valid(word,abbr7));
        System.out.println(valid(word,abbr8));
        System.out.println(valid(word,abbr9));
        System.out.println(valid(word,abbr10));
        System.out.println(valid(word,abbr11));
        System.out.println(valid(word,abbr12));
        System.out.println(valid(word,abbr13));
        System.out.println(valid(word,abbr14));
        System.out.println(valid(word,"1111"));
        System.out.println(valid("internationalization","i12iz4n"));
        System.out.println(valid("internationalizatio","i12iz4n"));
        System.out.println(valid("apple","a2e"));

    }

    /**
     * 校验缩写
     * @param word
     * @param abbr
     * @return
     */
    public static boolean valid(String word, String abbr){
        if(word == null || abbr == null){
            return false;
        }

        //记录缩写中的连续数字
        int num = 0;
        // 记录缩写中的数字之和
        int totalAbbrNum = 0;
        //数字在缩写中出现的次数
        int nums = 0;
        for (int i = 0; i< abbr.length(); i++){
             char character = abbr.charAt(i);
             //数字计数
             if('0'<=character && character<='9'){
                 num = num * 10 + Integer.parseInt(String.valueOf(character));
                 nums++;
                 continue;
             }

             //数字求和
            totalAbbrNum += num;
            num =0;

             if (word.length() < i + totalAbbrNum - nums +1){
                 // 字符串长度小于缩写长度，提前退出返回false
                 return false;
             }else if(character == word.charAt(totalAbbrNum - nums + i)){
                 // 字符相等，继续循环
                 continue;
             }else{
                return false;
            }
        }

        totalAbbrNum += num;
        //缩写中纯数字的情况
        if(totalAbbrNum == 0 && word.length() ==abbr.length()){
            return true;
        }
        // 字符串长度，超过缩写字符长度（含数字时进行累加）的情况
        if(word.length() > abbr.length() + totalAbbrNum - nums){
            return false;
        }
        return true;
    }
}