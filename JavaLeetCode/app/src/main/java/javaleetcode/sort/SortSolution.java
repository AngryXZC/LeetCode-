package javaleetcode.sort;

public class SortSolution {
    /**283. 移动零
     给定一个数组 nums，编写一个函数将所有 0 移动到数组的末尾，同时保持非零元素的相对顺序。
     */
    public void moveZeroes(int[] nums) {
        int zeroCount=0;
        for (int i = 0; i < nums.length-zeroCount ; i++) {
            for (int j = 0; j <nums.length-1-zeroCount ; j++) {
                if(nums[j]==0){
                    //换值
                    nums[j]=nums[j]+nums[j+1];
                    nums[j+1]=nums[j]-nums[j+1];
                    nums[j]=nums[j]-nums[j+1];
                }
            }
            zeroCount++;
            // 下一轮遍历时 i 会增加 1，但此时 nums[i] 已经和 nums[i+1] 交换了，nums[i+1] 还没有判断是否为 0，所以这里先减 1，以使下一轮继续判断 i 位置。

        }
    }

    /**
     *  215. 数组中的第 K 个最大元素
     * */
    public int findKthLargest(int[] nums, int k) {
        int maxIndex=0;
        for (int i = 0; i < k; i++) {
            maxIndex=i;
            for (int j = i+1; j < nums.length; j++) {
                if(nums[j]>nums[maxIndex]){
                    int temp=nums[j];
                    nums[j]=nums[maxIndex];
                    nums[maxIndex]=temp;
                }
            }

        }
        return nums[k-1];
    }
}
