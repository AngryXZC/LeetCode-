/*
 * This Java source file was generated by the Gradle 'init' task.
 */
package javaleetcode;

import java.util.Arrays;

public class Main {
    public int[] singleNumber(int[] nums) {
        int xor = 0;
        for (int num : nums) {
            xor ^= num;
        }

        int mask = 1;
        while ((xor & mask) == 0) {
            mask <<= 1;
        }

        int a = 0, b = 0;
        for (int num : nums) {
            if ((num & mask) != 0) {
                a ^= num;
            } else {
                b ^= num;
            }
        }

        return new int[] {a, b};
    }

    public static void main(String[] args) {
        int[] nums={1,2,3,4,3,4,5};
        System.out.println(Arrays.toString(new Main().singleNumber(nums)));
    }
}
