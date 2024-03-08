package com.akshay.graph.MST;

public class LeetCode_1319 {

	public static int makeConnected(int n, int[][] connections) {
		DisJointSet ds = new DisJointSet(n);
		int cntExtras = 0;
		int cnt = 0;
		for(int[] c:connections) {
			int u = c[0];
			int v = c[1];
			if(ds.getUParent(u)== ds.getUParent(v)) {
				cntExtras++;
			}
			else {
				ds.unionByRank(u, v);
			}
		}
		
		for(int i=0;i<n;i++) {
			if(ds.parent.get(i) == i) {
				cnt++;
			}
		}
		if(cntExtras >= cnt-1) {
			return cnt-1;
		}
		return -1;
	}
	
	public static void main (String[] args) {
        int V = 9;
        int[][] edge = {{0, 1}, {0, 2}, {0, 3}, {1, 2}, {2, 3}, {4, 5}, {5, 6}, {7, 8}};

        int ans = makeConnected(V, edge);
        System.out.println("The number of operations needed: " + ans);

    }
}
