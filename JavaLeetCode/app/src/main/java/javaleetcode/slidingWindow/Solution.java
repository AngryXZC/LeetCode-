package javaleetcode.slidingWindow;

import java.lang.reflect.Array;
import java.util.Arrays;

/**
 * @author xzc
 * @date 2024/3/14 15 19:30
 * @description
 */
public class Solution {
    //1151. 最少交换次数来组合所有的 1
    //提示
    //给出一个二进制数组 data，你需要通过交换位置，将数组中 任何位置 上的 1 组合到一起，并返回所有可能中所需 最少的交换次数。
    //滑动窗口
    public int minSwaps(int[] data) {
        int one_count=0;
        for (int temp:data)
        {
            if(temp==1)
                one_count++;
        }
        if(one_count<=1)
            return 0;
        int max_contain_one=0;
        for (int i = 0; i <data.length-one_count+1 ; i++) {
            int contain_one_count=0;
            for (int j = 0; j < one_count; j++) {
                if(data[i+j]==1)
                    contain_one_count++;
            }
            if(contain_one_count>max_contain_one)
                max_contain_one=contain_one_count;
        }
        return one_count-max_contain_one;
    }

    public int minSwapTimes(int[] data){
        //使用计算有多少个1
        int ones= Arrays.stream(data).sum();
        int cnt_ones=0,max_one=0;
        //滑动窗口的左边和右边
        int left=0,right=0;
        while (right<data.length){
            cnt_ones+=data[right++];
            if(right-left>ones)
                cnt_ones-=data[left++];
            max_one=Math.max(cnt_ones,max_one);
        }

        return ones-max_one;
    }
}
