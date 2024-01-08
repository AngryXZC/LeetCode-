package javaleetcode.sort;

import javaleetcode.dataStructureAndAlgorithm.ListSolution;
import javaleetcode.huawei.ListNode;

import java.util.Arrays;
import java.util.HashMap;

public class SortSolution {
    /**
     * 283. 移动零
     * 给定一个数组 nums，编写一个函数将所有 0 移动到数组的末尾，同时保持非零元素的相对顺序。
     */
    public void moveZeroes(int[] nums) {
        int zeroCount = 0;
        for (int i = 0; i < nums.length - zeroCount; i++) {
            for (int j = 0; j < nums.length - 1 - zeroCount; j++) {
                if (nums[j] == 0) {
                    //换值
                    nums[j] = nums[j] + nums[j + 1];
                    nums[j + 1] = nums[j] - nums[j + 1];
                    nums[j] = nums[j] - nums[j + 1];
                }
            }
            zeroCount++;
            // 下一轮遍历时 i 会增加 1，但此时 nums[i] 已经和 nums[i+1] 交换了，nums[i+1] 还没有判断是否为 0，所以这里先减 1，以使下一轮继续判断 i 位置。

        }
    }

    /**
     * 215. 数组中的第 K 个最大元素
     */
    public int findKthLargest(int[] nums, int k) {
        int maxIndex = 0;
        for (int i = 0; i < k; i++) {
            maxIndex = i;
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[j] > nums[maxIndex]) {
                    int temp = nums[j];
                    nums[j] = nums[maxIndex];
                    nums[maxIndex] = temp;
                }
            }

        }
        return nums[k - 1];
    }

    /**
     * 147. 对链表进行插入排序
     */
    public ListNode insertionSortList(ListNode head) {
        if (head == null) return null;
        // 创建哑结点，用于将在 head 前插入结点转换为在哑结点后插入，统一处理，更方便
        ListNode dummyHead = new ListNode(0);
        dummyHead.next = head;
        // 记录已排序完成的结点末尾
        ListNode lastSorted = head;
        // 当前需要新插入的结点
        ListNode current = head.next;
        while (current != null) {
            if (lastSorted.val <= current.val) {
                // 新插入的值正好是最大值，直接插入链表末尾
                lastSorted = lastSorted.next;
            } else {
                // 从头开始寻找插入位置
                ListNode previous = dummyHead;
                while (previous.next.val <= current.val) {
                    previous = previous.next;
                }
                // 将新结点插入链表
                lastSorted.next = current.next;
                current.next = previous.next;
                previous.next = current;
            }
            // 更新新结点
            current = lastSorted.next;
        }
        return dummyHead.next;

    }

    /**
     *506. 相对名次
     *  */
    public String[] findRelativeRanks(int[] nums) {
        int[] arr = nums.clone();
        shellSort(arr);
        // 建立每位运动员的成绩和名次的映射关系
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < arr.length; i++) {
            map.put(arr[i], i + 1);
        }
        String[] result = Arrays.stream(nums).mapToObj(String::valueOf).toArray(String[]::new);
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == arr[0]) result[i] = "Gold Medal";
            else if (nums[i] == arr[1]) result[i] = "Silver Medal";
            else if (nums[i] == arr[2]) result[i] = "Bronze Medal";
            else result[i] = String.valueOf(map.get(nums[i]));
        }
        return result;
    }

    public static void shellSort(int[] arr) {
        // 间隔序列，在希尔排序中我们称之为增量序列
        for (int gap = arr.length / 2; gap > 0; gap /= 2) {
            // 从 gap 开始，按照顺序将每个元素依次向前插入自己所在的组
            for (int i = gap; i < arr.length; i++) {
                // currentNumber 站起来，开始找位置
                int currentNumber = arr[i];
                // 该组前一个数字的索引
                int preIndex = i - gap;
                while (preIndex >= 0 && currentNumber > arr[preIndex]) {
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
