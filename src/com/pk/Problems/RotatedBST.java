package com.pk.Problems;

public class RotatedBST {
	
	// [4,5,6,7,0,1,2]
	private int BST(int[] nums, int start, int end, int target) {
		if(start > end) {
			return -1;
		}
		
		int mid = (start + end) / 2;
		
		if(nums[mid] == target) {
			return mid;
		}
		
		if(nums[start] <= nums[mid]) {
			if(target >= nums[start] && target < nums[mid]) {
				return BST(nums, start, mid-1, target);
			}
			
			return BST(nums, mid+1, end, target);
		}
		
		if(target > nums[mid] && target <= nums[end]) {
			return BST(nums, mid+1, end, target);
		}
		
		return BST(nums, start, mid-1, target);
		
	}
	
    public int search(int[] nums, int target) {
    	int size = nums.length;
    	
		return BST(nums, 0, size-1, target);
    }
}
