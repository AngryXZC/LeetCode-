package algorithm;


import algs4.StdIn;
import algs4.StdOut;

public class Search {
    //二分查找
    public static int rank(int key, int[] a)
    {  return rank(key, a, 0, a.length - 1);  }

    public static int rank(int key, int[] a, int lo, int hi)
    {  //如果key存在于a[]中，它的索引不会小于lo且不会大于hi

        if (lo > hi) return -1;
        int mid = lo + (hi - lo) / 2;
        if      (key < a[mid]) return rank(key, a, lo, mid - 1);
        else if (key > a[mid]) return rank(key, a, mid + 1, hi);
        else                   return mid;
    }

    public static void main(String[] args)
    {  // 取StdIn中所有数的平均值
        double sum = 0.0;
        int cnt = 0;
        while (!StdIn.isEnd())
        {  // 读取一个数并计算累计之和
            sum += StdIn.readDouble();
            cnt++;
        }
        double avg = sum / cnt;
        StdOut.printf("Average is %.5f\n", avg);
    }
}
