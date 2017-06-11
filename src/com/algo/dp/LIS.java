package com.algo.dp;

// Longest increasing subsequence
public class LIS {

	public static void main(String[] args) {
		
		int[] A = {10, 22, 9, 33, 21, 50, 41, 60};
		lis(A);
	}
	
	private static void lis(int[] A) {
		
		int[] T = new int[A.length];
		
		for (int i = 0; i < T.length; i++) {
			T[i] = 1;
		}
		
		for (int i = 0; i < T.length; i++) {
			for (int j = 0; j < i; j++) {
				
				if(A[j] < A[i]) {
					
					if(T[i] < T[j] + 1) {
						T[i] = T[j] + 1;						
					}
				}
			}
		}
		
		int max = 0;
		for (int i = 0; i < T.length; i++) {
			if(max < T[i])
				max = T[i];
		}
		
		System.out.println("Length: "+max);
	}
}
