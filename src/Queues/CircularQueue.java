package Queues;

public class CircularQueue {
    int[] arr;
    int backOfQueue;
    int beginningOfQueue;
    int size;

    public CircularQueue(int size) {
        this.arr = new int[size];
        this.size = size;
        this.backOfQueue = -1;
        this.beginningOfQueue = -1;
        System.out.println("Circular Queue created with size of " + size);
    }

    public boolean isEmpty() {
        return backOfQueue == -1;
    }

    public boolean isFull() {
        if (backOfQueue + 1 == beginningOfQueue) {
            return true;
        } else return beginningOfQueue == 0 && backOfQueue + 1 == size;
    }

    public void enQueue(int value) {
        if (isFull()) {
            System.out.println("The CQ is full");
        } else if (isEmpty()) {
            beginningOfQueue = 0;
            backOfQueue++;
            arr[backOfQueue] = value;
            System.out.println("Successfully inserted " + value + " in the Circular queue");
        } else {
            if (backOfQueue + 1 == size) {
                backOfQueue = 0;
            } else {
                backOfQueue++;
            }
            arr[backOfQueue] = value;
            System.out.println("Successfully inserted " + value + " in the Circular queue");
        }
    }

    public int deQueue() {
        if (isEmpty()) {
            System.out.println("CQueue us empty");
            return -1;
        } else {
            int result = arr[beginningOfQueue];
            arr[beginningOfQueue] = 0;

            if (beginningOfQueue == backOfQueue) {
                beginningOfQueue = -1;
                backOfQueue = -1;
            } else if (beginningOfQueue + 1 == size) {
                beginningOfQueue = 0;
            } else {
                beginningOfQueue++;
            }
            return result;
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

    public void deleteCQ() {
        this.arr = null;
        this.backOfQueue = -1;
        this.beginningOfQueue = -1;
        System.out.println("The Circular Queue is deleted!");
    }
}
