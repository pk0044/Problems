package com.pk.Problems;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class Arrays {
	private int[] array;
	private ArrayList<Integer> arr;
	private ArrayList<Character> charArr;
	public void takeInputs() {
		
		if(arr == null) {
			arr = new ArrayList<Integer>();
		}
		if(charArr == null) {
			charArr = new ArrayList<Character>();
		}
//		arr.add(100);
//		arr.add(-100);
//		arr.add(1000);
//		arr.add(80);
//		arr.add(1005);
//		arr.add(27);
//		arr.add(305);
//		arr.add(-8);
//		arr.add(105);
//		arr.add(60);
		
		arr.add(1);
		arr.add(2);
		arr.add(3);
		arr.add(4);
		arr.add(5);
		arr.add(-6);
		arr.add(-7);
		arr.add(-8);
		arr.add(-9);
		arr.add(-10);
		
		charArr.add('a');
		charArr.add('a');
		charArr.add('a');
		charArr.add('s');
		charArr.add('s');
		charArr.add('d');
		charArr.add('e');
		charArr.add('e');
		charArr.add('e');
		charArr.add('e');
		//arr.add(60);
	}
	
	
	public void display() {
		for(int i=0; i<arr.size(); i++) {
			System.out.println(arr.get(i));
		}
//		System.out.println("###########################");
//		System.out.println(arr.size());
	}
	
	
	private void swap(int i, int j) {
		int temp;
		temp = arr.get(i);
		arr.set(i, arr.get(j));
		arr.set(j, temp);
	}
	
	int partition(int low, int high) {
		int pivot = arr.get(high);
		
		int i = low - 1;
		
		for(int j=low; j<high; j++) {
			if(arr.get(j) < pivot) {
				i++;
				swap(j,i);
			}
		}
		
		swap(i+1, high);
		
		
		return i+1;
	}
	
	/**
	 * function for quicksort
	 * @param low
	 * @param high
	 */
	public void quicksort(int low, int high) {
		if(low < high) {
			int pi = partition(low, high);
			quicksort(low, pi - 1);
			quicksort(pi+1, high);
		}
	}
	
	
	public void arrangePosNegNums() {
		Queue<Integer> pos = new LinkedList<>();
		Queue<Integer> neg = new LinkedList<>();
		
		for(int i=0; i<arr.size(); i++) {
			if(arr.get(i) <= 0) {
				pos.add(arr.get(i));
			}else {
				neg.add(arr.get(i));
			}
		}
		
		int index = 0;
		
		while(true) {
			if(pos.size() == 0 || neg.size() == 0) {
				break;
			}
			
			if(index % 2 == 1) {
				arr.set(index, neg.remove());
				System.out.println("--->" + index + " --> " + arr.get(index));
			}else {
				System.out.println("-->" + index + " --> " + arr.get(index));
				arr.set(index, pos.remove());
			}
			
			index++;
		}
		
		while(neg.size() > 0) {
			arr.set(index, neg.remove());
			index++;
		}
		
		while(pos.size() > 0) {
			arr.set(index, pos.remove());
			index++;
		}
	}
	
	
	
	public void mergeSort(int start, int end) {
		if(start < end) {
			int mid = (end - start) / 2;
			
		}
	}
	
	/**
	 * function to print duplicates in array with constant extra space
	 */
	
	public void printDuplicates(int N) {
		int num;
		for(int i=0; i<N; i++) {
			//System.out.println(arr.get(i));
			num = arr.get(i) % 10;
			arr.set(num , arr.get(num) + 10);
		}
		
		for(int i=0; i<N; i++) {
			if(arr.get(i) > 19) {
				System.out.println(i);
			//	System.out.println(arr.get(i));
			}
		}
	//	System.out.println("djflsdj");
	}
	
	
	/**
	 * method to solve problem
	 * aaabbc => a3b2c1
	 */
	
	public void shrinkArray() {
		char currentChar = charArr.get(0);
		char currentIndex = 0;
		int currentCount = 1;
		
		for(int i=1; i<charArr.size(); i++) {
			if(charArr.get(i-1).equals(charArr.get(i))) {
				currentCount++;
			}else {
				currentIndex++;
				char c = (char) (currentCount + '0');
				charArr.set(currentIndex, c);
				if(i < charArr.size()-1) {
					currentIndex++;
					charArr.set(currentIndex, charArr.get(i));
					currentCount = 1;
					currentChar = charArr.get(i);
				}
			}
		}
		//currentChar = charArr.get(charArr.size() - 1);
		//currentIndex++;
		char ch = (char) (currentCount + '0');
		//charArr.set(currentIndex, currentChar);
		currentIndex++;
		if(currentCount == 1) {
			charArr.add(ch);
		}else {
			charArr.set(currentIndex, ch);
		}

		
		for(int i=0; i<charArr.size(); i++) {
			System.out.println(charArr.get(i));
		}
	}
	
	
//	public int findSubArrayWithSum(int k) {
//		int size = arr.size();
//		int[] sums;
//		int flag = 0;
//		int res = 0;
//		sums = new int[size];
//		sums[0] = arr.get(0);
//		for(int i=1; i<size; i++) {
//			sums[i] = sums[i-1] + arr.get(i); 
//		}
//		
//		for(int i=0; i<size-1; i++) {
//			if(sums[])
//			for(int j=i+1; j<size; j++) {
//				if(sums[j] == k) {
//					res++;
//				}
//			}
//		}
//		return res;
//	}

	/**
	 * maximum difference between two elements such that larger elements appears after small elements
	 */

	int maxDiff(int arr[], int n){
		int res = Integer.MIN_VALUE;

		int i = 0;
		int temp = 0;

		int min = Integer.MAX_VALUE;
		int max = Integer.MIN_VALUE;

		while(i < n - 1){
			while(i < n-1 && arr[i + 1] < arr[i]){
				i++;
			}

			if(arr[i] < min){
				min = arr[i];
			}
			i++;

			while(i < n-1 && arr[i] < arr[i+1]){
				i++;
			}

			temp = arr[i] - min;

			if(temp > res){
				res = temp;
			}

		}

		return res;
	}
	
	/**
	 * find the minimum number of jumps to reach the end of an array
	 */
	
	public int minSteps(int a[], int start, int end) {
		int min = Integer.MAX_VALUE;
		for(int i=1; i<= a[start]; i++) {
			if(start + i == end) {
				return 1;
			}
			int steps = 1 + minSteps(a, start+i, end);
			
			if(steps < min) {
				min = steps;
			}
		}
		return min;
	}
	
	
	public double myPow(double x, int n) {
		if(n == 0) {
			return 1;
		}
		
		if(n < 0) {
			return (1/ x ) * myPow(x , n + 1);
		}
		
		return x * myPow(x, n - 1);
	}
}
