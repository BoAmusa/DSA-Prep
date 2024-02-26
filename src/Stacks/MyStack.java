package Stacks;

public class MyStack {
    private int[] arr;
    int topOfStack;

    public MyStack(int size) {
        this.arr = new int[size];
        this.topOfStack = -1;
        System.out.println("Stack created with size " + size);
    }

    public boolean isEmpty() {
        if (topOfStack == -1) {
            System.out.println("Stack is empty");
            return true;
        } else {
            return false;
        }
    }

    public boolean isFull() {
        if (topOfStack == arr.length - 1) {
            System.out.println("The stack is full");
            return true;
        } else {
            return false;
        }
    }

    public void push(int value) {
        if (isFull()) {
            System.out.println("Stack is full");
        } else {
            arr[topOfStack + 1] = value;
            topOfStack++;
            System.out.println("Value successfully inserted");
        }
    }

    public int pop() {
        if (isEmpty()) {
            return -1;
        } else {

            int value = arr[topOfStack];
            System.out.println("Value Popped " + value);
            topOfStack--;
            return value;
        }
    }

    public int peek() {
        if (isEmpty()) {
            return -1;
        } else {
            return arr[topOfStack];
        }
    }

    public void deleteStack() {
        arr = null;
        System.out.println("Stack is deleted");
    }
}
