package com.algo.dp;

// Longest increasing continuous numbers
public class LICN {

	public static void main(String[] args) {
		
		int[] A = {10, 22, 9, 33, 21, 50, 41, 60};
		lis(A);
	}
	
	private static void lis(int[] A) {
		
		int i = 0, j = 0, length = 0, maxLength = 0;
		
		for (int k = 0; k < A.length-1; k++) {
			
			if(A[k+1] > A[k]) {
				length++;
				
				if(maxLength < length) {
					maxLength = length;
					j = k+1;
				}
			} else {
				length = 0;				
			}
		}
		
		if(maxLength != 0) {
			i = j - maxLength;
		}
		
		System.out.println("i: "+i+", j: "+j+", length: "+(maxLength+1));
		
		if(i >= 0 && j >= 0)
			for (int k = i; k <= j; k++)
				System.out.print(A[k]+" ");
	}
}
