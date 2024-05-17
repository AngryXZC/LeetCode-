package javaleetcode.queue;

import org.junit.jupiter.api.Test;

/**
 * @author xzc
 * @date 2024/5/17 09 05:49
 * @description
 */
public class MyCircularQueueTest {
    @Test
    void testMyCircularQueue(){
        MyCircularQueue myCircularQueue=new MyCircularQueue(10);
        myCircularQueue.enQueue(3);
        myCircularQueue.enQueue(1);
        myCircularQueue.enQueue(2);
        myCircularQueue.enQueue(3);
        myCircularQueue.Rear();
        myCircularQueue.isFull();
        myCircularQueue.deQueue();
        myCircularQueue.enQueue(4);
        myCircularQueue.Rear();
    }

}
