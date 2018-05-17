package com.jiyongjun.algorithm;

/**
 * @author jiyongjun
 * @create 2018-05-17 20:42
 * @desc 链表实现队列
 **/
public class Queue {
    private int maxSize;
    private Long[] queArray;
    private int front;
    private int rear;
    private int nItems;

    public Queue(int maxSize) {
        this.maxSize = maxSize;
        queArray = new Long[maxSize];
        front = 0;
        rear = -1;
        nItems = 0;
    }

    public void insert(Long j) {
        if (isFull()) {
            throw new RuntimeException("Queue is full! cannot insert!");
        }
        if (rear == maxSize - 1) {
            rear = -1;
        }
        queArray[++rear] = j;
        nItems++;
    }

    public Long remove() {
        if (isEmpty()) {
            throw new RuntimeException("Queue is empty!");
        }
        Long j = queArray[front++];
        if (front == maxSize) {
            front = 0;
        }
        nItems--;
        return j;
    }

    public Long peekFront() {
        return queArray[front];
    }

    public boolean isEmpty() {
        return nItems == 0;
    }

    public boolean isFull() {
        return nItems == maxSize;
    }

    public int size() {
        return nItems;
    }

    public static void main(String[] args) {
        Queue queue = new Queue(10);
        queue.insert(10L);
        queue.insert(20L);
        queue.insert(30L);
        queue.insert(40L);
        queue.remove();
        queue.remove();
        queue.remove();
        queue.insert(50L);
        queue.insert(60L);
        queue.insert(70L);
        queue.insert(80L);
        queue.insert(90L);

        while (!queue.isEmpty()) {
            Long temp = queue.remove();
            System.out.println(temp);
        }

    }

}
