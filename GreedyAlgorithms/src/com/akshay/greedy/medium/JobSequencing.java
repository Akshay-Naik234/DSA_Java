package com.akshay.greedy.medium;

import java.util.Arrays;
import java.util.Comparator;

public class JobSequencing {

	static class Job {
		int id, profit, deadline;

		Job(int x, int y, int z) {
			this.id = x;
			this.deadline = y;
			this.profit = z;
		}
	}

	static class JobComparator implements Comparator<Job> {

		@Override
		public int compare(Job o1, Job o2) {
			return o2.profit - o1.profit;
		}

	}

	static int[] JobScheduling(Job arr[], int n) {
		Arrays.sort(arr, new JobComparator());
		int maxi = 0;
		for (Job job : arr) {
			if (job.deadline > maxi) {
				maxi = job.deadline;
			}
		}
		int[] visited = new int[maxi + 1];
		Arrays.fill(visited, -1);
		int cnt = 0;
		int profit = 0;
		for (int i = 0; i < n; i++) {
			for (int j = arr[i].deadline; j > 0; j--) {
				if (visited[j] == -1) {
					cnt++;
					profit += arr[i].profit;
					visited[j] = i;
					break;
				}
			}
		}
		int[] ans = new int[2];
		ans[0] = cnt;
		ans[1] = profit;
		return ans;
	}

	public static void main(String[] args) {
		Job[] arr = new Job[4];
		arr[0] = new Job(1, 4, 20);
		arr[1] = new Job(2, 1, 10);
		arr[2] = new Job(3, 2, 40);
		arr[3] = new Job(4, 2, 30);
		int[] res = JobScheduling(arr, 4);
		System.out.println(res[0] + "  "+res[1]);
	}
}
