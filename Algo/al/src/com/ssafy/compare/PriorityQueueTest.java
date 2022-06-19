package com.ssafy.compare;

import java.util.Comparator;
import java.util.PriorityQueue;

public class PriorityQueueTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		PriorityQueue<Student> pQueue = new PriorityQueue<>(new Comparator<Student>() {

			@Override
			public int compare(Student o1, Student o2) {
				// TODO Auto-generated method stub
				return o1.score - o2.score;
			}
		});
		
		pQueue.offer(new Student(4,20));
		pQueue.offer(new Student(1,60));
		pQueue.offer(new Student(3,50));
		
		System.out.println(pQueue.poll());
		System.out.println(pQueue.poll());
		System.out.println(pQueue.poll());
	}

}
