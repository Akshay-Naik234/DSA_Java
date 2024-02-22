package com.akshay.OneD;

public class FloorAndCeil {
	public static int getCeil(int[] a, int n, int x) {
		int low = 0;
		int high = n - 1;
		int ans = -1;
		while (low <= high) {
			int mid = (low + high) / 2;
			if (a[mid] >= x) {
				ans = a[mid];
				high = mid - 1;
			} else {
				low = mid + 1;
			}
		}
		return ans;
	}

	public static int getFloor(int[] a, int n, int x) {
		int low = 0;
		int high = n - 1;
		int ans = -1;
		while (low <= high) {
			int mid = (low + high) / 2;
			if (a[mid] <= x) {
				ans = a[mid];
				low = mid + 1;
			} else {
				high = mid - 1;
			}
		}
		return ans;
	}

	public static int[] getFloorAndCeil(int[] a, int n, int x) {
		int[] res = new int[] { -1, -1 };
		res[0] = getFloor(a, n, x);
		res[1] = getCeil(a, n, x);
		return res;
	}

	public static void main(String[] args) {
		int[] arr = { 3, 4, 4, 7, 8, 10 };
		int[] floorAndCeil = getFloorAndCeil(arr, arr.length, 2);
		System.out.println(floorAndCeil[0] + " " + floorAndCeil[1]);
	}
}
