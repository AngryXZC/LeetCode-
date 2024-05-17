package javaleetcode.stack;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @author xzc
 * @date 2024/5/15 16 23:27
 * @description 用栈实现队列
 */
class MyQueue {
    /**
     * 用栈实现队列
     * 1.保证栈顶元素是队列的队首
     * 2.入队时将元素放在中转栈中
     * 3.然后将另一个栈的元素全部依次出队到这个队列中
     * 4.互换引用，这样保证了始终一个空栈模拟入队，另一个是队列模拟了栈
     * 5.这样队列首就是栈顶元素
     * 这样做有问题的：
     * （1）栈2 每次从1中压入1中弹出的元素会破坏原有的顺序
     * */
    /**
     * 正解：
     * 将一个栈当作输入栈，用于压入 push\texttt{push}push 传入的数据；另一个栈当作输出栈，用于 pop\texttt{pop}pop 和 peek\texttt{peek}peek 操作。
     *
     * 每次 pop\texttt{pop}pop 或 peek\texttt{peek}peek 时，若输出栈为空则将输入栈的全部数据依次弹出并压入输出栈，这样输出栈从栈顶往栈底的顺序就是队列从队首往队尾的顺序。
     *
     * 作者：力扣官方题解
     * 链接：https://leetcode.cn/problems/implement-queue-using-stacks/solutions/632369/yong-zhan-shi-xian-dui-lie-by-leetcode-s-xnb6/
     * 来源：力扣（LeetCode）
     * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
     * */
    Deque<Integer> stack1;
    Deque<Integer> stack2;
    public MyQueue() {
        stack1=new ArrayDeque<>();
        stack2=new ArrayDeque<>();
    }

    public void push(int x) {
       stack1.push(x);
    }

    public int pop() {
       while (!stack1.isEmpty()){
           stack2.push(stack1.pop());
       }
       int res=stack2.pop();
       while (!stack2.isEmpty()){
           stack1.push(stack2.pop());
       }
       return res;
    }

    public int peek() {
        while (!stack1.isEmpty()){
            stack2.push(stack1.pop());
        }
        int res=stack2.peek();
        while (!stack2.isEmpty()){
            stack1.push(stack2.pop());
        }
        return res;
    }

    public boolean empty() {
        return stack1.isEmpty();
    }


}


