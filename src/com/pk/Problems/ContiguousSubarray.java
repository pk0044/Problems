package com.pk.Problems;

import java.util.HashMap;
import java.util.Map;

public class ContiguousSubarray {
    public int findMaxLength(int[] nums) {
        int size = nums.length;
        
        int max = -1;
        
        if(size < 2){
            return 0;
        }
        
        if(size == 2){
            if(nums[0] + nums[1] == 1){
                return 2;
            }else{
                return 0;
            }
        }
        
        for(int i=0; i<size; i++){
            if(nums[i] == 0){
                nums[i] = -1;
            }
        }
        
        int[] sumArray = new int[size];
        sumArray[0] = nums[0];
        
        for(int i=1; i<size; i++){
            sumArray[i] = nums[i] + sumArray[i-1];
            if(sumArray[i] == 0) {
            	max = i + 1;
            }
        }
        
        if(sumArray[size-1] == 0) {
        	return size;
        }
        
        Map<Integer, Integer> mapIndex = new HashMap<Integer, Integer>();
        
        
        int diff = 0;
        
        for(int i=0; i<size; i++){
            if(mapIndex.containsKey(sumArray[i])){
                diff = i - mapIndex.get(sumArray[i]);
                if(diff > max){
                    max = diff;
                }
            }else{
                mapIndex.put(sumArray[i], i);
            }
        }
        
        return max;
    }
}
