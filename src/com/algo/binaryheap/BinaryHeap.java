package com.algo.binaryheap;

public class BinaryHeap {

	public static void main(String[] args) {
		int[] heap = {23, 43, 26, 10, 21, 13, 31, 16, 12, 8, 29, 11, 19, 17};
		buildHeap(heap);
		System.out.println("Constructed heap:");
		for (int i = 0; i < heap.length; i++) {
			System.out.print(heap[i]+" ");
		}
		System.out.println();
		System.out.println("Sorted in descending order:");
		sort(heap);
		for (int k = 0; k < heap.length; k++) {
			System.out.print(heap[k]+" ");
		}
	}
	
	private static void buildHeap(int[] heap) {
		int N = heap.length;
		
		for(int i = N/2; i >= 0; i--) {
			heapify(i, N, heap);
		}
	}
	
	private static void sort(int[] heap) {
		int N = heap.length;
		
		for(int i = 1; i < N; i++) {
			
			swap(0, N-i, heap);			
			heapify(0, N-i, heap);
		}
	}
	
	private static void heapify(int i, int N, int[] heap) {
		
		int smallest = i;
		int L = 2*i + 1;
		int R = 2*i + 2;
		
		if(L < N && heap[L] < heap[smallest])
			smallest = L;
		
		if(R < N && heap[R] < heap[smallest])
			smallest = R;
		
		if(smallest != i) {
			swap(i, smallest, heap);
			heapify(smallest, N, heap);
		}		
	}
	
	private static void swap(int i, int j, int[] heap) {
		int temp = heap[i];
		heap[i] = heap[j];
		heap[j] = temp;
	}
}
