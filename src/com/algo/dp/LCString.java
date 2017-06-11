package com.algo.dp;

public class LCString {

	public static void main(String[] args) {		
		String A = "abcd";
		String B = "xbyced";
		
		String[][] T = new String[A.length()+1][B.length()+1];
		
		for (int i = 0; i < A.length()+1; i++) {
			T[i][0] = "";
		}
		for (int i = 0; i < B.length()+1; i++) {
			T[0][i] = "";
		}
		
		String result = lcs(A.toCharArray(), B.toCharArray(), T);
		System.out.println(result);
	}
	
	private static String lcs(char[] A, char[] B, String[][] T) {
		
		String result = "";
		for (int i = 0; i < A.length; i++) {
			for (int j = 0; j < B.length; j++) {
				
				if(A[i] == B[j]) {
					T[i+1][j+1] = T[i][j] + A[i];
					
					if(result.length() < T[i+1][j+1].length())
						result = T[i+1][j+1];
				} else {
					T[i+1][j+1] = "";
				}
			}
		}
		
		return result;
	}
}
