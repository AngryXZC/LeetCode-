package javaleetcode.sort;

/**
 * 时间复杂度为O(n^2)的排序算法
 * */
public class On2 {
    /**
     * 冒泡排序
     * */
    //第一种写法
    public static void bubbleSortI(int[] arr){
        for (int i = 0; i < arr.length-1 ; i++) {
            for (int j = 0; j < arr.length-1-i ; j++) {
                if(arr[j]>arr[j+1])
                    swap(arr,j,j+1);
            }
        }
    }
    //第二种写法
    //优化后的冒泡排序
    //增加了一个标志位，如果一趟排序中没有发生交换，说明已经有序，直接退出循环
    public static void bubbleSortII(int[] arr){
        boolean isSwapped=false;
        for (int i = 0; i < arr.length-1 ; i++) {
            isSwapped=false;
            for (int j = 0; j < arr.length-1-i ; j++) {
                if(arr[j]>arr[j+1]){
                    swap(arr,j,j+1);
                    isSwapped=true;
                }
            }
            //如果一趟排序中没有发生交换，说明已经有序，直接退出循环
            if(!isSwapped)
                break;
        }
    }
    //第三种写法
    //优化后的冒泡排序
    //增加了一个标志位，如果一趟排序中没有发生交换，说明已经有序，直接退出循环
    //同时记录最后一次交换的位置，下一趟排序只需要扫描到这里即可
    public static void bubbleSortIII(int[] arr){
        boolean isSwapped=true; // 记录每轮冒泡是否发生了交换
        int lastSwappedIndex=arr.length-1;//最后一次交换的位置
        int swappedIndex=-1;//本轮冒泡中发生交换的位置
        while (isSwapped){
            isSwapped=false;
            for (int i = 0; i < lastSwappedIndex ; i++) {
                if(arr[i]>arr[i+1]){
                    //交换元素
                    swap(arr,i,i+1);
                    //表示发生了交换
                    isSwapped=true;
                    //记录交换的位置
                    swappedIndex=i;
                }
            }
            //最后一次交换的位置
            lastSwappedIndex=swappedIndex;
        }
    }

    //交换元素
    private static void swap(int[] arr,int i,int j){
        //这种方法自己和自己交换会出问题
        if(i==j)
            return;
        arr[i]=arr[i]+arr[j];
        arr[j]=arr[i]-arr[j];
        arr[i]=arr[i]-arr[j];
    }

    /***
     * 选择排序
     */
    public static void selectionSortI(int[] arr){
        int minIndex=0;
        for (int i = 0; i < arr.length; i++) {
            minIndex=i;
            for (int j = i+1; j < arr.length ; j++) {
                if(arr[j]<arr[minIndex])
                    minIndex=j;
            }
            //将最小元素交换到首位
            swap(arr,minIndex,i);
        }
    }
    /**
     * 二元选择排序
     * */
    public static void selectionSort2(int[] arr) {
        int minIndex, maxIndex;
        // i 只需要遍历一半
        for (int i = 0; i < arr.length / 2; i++) {
            minIndex = i;
            maxIndex = i;
            for (int j = i + 1; j < arr.length - i; j++) {
                if (arr[minIndex] > arr[j]) {
                    // 记录最小值的下标
                    minIndex = j;
                }
                if (arr[maxIndex] < arr[j]) {
                    // 记录最大值的下标
                    maxIndex = j;
                }
            }
            // 如果 minIndex 和 maxIndex 都相等，那么他们必定都等于 i，且后面的所有数字都与 arr[i] 相等，此时已经排序完成
            if (minIndex == maxIndex) break;
            // 将最小元素交换至首位
            int temp = arr[i];
            arr[i] = arr[minIndex];
            arr[minIndex] = temp;
            // 如果最大值的下标刚好是 i，由于 arr[i] 和 arr[minIndex] 已经交换了，所以这里要更新 maxIndex 的值。
            if (maxIndex == i) maxIndex = minIndex;
            // 将最大元素交换至末尾
            int lastIndex = arr.length - 1 - i;
            temp = arr[lastIndex];
            arr[lastIndex] = arr[maxIndex];
            arr[maxIndex] = temp;
        }
    }

    /**
     * 插入排序
     * */

    //交换法插入排序
    public static void insertSort(int[] arr){
        //从第二个元素开始，将其插入到前面已经排好序的序列中
        for (int i = 1; i <arr.length ; i++) {
            //记录当前数字下标
            int j=i;
            //如果当前数字比前一个数字小，就交换
            while(j>=1&&arr[j]<arr[j-1]){
                swap(arr,j,j-1);
                j--; //这边这个j--很重要，不然会死循环
            }
        }
    }
    //移动法插入排序
    public static void insertSort2(int[] arr){
        //从第二个元素开始，将其插入到前面已经排好序的序列中
        for (int i = 1;i < arr.length ; i++) {
            int currentNum=arr[i];
            int j=i-1;
            //寻找插入位置的过程中，不断的将比currentNum大的元素向后移动
            while(j>=0&&arr[j]>currentNum){
                arr[j+1]=arr[j];
                j--;
            }
            //两种情况会跳出循环，一是找到了插入位置，二是j=-1
            arr[j+1]=currentNum;
        }
    }
}
