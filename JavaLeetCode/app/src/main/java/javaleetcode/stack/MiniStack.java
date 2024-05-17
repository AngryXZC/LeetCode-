package javaleetcode.stack;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @author xzc
 * @date 2024/5/15 17 12:10
 * @description
 * 设计一个支持 push ，pop ，top 操作，并能在常数时间内检索到最小元素的栈。
 *
 * 实现 MinStack 类:
 *
 * MinStack() 初始化堆栈对象。
 * void push(int val) 将元素val推入堆栈。
 * void pop() 删除堆栈顶部的元素。
 * int top() 获取堆栈顶部的元素。
 * int getMin() 获取堆栈中的最小元素。
 */
class MinStack {

    /**
     * 辅助栈存最当前栈里最小元素
     * 辅助栈用来记录当前元素入栈后栈内的最小元素
     * */

    Deque<Integer> stack,minStack;
    public MinStack() {
        stack=new ArrayDeque<>();
        minStack=new ArrayDeque<>();
    }

    public void push(int val) {
        //一次压栈
        //真正的栈和辅助栈都需要添加对应的元素
        stack.push(val);
        if(minStack.isEmpty())
            minStack.push(val);
        else {
            if(val>minStack.peek()){
                minStack.push(minStack.peek());
            }
            else {
                minStack.push(val);
            }
        }
    }

    public void pop() {
        minStack.pop();
        stack.pop();
    }

    public int top() {
        return stack.peek();
    }

    public int getMin() {
        return  minStack.peek();
    }
}


