package com.pk.Problems;

public class Segment {
	private int[] a;
	private int[] sTree;
	private int[] sTreeMin;
	private int[] sTreeMax;
	private int n;
	private int tSize;
	
	public Segment(int n) {
		a = new int[n];
		this.n = n;
		int h = (int) Math.ceil(Math.log(n) / Math.log(2));
		tSize = (int) (2 * Math.pow(2, h)) -1;
		sTree = new int[tSize];
		sTreeMin = new int[tSize];
		sTreeMax = new int[tSize];
	}
	
	
	
	/**
	 * utility function to fill input array
	 */
	public void insertArray() {
		a[0] = 1;
		a[1] = 2;
		a[2] = 3;
		a[3] = 4;
		a[4] = 5;
		a[5] = 6;
		a[6] = 7;
		a[7] = 8;
		a[8] = 9;
		a[9] = 10;

	}
	
	
	/**
	 * function to get the sum of range (ql - qr) in input array
	 * @param l - start index of input array
	 * @param r - end index of input array
	 * @param ql - start index of query range 
	 * @param qr - end index of query range
	 * @param pos - index of parent element in range (l-r)
	 * @return
	 */
	public int query(int l, int r, int ql, int qr, int pos)  
	{  
		if(ql <= l && qr >= r) { // full overlap
			return sTree[pos];
		}
		
		if(qr < l || ql > r) { // no overlap
			return 0;
		}
		
		int mid = (l + r) / 2;  // partial overlap
		
		return query(l, mid, ql, qr, 2*pos) + query(mid+1, r, ql, qr, 2*pos+1);
	}
	
	
	/**
	 * function to query minimum value in range (qStart, qEnd) in an input array
	 * @param start
	 * @param end
	 * @param qStart
	 * @param qEnd
	 * @param pos
	 * @return
	 */
	public int minimumRangeQuery(int start, int end, int qStart, int qEnd, int pos) {
		if(qStart <= start && qEnd >= end) {   // full overlap
			return sTreeMin[pos];
		}
		
		if(qStart > end || qEnd < start) { // no overlap
			return Integer.MAX_VALUE;
		}
		
		int mid = (start + end) / 2;  // partial overlap
		
		int leftMin = minimumRangeQuery(start, mid, qStart, qEnd, 2 * pos);
		int rightMin = minimumRangeQuery(mid+1, end, qStart, qEnd, 2 * pos + 1);
		
		return leftMin < rightMin ? leftMin : rightMin;
	}
	
	
	/**
	 * function to query maximum value in range (qStart, qEnd) in an input array
	 * @param start
	 * @param end
	 * @param qStart
	 * @param qEnd
	 * @param pos
	 * @return
	 */
	public int maximumRangeQuery(int start, int end, int qStart, int qEnd, int pos) {
		if(qStart <= start && qEnd >= end) {   // full overlap
			return sTreeMax[pos];
		}
		
		if(qStart > end || qEnd < start) { // no overlap
			return Integer.MIN_VALUE;
		}
		
		int mid = (start + end) / 2;  // partial overlap
		
		int leftMax = maximumRangeQuery(start, mid, qStart, qEnd, 2 * pos);
		int rightMax = maximumRangeQuery(mid+1, end, qStart, qEnd, 2 * pos + 1);
		
		return leftMax > rightMax ? leftMax : rightMax;
	}
	
	/**
	 * building segment tree for minimum range query
	 * @param l
	 * @param r
	 * @param pos
	 */
	public void buildRangMinSeg(int l, int r, int pos) {
		
		if(l == r) {
			sTreeMin[pos] = a[l];
			return;
		}
		
		int mid = (l + r) / 2;
		buildRangMinSeg(l, mid, 2 * pos);
		buildRangMinSeg(mid + 1, r, 2 * pos + 1);
		
		sTreeMin[pos] = sTreeMin[2 * pos] < sTreeMin[2 * pos + 1] ? sTreeMin[2 * pos] : sTreeMin[2 * pos + 1];
	} 
	
	
	/**
	 * function to build segment tree for maximum range query
	 * @param start
	 * @param end
	 * @param pos
	 */
	public void buiildRangMaxSeg(int start, int end, int pos) {
		
		if(start == end) {
			sTreeMax[pos] = a[start];
			return;
		}
		
		int mid = (start + end) / 2;
		buiildRangMaxSeg(start, mid, 2 * pos);
		buiildRangMaxSeg(mid+1, end, 2 * pos + 1);
		
		sTreeMax[pos] = sTreeMax[2 * pos] > sTreeMax[2 * pos + 1] ? sTreeMax[2 * pos] : sTreeMax[2 * pos + 1];
		
	} 
	
	
	
	/**
	 * function to build the segment tree array
	 * @param l - start index of input array
	 * @param r - end index of input array
	 * @param pos - index of parent element in segment tree array
	 * @return
	 */
	public void buildSegmentTree(int l, int r, int pos) {
		
		if(l == r) {
			sTree[pos] = a[l];
			return;
		}
		int mid = (l + r) / 2;
		buildSegmentTree(l, mid, 2 * pos);
		buildSegmentTree(mid+1, r, (2 * pos) + 1);
		sTree[pos] =  + sTree[2 * pos] + sTree[2 * pos + 1];
	}
	
	/**
	 * function to find the index of an element in segment tree array which have position pos in array a[] 
	 * @param l - start index of input array
	 * @param r - end index of input array
	 * @param pos - index of element in input array
	 * @param sTreePos - index of parent element in segment tree
	 * @return
	 */
	public int findIndex(int l, int r, int pos, int sTreePos) {
		if(l == r) {
			return sTreePos;
		}
		
		int mid = (l + r) / 2;
		
		return pos <= mid ? findIndex(l, mid, pos, sTreePos*2) : findIndex(mid+1, r, pos, sTreePos*2+1);

	}
	
	/**
	 * function to update the value in array a[] at position pos with value val
	 * @param pos - index of element in input array
	 * @param val - new value to be updated
	 */
	public void update(int pos, int val) {
		
		int index = findIndex(0, n-1, pos, 1);
		
		int diff = val - sTree[index];
		sTree[index] = val;
		
		while(index >= 1) {
			sTree[index/2] = sTree[index/2] + diff;
			index = index / 2;
		}
	}
	
	/**
	 * fucntion to update the minimum Segment tree
	 * @param pos - position index at input array
	 * @param val - new value to be updated in input array
	 */
	public void updateMinSegTree(int pos, int val) {
		int index = findIndex(0, n-1, pos, 1);
		
		while(index >= 1) {
			sTreeMin[index / 2] = sTreeMin[index] < sTreeMin[index / 2] ? sTreeMin[index] : sTreeMin[index / 2];
			index = index / 2;
		}
	}
	
	/**
	 * function to update maximum segment tree with new value
	 * @param pos
	 * @param val
	 */
	public void updateMaxSegTree(int pos, int val) {
		int index = findIndex(0, n-1, pos, 1);
		
		while(index >= 1) {
			sTreeMax[index / 2] = sTreeMax[index] > sTreeMax[index / 2] ? sTreeMax[index] : sTreeMax[index / 2];
			index = index / 2;
		}
	}
	
	/**
	 * function to display the content of segment tree array
	 */
	public void display() {
		System.out.println("----------------------------- SUM -----------------------------------");
		for(int i=1; i<tSize; i++) {
			System.out.print(sTree[i] + " ");
		}
		System.out.println();
		
		System.out.println("----------------------------- MIN -----------------------------------");
		for(int i=1; i<tSize; i++) {
			System.out.print(sTreeMin[i] + " ");
		}
		System.out.println();
		
		System.out.println("----------------------------- MAX -----------------------------------");
		for(int i=1; i<tSize; i++) {
			System.out.print(sTreeMax[i] + " ");
		}
		System.out.println();
		System.out.println("----------------------------------------------------------------");
	}
	

}
