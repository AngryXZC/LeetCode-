package javaleetcode.sildingWindows;

import javaleetcode.slidingWindow.Solution;
import org.junit.jupiter.api.Test;

/**
 * @author xzc
 * @date 2024/3/14 15 38:21
 * @description
 */
public class SlidingTest {
    @Test
    void testMinSwapTimes(){
        Solution solution=new Solution();
        int[] data ={1,0,0,1,1,1};
        System.out.println(solution.minSwaps(data));
    }
}
