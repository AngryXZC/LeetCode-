package javaleetcode.stack;

import java.util.ArrayDeque;
import java.util.Queue;

/**
 * @author xzc
 * @date 2024/5/15 15 57:46
 * @description 225 用队列实现栈
 */
class MyStack {


    Queue<Integer> queue1;
    Queue<Integer> queue2;

    public MyStack() {
        queue1=new ArrayDeque<>();
        queue2=new ArrayDeque<>();
    }

    /**
     *1.保证一个队列的队首始终为栈顶
     *2.入栈时，将元素放在队列2中，
     *3.然后将队列1 中的元素依次出队放到队列2中，这样在队列2中就队首元素就是栈顶元素了
     *4. 最后交换队列1和2的指向
     * */
    public void push(int x) {
        queue2.offer(x);
        while (!queue1.isEmpty()){
            int head_element=queue1.poll();
            queue2.offer(head_element);
        }
        Object tem=queue1;
        queue1=queue2;
        queue2=(Queue<Integer>) tem;
    }

    public int pop() {
        return  queue1.poll();
    }

    public int top() {
        return queue1.peek();
    }

    public boolean empty() {
        return queue1.isEmpty();
    }
}

