package javaleetcode.sort;

/**
 * @authorAdministrator
 * @date2024/1/8 0008 10:51
 * @description
 */
/**
 * 时间复杂度为O(n^2)的排序算法
 * TODO
 * */
public class Onlogn {
    public static void shellSort(int[] arr) {
        // 间隔序列，在希尔排序中我们称之为增量序列
        for (int gap = arr.length / 2; gap > 0; gap /= 2) {
            // 分组
            for (int groupStartIndex = 0; groupStartIndex < gap; groupStartIndex++) {
                // 插入排序
                for (int currentIndex = groupStartIndex + gap; currentIndex < arr.length; currentIndex += gap) {
                    // currentNumber 站起来，开始找位置
                    int currentNumber = arr[currentIndex];
                    int preIndex = currentIndex - gap;
                    while (preIndex >= groupStartIndex && currentNumber < arr[preIndex]) {
                        // 向后挪位置
                        arr[preIndex + gap] = arr[preIndex];
                        preIndex -= gap;
                    }
                    // currentNumber 找到了自己的位置，坐下
                    arr[preIndex + gap] = currentNumber;
                }
            }
        }
    }


}
