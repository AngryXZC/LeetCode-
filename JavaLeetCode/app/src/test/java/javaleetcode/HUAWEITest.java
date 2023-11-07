package javaleetcode;

import javaleetcode.huawei.HUAWEISolution;
import org.junit.jupiter.api.Test;

public class HUAWEITest {
    @Test void twoOrderNumberArraysMedianNum(){
        int[] nums1={1,2},nums2={3,4};
        HUAWEISolution solution=new HUAWEISolution();
        System.out.println(solution.findMedianSortedArraysMethod1(nums1,nums2));
    }
    @Test void noRepeatMostLongSubstring(){
        String s="aab";
        HUAWEISolution solution=new HUAWEISolution();
        System.out.println(solution.lengthOfLongestSubstring(s));
    }
    @Test void longestPalindromeTest(){
        String s="gphyvqruxjmwhonjjrgumxjhfyupajxbjgthzdvrdqmdouuukeaxhjumkmmhdglqrrohydrmbvtuwstgkobyzjjtdtjroqpyusfsbjlusekghtfbdctvgmqzeybnwzlhdnhwzptgkzmujfldoiejmvxnorvbiubfflygrkedyirienybosqzrkbpcfidvkkafftgzwrcitqizelhfsruwmtrgaocjcyxdkovtdennrkmxwpdsxpxuarhgusizmwakrmhdwcgvfljhzcskclgrvvbrkesojyhofwqiwhiupujmkcvlywjtmbncurxxmpdskupyvvweuhbsnanzfioirecfxvmgcpwrpmbhmkdtckhvbxnsbcifhqwjjczfokovpqyjmbywtpaqcfjowxnmtirdsfeujyogbzjnjcmqyzciwjqxxgrxblvqbutqittroqadqlsdzihngpfpjovbkpeveidjpfjktavvwurqrgqdomiibfgqxwybcyovysydxyyymmiuwovnevzsjisdwgkcbsookbarezbhnwyqthcvzyodbcwjptvigcphawzxouixhbpezzirbhvomqhxkfdbokblqmrhhioyqubpyqhjrnwhjxsrodtblqxkhezubprqftrqcyrzwywqrgockioqdmzuqjkpmsyohtlcnesbgzqhkalwixfcgyeqdzhnnlzawrdgskurcxfbekbspupbduxqxjeczpmdvssikbivjhinaopbabrmvscthvoqqbkgekcgyrelxkwoawpbrcbszelnxlyikbulgmlwyffurimlfxurjsbzgddxbgqpcdsuutfiivjbyqzhprdqhahpgenjkbiukurvdwapuewrbehczrtswubthodv";
        HUAWEISolution solution=new HUAWEISolution();
        System.out.println(solution.longestPalindrome(s));

    }
}
