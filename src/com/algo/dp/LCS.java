package com.algo.dp;

public class LCS {

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
		
		lcs(A.toCharArray(), B.toCharArray(), T);
		
		System.out.println(T[A.length()][B.length()]);
		System.out.println(backtrack(A.toCharArray(), B.toCharArray(), A.length()-1, B.length()-1, new String[A.length()][B.length()]));
	}
	
	private static void lcs(char[] A, char[] B, String[][] T) {
		
		for (int i = 0; i < A.length; i++) {
			for (int j = 0; j < B.length; j++) {
				
				if(A[i] != B[j]) {
					if(T[i+1][j].length() > T[i][j+1].length()) {
						T[i+1][j+1] = T[i+1][j];
					} else {
						T[i+1][j+1] = T[i][j+1];
					}
				} else {
					T[i+1][j+1] = T[i][j] + A[i];
				}
			}
		}		
	}
	
	private static String backtrack(char[] A, char[] B, int i, int j, String[][] T) {
		
		if(i == 0 || j == 0)
			return "";
		
		if(A[i] == B[j]) {
			if(T[i][j] == null) {
				T[i][j] = backtrack(A, B, i-1, j-1, T) + A[i];				
			}
			return T[i][j];
		}
		else {
			
			if(T[i][j-1] == null)
				T[i][j-1] = backtrack(A, B, i, j-1, T);
			if(T[i-1][j] == null)
				T[i-1][j] = backtrack(A, B, i-1, j, T);
			
			if(T[i][j-1].length() > T[i-1][j].length())
				return T[i][j-1];
			else
				return T[i-1][j];
		}
	}
}
