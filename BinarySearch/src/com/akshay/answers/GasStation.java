package com.akshay.answers;

import java.util.PriorityQueue;

public class GasStation {

	public static double MinimiseMaxDistance(int[] arr, int K) {
		int n = arr.length;
		int[] howMany = new int[n - 1];
		PriorityQueue<Pair> pq = new PriorityQueue<>((a, b) -> Double.compare(b.first, a.first));

		for (int i = 0; i < n-1; i++) {
			pq.add(new Pair((double)(arr[i + 1] - arr[i]), i));
		}
		for (int i = 1; i <= K; i++) {
			Pair tq = pq.poll();
			int secInd = tq.getSecond();
			howMany[secInd] = howMany[secInd] + 1;
			double diff = arr[secInd + 1] - arr[secInd];
			double s = diff / ((double) howMany[secInd] + 1);
			pq.add(new Pair(s, secInd));
		}

		return pq.peek().first;

	}

	public static void main(String[] args) {
		int[] arr = { 1, 2, 3, 4, 5 };
		double b = MinimiseMaxDistance(arr, 4);
		System.out.println(b);
	}
}
