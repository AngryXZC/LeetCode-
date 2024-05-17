package javaleetcode.stack;

/**
 * @author xzc
 * @date 2024/5/15 17 29:54
 * @description
 */
class CustomStack {
    /**
     * 朴素的想法
     * */
    int currentLength=0;
    int maxCapacity=0;

    Integer[] stackArray;
    public CustomStack(int maxSize) {
        stackArray=new Integer[maxSize];
        maxCapacity=maxSize;
    }

    public void push(int x) {
        if(currentLength<maxCapacity)
            stackArray[currentLength++]=x;
    }

    public int pop() {
        if(currentLength!=0)
           return stackArray[--currentLength];
        else
            return -1;
    }

    public void increment(int k, int val) {
        if(currentLength<k)
            k=currentLength;
        for (int i=0;i<k;i++) {
                stackArray[k-1-i]+=val;
        }
    }
}
