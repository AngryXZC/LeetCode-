package javaleetcode.queue;

import java.util.ArrayDeque;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @author xzc
 * @date 2024/5/17 08 54:50
 * @description
 */
class MyCircularQueue {
    private int[] queue;
    int front=0,end=0,capacity=0;
    public MyCircularQueue(int k) {
        queue=new int[k+1];
    }

    public boolean enQueue(int value) {
        if(!isFull()){
            queue[end]=value;
            end=(end+1)%queue.length;
            capacity++;
            return true;
        }
        else {return false;}
    }

    public boolean deQueue() {
        if(!isEmpty()){
            front = (front + 1) % queue.length;
            capacity--;
            return true;
        }
        return false;
    }

    public int Front() {
        if(isEmpty())
            return -1;
           return queue[front];
    }

    public int Rear() {
        if(isEmpty())
            return -1;
        int te = (end - 1 + queue.length) % queue.length;
        return queue[te];
    }

    public boolean isEmpty() {
        return front==end;
    }

    public boolean isFull() {
        return ((end+1)%queue.length)==front;
    }
}

/**
 * Your MyCircularQueue object will be instantiated and called as such:
 * MyCircularQueue obj = new MyCircularQueue(k);
 * boolean param_1 = obj.enQueue(value);
 * boolean param_2 = obj.deQueue();
 * int param_3 = obj.Front();
 * int param_4 = obj.Rear();
 * boolean param_5 = obj.isEmpty();
 * boolean param_6 = obj.isFull();
 */
