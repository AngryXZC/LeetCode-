package javaleetcode.heap;

import java.util.*;

//Java中的堆可以用优先队列（PriorityQueue）来表示
public class HeapPractice {
    //创建一个空的最小堆
    PriorityQueue<Integer> minHeap = new PriorityQueue<>();
    //创建一个空的最大堆
    PriorityQueue<Integer> maxHeap = new PriorityQueue<>(((o1, o2) -> o2.compareTo(o1)));
    // 创建带初始值的「堆」， 或者称为「堆化」操作，此时的「堆」为「最小堆」
    PriorityQueue<Integer> heapWithValues = new PriorityQueue<>(Arrays.asList(3, 1, 2));

    private void showUsage() {
        /**
         * 「堆」的用法	时间复杂度	空间复杂度
         * 创建「堆」       O(N)         O(N)
         * 插入元素         O(logn)      O(1)
         * 获取堆顶元素      O(1)         O(1)
         * 删除堆顶元素      O(logn)      O(1)
         * 获取「堆」的长度   O(1)         O(1)
         */
        // 最小堆插入元素
        minHeap.add(1);
        // 最大堆插入元素
        maxHeap.add(1);
        // 最小堆获取堆顶元素，即最小值
        minHeap.peek();
        // 最大堆获取堆顶元素，即最大值
        maxHeap.peek();
        // 最小堆删除堆顶元素
        minHeap.poll();
        // 最大堆删除堆顶元素
        maxHeap.poll();

        //获取堆顶大小时间复杂度为O(1)
        // 最小堆的长度
        minHeap.size();

        // 最大堆的长度
        maxHeap.size();
        // 注意：Java中判断堆是否还有元素，除了检查堆的长度是否为0外，还可以使用isEmpty()方法。
        // 如果堆中没有元素，则isEmpty()方法返回true。
        // 如果堆中还有元素，则isEmpty()方法返回false。


    }

//    public static void main(String[] args) {
//        // 创建一个最小堆实例
//        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
//        // 分别往最小堆中添加3，1，2
//        minHeap.add(3);
//        minHeap.add(1);
//        minHeap.add(2);
//        // 查看最小堆的所有元素，结果为：[1, 3, 2]
//        System.out.println("minHeap: " + minHeap.toString());
//        // 获取最小堆的堆顶元素
//        int peekNum = minHeap.peek();
//        // 结果为：1
//        System.out.println("peek number: " + peekNum);
//        // 删除最小堆的堆顶元素
//        int pollNum = minHeap.poll();
//        // 结果为：1
//        System.out.println("poll number: " + pollNum);
//        // 查看删除1后最小堆的堆顶元素，结果为：2
//        System.out.println("peek number: " + minHeap.peek());
//        // 查看新的最小堆的所有元素，结果为：[2,3]
//        System.out.println("minHeap: " + minHeap.toString());
//        // 查看最小堆的元素个数，也是最小堆的长度
//        int heapSize = minHeap.size();
//        // 结果为：2
//        System.out.println("minHeap size: " + heapSize);
//        // 判断最小堆是否还有元素
//        boolean isEmpty = minHeap.isEmpty();
//        // 结果为： false
//        System.out.println("isEmpty: " + isEmpty);
//    }
    //堆排序
    /**
     * 理论：堆排序指的是利用堆的数据结构对一组无序元素进行排序。
     *
     * 最小堆 排序算法步骤如下：
     *
     * 将所有元素堆化成一个 最小堆 ；
     * 取出并删除堆顶元素，并将该堆顶元素放置在存储有序元素的数据集 T 中；
     * 此时，堆 会调整成新的 最小堆；
     * 重复 3 和 4 步骤，直到 堆 中没有元素；
     * 此时得到一个新的数据集 T，其中的元素按照 从小到大 的顺序排列。
     * 最大堆排序算法步骤如下：
     *
     * 将所有元素堆化成一个 最大堆；
     * 取出并删除堆顶元素，并将该堆顶元素放置在存储有序元素的数据集 T 中；
     * 此时，堆 会调整成新的 最大堆；
     * 重复 3 和 4 步骤，直到 堆 中没有元素；
     * 此时得到一个新的数据集 T，其中的元素按照从大到小的顺序排列。
     *时间复杂度：O(NlogN) N是堆中的元素个数
     *空间复杂度：O(N) N是堆中的元素个数
     * */
    //TOP K问题-解法1
    /**
     *理论：利用「堆」的数据结构获取 Top K 大的元素或者 Top K 小的元素。
     *
     * Top K 大元素：最大的 K 个元素；
     *
     * Top K 小元素：最小的 K 个元素。
     *
     * 「Top K 大元素」解法步骤：
     *
     * 创建一个「最大堆」；
     * 将所有元素都加到「最大堆」中；
     * 通过 「边删除边遍历」（大部分语言中为pop()或者poll()） 方法，将堆顶元素删除，并将它保存到结果集 T 中；
     * 重复 3 步骤 K 次，直到取出前 K 个最大的元素；
     * 「Top K 小元素」解法步骤：
     *
     * 创建一个「最小堆」；
     * 将所有元素都加到「最小堆」中；
     * 通过 「边删除边遍历」（大部分语言中为 pop() 或者 poll()） 方法，将堆顶元素删除，并将它保存到结果集 T 中；
     * 重复 3 步骤 K 次，直到取出前 K 个最小的元素；
     *
     *
     * 时间复杂度:O(KlogN)
     * 空间复杂度：O(N)
     * */
    //TOP K问题-解法2
    /**
     * 理论：利用「堆」的数据结构获取 Top K 大的元素或者 Top K 小的元素。
     *
     * Top K 大元素：最大的 K 个元素；
     *
     * Top K 小元素：最小的 K 个元素。
     *
     * 「Top K 大元素」解法步骤：
     *
     * 创建一个大小为 K 的「最小堆」；
     *
     * 依次将元素添加到「最小堆」中；
     *
     * 当「最小堆」的元素个数达到 K 时，将当前元素与堆顶元素进行对比：
     *
     * 如果当前元素小于堆顶元素，则放弃当前元素，继续进行下一个元素；
     *
     * 如果当前元素大于堆顶元素，则删除堆顶元素，将当前元素加入到「最小堆」中。
     *
     * 重复步骤 2 和步骤 3，直到所有元素遍历完毕。
     *
     * 此时「最小堆」中的 K 个元素就是前 K 个最大的元素。
     *
     * 「Top K 小元素」解法步骤：
     *
     * 创建一个大小为 K 的「最大堆」；
     *
     * 依次将元素添加到「最大堆」中；
     *
     * 当「最大堆」的元素个数达到 K 时，将当前元素与堆顶元素进行对比：
     *
     * 如果当前元素大堆顶元素，则放弃当前元素，继续进行下一个元素；
     *
     * 如果当前元素小于堆顶元素，则删除堆顶元素，将当前元素加入到「最小堆」中。
     *
     * 重复步骤 2 和步骤 3，直到所有元素遍历完毕。
     *
     * 此时「最大堆」中的 K 个元素就是前 K 个最小的元素。
     *
     * 时间复杂度：O(NlogK)
     * 空间复杂度：O(K)
     * */
    //The Kth 问题 - 解法 1
    /**
     * 理论：利用「堆」的数据结构获取 The Kth 大元素或者 The Kth 小元素。
     *
     * The Kth 大元素：第 K 个大的元素；
     *
     * The Kth 小元素：第 K 个小的元素。
     *
     * 「The Kth 大元素」解法步骤：
     *
     * 创建一个「最大堆」；
     * 将所有元素都加到「最大堆」中；
     * 通过 「边删除边遍历」（大部分语言中为 pop() 或者 poll()） 方法，将堆顶元素删除；
     * 重复 3 步骤 K 次，直到获取到第 K 个最大的元素；
     * 「The Kth 小元素」解法步骤：
     *
     * 创建一个「最小堆」；
     * 将所有元素都加到「最小堆」中；
     * 通过 「边删除边遍历」（大部分语言中为 pop() 或者 poll()） 方法，将堆顶元素删除；
     * 重复 3 步骤 K 次，直到获取到第 K 个最小的元素；
     *
     * 时间复杂度：O(KlogN)
     * 空间复杂度：O(N)
     * */

    /**
     * The Kth 问题 - 解法 2
     * 理论： 利用「堆」的数据结构获取 The Kth 大元素或者 The Kth 小元素。
     *
     * The Kth 大元素：第 K 个大的元素；
     *
     * The Kth 小元素：第 K 个小的元素。
     *
     * 「The Kth 大元素」解法步骤：
     *
     * 创建一个大小为 K 的「最小堆」；
     *
     * 依次将元素添加到「最小堆」中；
     *
     * 当「最小堆」的元素个数达到 K 时，将当前元素与堆顶元素进行对比：
     *
     * 如果当前元素小于堆顶元素，则放弃当前元素，继续进行下一个元素；
     *
     * 如果当前元素大于堆顶元素，则删除堆顶元素，将当前元素加入到「最小堆」中。
     *
     * 重复步骤 2 和步骤 3，直到所有元素遍历完毕。
     *
     * 此时「最小堆」中的堆顶元素就是第 K 个最大的元素。
     *
     * 「The Kth 小元素」解法步骤：
     *
     * 创建一个大小为 K 的「最大堆」；
     *
     * 依次将元素添加到「最大堆」中；
     *
     * 当「最大堆」的元素个数达到 K 时，将当前元素与堆顶元素进行对比：
     *
     * 如果当前元素大于堆顶元素，则放弃当前元素，继续进行下一个元素；
     *
     * 如果当前元素小于堆顶元素，则删除堆顶元素，将当前元素加入到「最小堆」中。
     *
     * 重复步骤 2 和步骤 3，直到所有元素遍历完毕。
     *
     * 此时「最小堆」中的堆顶元素就是第 K 个最小的元素。
     *
     *
     * 时间复杂度：O(NlogK)
     * 空间复杂度：O(K)
     * */


    /**
     *  数组中的第 K 个最大元素
     * */
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> minHeap=new PriorityQueue<>();
        for (int item: nums) {
           if(minHeap.size()<k)
               minHeap.add(item);
           else {
               if(item>minHeap.peek()){
                   minHeap.poll();
                   minHeap.add(item);
               }
           }
        }
        return minHeap.peek();
    }

    /**
     * 数据流中的第 K 大元素
     * */

    static class KthLargest {

        PriorityQueue<Integer> minHeap;
        int k;

        public KthLargest(int k, int[] nums) {
            minHeap=new PriorityQueue<>();
            this.k=k;
            for (int item:nums) {
                if(minHeap.size()<k)
                    minHeap.add(item);
                else {
                    if(item>minHeap.peek()){
                        minHeap.poll();
                        minHeap.add(item);
                    }
                }
            }
        }

        public int add(int val) {
            if(minHeap.size()<k)
                minHeap.add(val);
            else {
                if(val>minHeap.peek()){
                    minHeap.poll();
                    minHeap.add(val);
                }
            }
            return minHeap.peek();
        }
    }

    /**
     * 前 K 个高频元素
     * */
    public int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer,Integer> hashMap=new HashMap<>();
        int[] res=new int[k];
        //把频度存在HashMap里
        for (int item: nums) {
            if(hashMap.containsKey(item)){
                int t=hashMap.get(item);
                t++;
                hashMap.put(item,t);
            }
            else {
                hashMap.put(item,1);
            }

        }
        //value-sort
        List<Map.Entry<Integer, Integer>> list = new ArrayList<Map.Entry<Integer, Integer>>(hashMap.entrySet());
        //list.sort()
        list.sort(new Comparator<Map.Entry<Integer, Integer>>() {
            @Override
            public int compare(Map.Entry<Integer, Integer> o1, Map.Entry<Integer, Integer> o2) {
                return o2.getValue().compareTo(o1.getValue());
            }
        });
        int count=0;
        //for-each
        for (Map.Entry<Integer, Integer> mapping : list) {
            res[count++]=mapping.getKey();
            if(count==k) break;;
        }
        return res;
    }

    public static void main(String[] args){
        new HeapPractice().topKFrequent(new int[]{1,1,1,2,2,3},2);
    }
}