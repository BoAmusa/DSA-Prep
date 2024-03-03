package Queues;

public class QueueArray {
    int[] arr;
    int backOfQueue;
    int beginningOfQueue;

    public QueueArray(int size) {
        this.arr = new int[size];
        this.backOfQueue = -1;
        this.beginningOfQueue = -1;
        System.out.println("Successfully created Queue");
    }

    public boolean isFull() {
        return backOfQueue == arr.length - 1;
    }

    public boolean isEmpty() {
        return beginningOfQueue == -1 || beginningOfQueue == arr.length;
    }


    public void enQueue(int value) {
        if (isFull()) {
            System.out.println("Queue is full");
        } else if (isEmpty()) {
            beginningOfQueue = 0;
            backOfQueue++;
            arr[backOfQueue] = value;
            System.out.println("Successfully inserted " + value + " in the Queue");
        } else {
            backOfQueue++;
            arr[backOfQueue] = value;
            System.out.println("Successfully inserted " + value + " in the Queue");
        }
    }

    public int deQueue() {
        if (isEmpty()) {
            System.out.println("Queue is Empty");
            return -1;
        } else {
            int firstElement = arr[beginningOfQueue];
            beginningOfQueue++;
            if (beginningOfQueue > backOfQueue) {
                beginningOfQueue = -1;
                backOfQueue = -1;
            }

            return firstElement;
        }
    }

    public int peek() {
        if (isEmpty()) {
            System.out.println("Queue is Empty");
            return -1;
        } else {
            return arr[beginningOfQueue];
        }
    }

    public void deleteQueue() {
        this.arr = null;
        this.backOfQueue = -1;
        this.beginningOfQueue = -1;
        System.out.println("Queue is deleted!");
    }
}
