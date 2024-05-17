package javaleetcode.stack;

/**
 * @author xzc
 * @date 2024/5/15 17 59:17
 * @description
 * 在方法一中，只剩下 inc 操作的时间复杂度不为 O(1)O(1)O(1)，因此可以尝试对该操作进行优化。
 *
 * 我们用一个辅助数组 add 记录每次 inc 操作。具体地，如果 inc 操作是将栈底的 k 个元素（将 k 与栈中元素个数取较小值）增加 val，那么我们将 add[k - 1] 增加 val。这样做的目的在于，只有在 pop 操作时，我们才需要知道栈顶元素的具体值，在其余的情况下，我们只要存储每个元素的增量就行了。
 *
 * 因此在遇到 pop 操作时，我们返回栈顶元素的初始值加上增量 add[top]。在这之后，我们将增量向栈底进行传递，累加至 add[top - 1] 处，这样 inc 操作的时间复杂度也减少至 O(1)O(1)O(1) 了。
 *
 * 作者：力扣官方题解
 * 链接：https://leetcode.cn/problems/design-a-stack-with-increment-operation/solutions/241895/she-ji-yi-ge-zhi-chi-zeng-liang-cao-zuo-de-zhan-by/
 * 来源：力扣（LeetCode）
 * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
 */
public class CustomStackOptimize {
    int[] stack;
    int top;
    int [] add;

    public CustomStackOptimize(int maxSize) {
        stack = new int[maxSize];
        top = -1;
        add=new int[maxSize];
    }
    public void push(int x) {
        if(top!=stack.length-1)
            stack[++top]=x;

    }
    public int pop() {
        if(top==-1)
            return -1;
        int res=stack[top]+add[top];
        //传递
        if(top!=0)
            add[top-1]+=add[top];
        add[top]=0;
        --top;
        return  res;
    }
    public void increment(int k, int val) {
        int limit=Math.min(k-1,top);
        if(limit>=0)
            add[limit]+=val;
    }

}
