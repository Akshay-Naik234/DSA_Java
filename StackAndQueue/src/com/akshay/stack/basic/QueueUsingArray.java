package com.akshay.stack.basic;

class Queue {
	int capacity;
	int front;
	int rear;
	int[] q;
	int cnt;

	public Queue(int capacity) {
		this.capacity = capacity;
		q = new int[capacity];
		this.front = 0;
		this.rear = 0;
		this.cnt = 0;
	}

	void push(int num) {
		if (cnt == capacity) {
			System.out.println("Queue is full");
		} else {
			q[rear % capacity] = num;
			rear++;
			cnt++;
		}
	}

	int pop() {
		if (cnt == 0) {
			return -1;
		}
		int res = q[front % capacity];
		front++;
		return res;
	}

	int top() {
		if (cnt == 0) {
			return -1;
		}
		return q[front % capacity];
	}
}

public class QueueUsingArray {
	public static void main(String[] args) {
		Queue q = new Queue(5);
		q.push(4);
		q.push(14);
		q.push(24);
		q.push(34);
		q.push(34);
		q.push(24);
		int pop = q.top();
		System.out.println(pop);
	}
}
