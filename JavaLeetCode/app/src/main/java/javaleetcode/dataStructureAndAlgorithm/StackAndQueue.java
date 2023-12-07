package javaleetcode.dataStructureAndAlgorithm;

import java.util.*;

public class StackAndQueue {
    /**
     * 图书整理 II
     * */
    //双栈模拟的队列
    class CQueue {
       LinkedList<Integer> A,B;
       public CQueue(){
           A=new LinkedList<>();
           B=new LinkedList<>();
       }
       public void  appendTail(int value){
           A.addLast(value);
       }
       public int deleteHead(){
           if(!B.isEmpty()) return B.removeLast();
           if(A.isEmpty()&&B.isEmpty()) return -1;
           while (!A.isEmpty())
               B.addLast(A.removeLast());
           return B.removeLast();
       }
    }
    //队列
class myQueue {
        LinkedList<Integer> A;
       public myQueue (){
           A= new LinkedList<>();
       }
    public void  appendTail(int value){
        A.addLast(value);
    }
    public int deleteHead(){
        if(A.isEmpty()) return -1;
        return A.removeFirst();
    }
}
/**
 * 最小栈
 * */
class MinStack {
    Stack<Integer> A,B;
    /** initialize your data structure here. */
    public MinStack() {
        A =new Stack<>();
        B=new Stack<>();
    }

    public void push(int x) {
      A.push(x);
      if(B.isEmpty()){
          B.push(x);
      }
      else {
          if(x<=B.peek()){
              B.push(x);
          }
      }
    }

    public void pop() {
        if(A.peek().equals(B.peek())){
            B.pop();
        }
        if(!A.isEmpty()){
            A.pop();
        }

    }

    public int top() {
        return A.peek();
    }

    public int getMin() {
        return B.peek();
    }
  }
  /**
   * 验证图书取出顺序
   * */
  public boolean validateBookSequences(int[] putIn, int[] takeOut) {
      if(putIn.length==0||takeOut.length==0) return true;
      Stack<Integer> stack=new Stack<>();
      int i=0;
      for (int num:putIn) {
          stack.push(num);
          while (!stack.isEmpty()&&stack.peek()==takeOut[i]){
              stack.pop();
              i++;
          }
      }
      return stack.isEmpty();
  }
  /**
   * 望远镜中最高的海拔
   * */
  //暴力解法
  public int[] maxAltitude(int[] heights, int limit) {
      if(heights.length==0&&limit==0)
          return new int[0];
      int[] res=new int[heights.length-limit+1];
      for (int i = 0; i <heights.length-limit+1 ; i++) {
          int[] temp=Arrays.copyOfRange(heights,i,i+limit);
          Arrays.sort(temp) ;
          res[i]=temp[limit-1];
      }
     return res;
  }

  //递减的双端队列
    public int[] maxAltitude2(int[] heights, int limit) {
        if(heights.length == 0 || limit == 0) return new int[0];
        Deque<Integer> deque = new LinkedList<>();
        int[] res = new int[heights.length - limit + 1];
        for(int j = 0, i = 1 - limit; j < heights.length; i++, j++) {
            // 删除 deque 中对应的 heights[i-1]
            if(i > 0 && deque.peekFirst() == heights[i - 1])
                deque.removeFirst();
            // 保持 deque 递减
            while(!deque.isEmpty() && deque.peekLast() < heights[j])
                deque.removeLast();
            deque.addLast(heights[j]);
            // 记录窗口最大值
            if(i >= 0)
                res[i] = deque.peekFirst();
        }
        return res;
    }

    /**
     *设计自助结算系统
     *
     * ——————————————————————————
     * 	第一个元素 (头部)	最后一个元素 (尾部)
     * 抛出异常	特殊值	抛出异常	特殊值
     * 插入	addFirst(e)	offerFirst(e)	addLast(e)	offerLast(e)
     * 删除	removeFirst()	pollFirst()	removeLast()	pollLast()
     * 检查	getFirst()	peekFirst()	getLast()	peekLast()
     * ——————————————————————————————
     *
     * */
    class Checkout {
        Queue<Integer> queue;
        Deque<Integer> maxQueue;
        public Checkout() {
            queue=new LinkedList<>();
            maxQueue=new LinkedList<>();
        }

        public int get_max() {
            if (maxQueue.isEmpty())
                return -1;
            else
                return  maxQueue.peekFirst();
        }

        public void add(int value) {
            queue.offer(value);
             while (!maxQueue.isEmpty()&&maxQueue.peekLast()<value){
                 maxQueue.pollLast();
             }
                maxQueue.offerLast(value);

        }

        public int remove() {
            if(queue.isEmpty()) return -1;
            if(queue.peek().equals(maxQueue.peekFirst()))
                maxQueue.pollFirst();

            return queue.poll();
        }
    }

  public static void main(String[] args){
      int[] putIn={14,2,27,-5,28,13,39};

      new StackAndQueue().maxAltitude(putIn,3);
  }
}
