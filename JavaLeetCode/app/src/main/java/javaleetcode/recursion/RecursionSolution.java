package javaleetcode.recursion;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class RecursionSolution {
//使用递归，尾递归，和循环

    /**
     * pow(x,n)
     * */
    public double myPow(double x, int n) {
      long N=n;
      return N>=0?powHelper(x,N):1.0/powHelper(x,-N);
    }
    public double powHelper(double x,long n){
        if(n==0) return 1;
        double y=powHelper(x,n/2);
        return n%2==0?y*y:y*y*x;
    }
    /**
     * 递归乘法
     * */
    public int multiply(int A, int B) {
        if(B==0) return 0;
        int sum=A+multiply(A,B-1);
        return sum;
    }


    /**
     * 待加深理解
     * TODO
     * 归并排序
     * */
    public int[] sortArray(int[] nums) {
        int len = nums.length;
        int[] temp = new int[len];
        mergeSort(nums, 0, len - 1, temp);
        return nums;
    }

    /**
     * 递归函数语义：对数组 nums 的子区间 [left.. right] 进行归并排序
     *
     * @param nums
     * @param left
     * @param right
     * @param temp  用于合并两个有序数组的辅助数组，全局使用一份，避免多次创建和销毁
     */
    private void mergeSort(int[] nums, int left, int right, int[] temp) {
        // 1. 递归终止条件
        if (left == right) {
            return;
        }

        // 2. 拆分，对应「分而治之」算法的「分」
        int mid = (left + right) / 2;

        mergeSort(nums, left, mid, temp);
        mergeSort(nums, mid + 1, right, temp);

        // 3. 在递归函数调用完成以后还可以做点事情

        // 合并两个有序数组，对应「分而治之」的「合」
        mergeOfTwoSortedArray(nums, left, mid, right, temp);
    }


    /**
     * 合并两个有序数组：先把值复制到临时数组，再合并回去
     *
     * @param nums
     * @param left
     * @param mid   mid 是第一个有序数组的最后一个元素的下标，即：[left..mid] 有序，[mid + 1..right] 有序
     * @param right
     * @param temp  全局使用的临时数组
     */
    private void mergeOfTwoSortedArray(int[] nums, int left, int mid, int right, int[] temp) {
        for (int i = left; i <= right; i++) {
            temp[i] = nums[i];
        }

        int i = left;
        int j = mid + 1;

        int k = left;
        while (i <= mid && j <= right) {
            if (temp[i] <= temp[j]) {
                // 注意写成 < 就丢失了稳定性（相同元素原来靠前的排序以后依然靠前）
                nums[k] = temp[i];
                k++;
                i++;
            } else {
                nums[k] = temp[j];
                k++;
                j++;
            }
        }

        while (i <= mid) {
            nums[k] = temp[i];
            k++;
            i++;
        }
        while (j <= right) {
            nums[k] = temp[j];
            k++;
            j++;
        }
    }

    /**
     * 快排
     * */
    /**
     * 随机化是为了防止递归树偏斜的操作，此处不展开叙述
     */
    private static final Random RANDOM = new Random();

    public int[] sortArrayI(int[] nums) {
        int len = nums.length;
        quickSort(nums, 0, len - 1);
        return nums;
    }

    /**
     * 对数组的子区间 nums[left..right] 排序
     *
     * @param nums
     * @param left
     * @param right
     */
    private void quickSort(int[] nums, int left, int right) {
        // 1. 递归终止条件
        if (left >= right) {
            return;
        }

        int pIndex = partition(nums, left, right);

        // 2. 拆分，对应「分而治之」算法的「分」
        quickSort(nums, left, pIndex - 1);
        quickSort(nums, pIndex + 1, right);

        // 3. 递归完成以后没有「合」的操作，这是由「快速排序」partition 的逻辑决定的
    }


    /**
     * 将数组 nums[left..right] 分区，返回下标 pivot，
     * 且满足 [left + 1..lt) <= pivot，(gt, right] >= pivot
     *
     * @param nums
     * @param left
     * @param right
     * @return
     */
    private int partition(int[] nums, int left, int right) {
        int randomIndex = left + RANDOM.nextInt(right - left + 1);
        swap(nums, randomIndex, left);

        int pivot = nums[left];
        int lt = left + 1;
        int gt = right;

        while (true) {
            while (lt <= right && nums[lt] < pivot) {
                lt++;
            }

            while (gt > left && nums[gt] > pivot) {
                gt--;
            }

            if (lt >= gt) {
                break;
            }

            // 细节：相等的元素通过交换，等概率分到数组的两边
            swap(nums, lt, gt);
            lt++;
            gt--;
        }
        swap(nums, left, gt);
        return gt;
    }

    private void swap(int[] nums, int index1, int index2) {
        int temp = nums[index1];
        nums[index1] = nums[index2];
        nums[index2] = temp;
    }


    public static void main(String[] args){
        int[] a= new int[]{8, 6, 7, 2, 3, 5, 4, 1};
        RecursionSolution recursionSolution=new RecursionSolution();
        a=recursionSolution.sortArray(a);
        System.out.println(Arrays.toString(a));
        return;

    }
}
