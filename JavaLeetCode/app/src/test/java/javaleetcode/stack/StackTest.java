package javaleetcode.stack;

import org.junit.jupiter.api.Test;

/**
 * @author xzc
 * @date 2024/5/15 16 56:14
 * @description
 */
public class StackTest {
    @Test void simulateQueueWithStack(){
        MyQueue myQueue=new MyQueue();
        myQueue.push(1);
        myQueue.push(2);
        myQueue.push(3);
        myQueue.push(4);
        myQueue.pop();
        myQueue.push(5);
        myQueue.pop();
        myQueue.pop();
        myQueue.pop();
        myQueue.pop();
    }
}
