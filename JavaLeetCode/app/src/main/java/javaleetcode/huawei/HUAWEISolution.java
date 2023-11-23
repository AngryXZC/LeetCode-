package javaleetcode.huawei;

import java.lang.reflect.Array;
import java.util.*;

public class HUAWEISolution {
    /**
     * 1. 两数之和
     * 给定一个整数数组 nums 和一个整数目标值 target，请你在该数组中找出 和为目标值 target  的那 两个 整数，并返回它们的数组下标。
     *
     * 你可以假设每种输入只会对应一个答案。但是，数组中同一个元素在答案里不能重复出现。
     *
     * 你可以按任意顺序返回答案
     * */
    public int[] twoSum(int[] nums, int target) {
        // 创建一个HashMap，用于存储数字和它们的索引
        HashMap<Integer, Integer> numToIndex = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int complement = target - nums[i];
            // 如果配对元素在HashMap中，返回它们的索引
            if (numToIndex.containsKey(complement)) {
                return new int[]{numToIndex.get(complement), i};
            }
            // 否则，将当前元素及其索引添加到HashMap中
            numToIndex.put(nums[i], i);
        }

        // 如果没有找到答案，返回一个空数组或者null，取决于你的喜好
        return new int[0];
    }
    /**
     * 2.两数相加
     * 你两个 非空 的链表，表示两个非负的整数。它们每位数字都是按照 逆序 的方式存储的，并且每个节点只能存储 一位 数字。
     *
     * 请你将两个数相加，并以相同形式返回一个表示和的链表。
     *
     * 你可以假设除了数字 0 之外，这两个数都不会以 0 开头。
     * */
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode head=new ListNode(-1,null),q=head;//结果和和遍历引用
        int carray=0;//进位,加位
        while (l1!=null||l2!=null){
            int temp= (l1==null?0:l1.val)+(l2==null?0:l2.val)+carray;
            carray=temp/10;
            temp=temp%10;
            q.next=new ListNode(temp,null);
            q=q.next;
            if(l1!=null)
                l1=l1.next;
            if (l2!=null)
                l2=l2.next;
        }
        if(carray!=0){//单独处理进位
            q.next=new ListNode(carray,null);
        }
        return  head.next;
    }
    /**
   3.无重复字符的最长子串
     给定一个字符串 s ，请你找出其中不含有重复字符的 最长子串的长度。
   */
    //用集合做的
    public int lengthOfLongestSubstrin(String s){
        int max=0,startPosition=0;//startPosition记录下次i开始的位置
        HashSet<Character> charSet=new HashSet<>();
        for (int i=0;i<s.length();) {
            char c= s.charAt(i);
            if(charSet.contains(c)){
                startPosition++;
                i=startPosition;
                charSet.clear();
            }
            else{
                charSet.add(c);
                i++;
                if(max<charSet.size())
                    max=charSet.size();
            }
        }
        return  max;
    }
    //最佳解



    public int lengthOfLongestSubstring(String s){

        if (s.length()==0) return 0;
        HashMap<Character, Integer> map = new HashMap<Character, Integer>();
        int max = 0;
        int left = 0;
        for(int i = 0; i < s.length(); i ++){
            if(map.containsKey(s.charAt(i))){
                left = Math.max(left,map.get(s.charAt(i)) + 1);
            }
            map.put(s.charAt(i),i);
            max = Math.max(max,i-left+1);
        }
        return max;

    }


    /**
     * 4.给定两个大小分别为 m 和 n 的正序（从小到大）数组 nums1 和 nums2。
     * 请你找出并返回这两个正序数组的 中位数 。
     * 算法的时间复杂度应该为 O(log (m+n)) 。
     * TODO
     * 1.归并合并数组
     * 2.二分查找的思想
    */

    public  double findMedianSortedArraysMethod1(int[] nums1,int[]nums2){
        int[] mergeRes=new int[nums1.length+nums2.length];
        int i=0,j=0,k=0;
        while (i<nums1.length&&j<nums2.length){
            if(nums1[i]<nums2[j])
            {
                mergeRes[k++]=nums1[i++];
            }
            else {
                mergeRes[k++]=nums2[j++];
            }
        }
        //nums1全部合并完
        if(i==nums1.length){
            for (;j<nums2.length;j++){
                mergeRes[k++]=nums2[j];
            }
        }
        else  for (;i<nums1.length;i++){
            mergeRes[k++]=nums1[i];
        }
        if(mergeRes.length%2==0){
            return (mergeRes[mergeRes.length/2-1]+ mergeRes[ mergeRes.length/2])/2.0;
        }
        else {
            return  mergeRes[mergeRes.length/2];
        }
    }
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        if (nums1.length > nums2.length) {
            int[] temp = nums1;
            nums1 = nums2;
            nums2 = temp;
        }

        int m = nums1.length;
        int n = nums2.length;
        int imin = 0, imax = m, halfLen = (m + n + 1) / 2;

        while (imin <= imax) {
            int i = (imin + imax) / 2;
            int j = halfLen - i;

            if (i < m && nums2[j - 1] > nums1[i]) {
                imin = i + 1;
            } else if (i > 0 && nums1[i - 1] > nums2[j]) {
                imax = i - 1;
            } else {
                int maxOfLeft, minOfRight;
                if (i == 0) {
                    maxOfLeft = nums2[j - 1];
                } else if (j == 0) {
                    maxOfLeft = nums1[i - 1];
                } else {
                    maxOfLeft = Math.max(nums1[i - 1], nums2[j - 1]);
                }

                if ((m + n) % 2 == 1) {
                    return maxOfLeft;
                }

                if (i == m) {
                    minOfRight = nums2[j];
                } else if (j == n) {
                    minOfRight = nums1[i];
                } else {
                    minOfRight = Math.min(nums1[i], nums2[j]);
                }

                return (maxOfLeft + minOfRight) / 2.0;
            }
        }

        return 0.0;
    }
    /**
     * 5. 最长回文子串
     * 给你一个字符串 s，找到 s 中最长的回文子串。
     * 如果字符串的反序与原始字符串相同，则该字符串称为回文字符串。
     * TODO
     * */
    //自己写的暴力破解
    public String longestPalindrome(String s) {
        int len=0;
        HashMap<String,Integer> resMap=new HashMap<>();
        for (int j=0;j<s.length();j++){
            for (int i=j;i<=s.length();i++){
                String temp=s.substring(j,i);
                if(judgeIsPalindrome(temp)){
                    len=temp.length();
                    resMap.put(temp,len);
                }
            }
        }
        int max=0;
        String res="";
        for (String key:
                resMap.keySet()) {
            if(max<resMap.get(key)){
                max=resMap.get(key);
                res=key;
            }
        }
        return res;
    }
    public boolean judgeIsPalindrome(String s){
        boolean flag=true;
        for (int i=0;i<s.length()/2;i++){
            if(s.charAt(i)!=s.charAt(s.length()-1-i))
                flag=false;
        }
        return  flag;
    }

    //动态规划
    public String longestPalindromeDP(String s) {
        int n = s.length();
        // 创建一个二维数组 dp，其中 dp[i][j] 表示 s[i:j+1] 是否是回文子串
        boolean[][] dp = new boolean[n][n];

        int start = 0;
        int maxLen = 1;

        // 所有长度为 1 的子串都是回文子串
        for (int i = 0; i < n; i++) {
            dp[i][i] = true;
        }

        // 遍历所有长度大于 1 的子串
        for (int len = 2; len <= n; len++) {
            for (int i = 0; i <= n - len; i++) {
                int j = i + len - 1;

                // 对于长度大于 2 的子串，判断首尾字符是否相等，并且去掉首尾后的子串是否是回文
                if (s.charAt(i) == s.charAt(j) && (len == 2 || dp[i + 1][j - 1])) {
                    dp[i][j] = true;
                    // 更新最长回文子串的起始位置和长度
                    if (len > maxLen) {
                        start = i;
                        maxLen = len;
                    }
                }
            }
        }

        return s.substring(start, start + maxLen);
    }

    //leetCode官方的暴力解法
    public String longestPalindromeL(String s){
        int len=s.length();
        if(len<2)
            return  s;
        int maxLen=1;
        int begin=0;

        char[] charArray=s.toCharArray();
        //枚举所有长度严格大于1的子串 charArray[i...j]
        for (int i=0;i<len-1;i++){
            for (int j=i+1;j<len;j++){
                if(j-i+1>maxLen&&validPalindromic(charArray,i,j)){
                    maxLen=j-i+1;
                    begin=i;
                }
            }
        }
        return s.substring(begin,begin+maxLen);
    }
    /**
     * 验证子串s[left,right]是否为回文串
     */
    private boolean validPalindromic(char[] charArray,int left,int right){
        while (left<right){
            if(charArray[left]!=charArray[right]){
                return  false;
            }
            left++;
            right--;
        }
        return  true;
    }

    /**
     * 给你一个字符串 s 和一个字符规律 p，请你来实现一个支持 '.' 和 '*' 的正则表达式匹配。
     *
     * '.' 匹配任意单个字符
     * '*' 匹配零个或多个前面的那一个元素
     * 所谓匹配，是要涵盖 整个 字符串 s的，而不是部分字符串。
    * */

    public void reverseWords(char[] s) {
        // Step 1: 反转整个字符数组
        reverse(s, 0, s.length - 1);

        // Step 2: 对每个单词进行反转
        int start = 0;
        for (int end = 0; end < s.length; end++) {
            if (s[end] == ' ') {
                // 遇到空格，反转当前单词
                reverse(s, start, end - 1);
                // 更新下一个单词的起始位置
                start = end + 1;
            }
        }

        // 反转最后一个单词
        reverse(s, start, s.length - 1);
    }

    private void reverse(char[] s, int start, int end) {
        while (start < end) {
            char temp = s[start];
            s[start] = s[end];
            s[end] = temp;
            start++;
            end--;
        }
    }
}
