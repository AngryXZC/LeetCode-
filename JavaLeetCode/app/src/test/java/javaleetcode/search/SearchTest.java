package javaleetcode.search;

import javaleetcode.dataStructureAndAlgorithm.SearchSolution;
import org.junit.jupiter.api.Test;

/**
 * @author xzc
 * @date 2024/3/25 16 57:37
 * @description
 */
public class SearchTest {
    @Test
   public void testDismantlingAction(){
        SearchSolution solution=new SearchSolution();
        System.out.println(solution.countTarget(new int[] {2,2,2,3,3,3,4,4,4,5,5,5,6,6,6},3));
    }
    @Test
    public void testSearch(){
        javaleetcode.search.SearchSolution searchSolution=new javaleetcode.search.SearchSolution();
        System.out.println(searchSolution.searchRange(new int[]{5,7,7,8,8,10},8) );
    }
}
