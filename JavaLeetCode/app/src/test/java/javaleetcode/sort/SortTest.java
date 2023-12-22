package javaleetcode.sort;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

public class SortTest {
    /**
     * 复杂度为O(n)算法的测试方法
     * */
    @Test
    void testBubbleSort(){
        int[] a={7,8,4,5,2,3,88};
        System.out.println("排序前的数组："+Arrays.toString(a));
        On2.bubbleSortIII(a);
        System.out.println("排序后的数组："+Arrays.toString(a));
    }
    @Test
    void testSelectionSort(){
        int[] a={7,8,4,5,2,3,88};
        System.out.println("排序前的数组："+Arrays.toString(a));
        On2.selectionSortI(a);
        System.out.println("排序后的数组："+Arrays.toString(a));
    }
}
