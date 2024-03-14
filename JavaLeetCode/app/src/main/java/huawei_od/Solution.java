package huawei_od;

import java.util.Scanner;

/**
 * @author xzc
 * @date 2024/3/14 10 15:02
 * @description 太吃力了立即推->放弃
 * 华为内部机试题
 */
public class Solution {
    //最少交换次数
    //给出的答案
    public void minSwapTime(){
        Scanner scanner=new Scanner(System.in);
        String[] str=scanner.nextLine().split(" ");
        int n=scanner.nextInt();

        int len=str.length;
        //数字数组
        int ints[]=new int[len];
        //满足条件的数字个数
        int cnt=0;
        for (int i = 0; i < len; i++) {
            ints[i]=Integer.valueOf(str[i]);
            if(ints[i]<n)
                cnt++;
        }
        int res=Integer.MAX_VALUE;
        for (int i = 0; i <len-cnt+1 ; i++) {
            int count=0;
            for (int j=0;j<cnt;j++){
                if(i+j>=n)
                    count++;
            }
            res=Math.min(res,count);
        }
        System.out.println(res);
    }
    //我自己写的
    //滑动窗口
    //时间复杂度为O(n^2)
    public  void myMinSwap(){
        Scanner scanner=new Scanner(System.in);
        String[] strings=scanner.nextLine().split(" ");
        int k=scanner.nextInt();
        int len=strings.length;
        int satisfySum=0;
        Integer[] ints=new Integer[len];
        for (int i = 0; i < len; i++) {
            ints[i]=Integer.valueOf(strings[i]);
            if(ints[i]<k){
                satisfySum++;
            }
        }
        int maxSatisfy=0;
        for (int i = 0; i < len-satisfySum+1; i++) {
            int coutainSatisfy=0;
            for (int j = 0; j < satisfySum; j++) {
                if(ints[i+j]<k){
                    coutainSatisfy++;
                }
            }
            if(maxSatisfy<coutainSatisfy)
                maxSatisfy=coutainSatisfy;
        }
        System.out.println(satisfySum-maxSatisfy);
    }
    public static void  main (String[] args){
        new Solution().myMinSwap();
    }
}
