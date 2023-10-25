package javaleetcode;

import javaleetcode.huawei.HUAWEISolution;
import org.junit.jupiter.api.Test;

public class HUAWEITest {
    @Test void noRepeatMostLongSubstring(){
        String s="aab";
        HUAWEISolution solution=new HUAWEISolution();
        System.out.println(solution.lengthOfLongestSubstring(s));
    }
}
