package javaleetcode.search;

/**
 * @author xzc
 * @date 2024/3/25 17 02:03
 * @description
 */
public class SearchSolution {
    /**
     * 34. 在排序数组中查找元素的第一个和最后一个位置
     * 给你一个按照非递减顺序排列的整数数组 nums，和一个目标值 target。请你找出给定目标值在数组中的开始位置和结束位置。
     *
     * 如果数组中不存在目标值 target，返回 [-1, -1]。
     *
     * 你必须设计并实现时间复杂度为 O(log n) 的算法解决此问题。
     * TODO
     * */
    public int[] searchRange(int[] nums, int target) {
        if(nums.length==0){
            return new int[]{-1,-1};
        }
        //二分查找逻辑
        int left = 0, right = nums.length - 1;
        int[] res = new int[]{-1, -1};
        while(left<right){
            int mid=left+(right-left)/2;
            if(nums[mid]<target){
                left=mid+1;
            }
            else{
                right=mid;
            }
        }
        //判断是否存在target
        if(nums[left]!=target){
            return res;
        }
        //找到左边界
        res[0]=left;
        //找到右边界
        right=nums.length-1;
        //二分查找逻辑
        while(left<right){
            int mid=left+(right-left)/2+1;
            if(nums[mid]>target){
                right=mid-1;
            }
            else{
                left=mid;
            }
        }
        res[1]=right;
        return res;
    }

    public int binarySearch(int[] nums, int target,boolean lower){
        int left=0,right=target-1,ans=-1;
        while (left<right){
            int mid=(left+right)/2;
            if(nums[mid]>target){
                right=mid-1;
            }
            else if (nums[mid]<target){
                left=mid+1;
            }
            else{
                ans=mid;
            }
        }
        return ans;
    }
}
