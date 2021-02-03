package com.leetcode.easy;

import java.util.*;


class Node {
    int numOfoccurance;
    ArrayList<Integer> indexArray;
    
    Node() {
        this.numOfoccurance = 0;
        this.indexArray = new ArrayList<Integer>();       
    }
}

class twoSumQ {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Node> numHashMap = new HashMap<Integer, Node>();
        
        for(int i = 0; i < nums.length; i++) {
            if(numHashMap.containsKey(nums[i])){
                // valueArray = {numOfoccurance, [i_position_in_nums]}
                Node valueNode = numHashMap.get(nums[i]);
                
                int numOfoccurance = valueNode.numOfoccurance + 1;
                // get the index position array
                ArrayList<Integer> indexArray = valueNode.indexArray;
                // add the new position
                indexArray.add(i);
                // update the array
                valueNode.indexArray = indexArray;
                valueNode.numOfoccurance = numOfoccurance;
                    
                numHashMap.put(nums[i], valueNode);
            } else {
                Node newNode = new Node();

                newNode.numOfoccurance = 1;

                ArrayList<Integer> indexArray = new ArrayList<Integer>();
                indexArray.add(i);

                newNode.indexArray = indexArray;
                
                numHashMap.put(nums[i], newNode);                
            }                                              
        }
        
        int otherHalf = 0;
        for(int key: numHashMap.keySet()) {
            otherHalf = target - key;

            if(otherHalf == key) {
                // check if the key's value's numOfoccurance = 2
                Node valueNode = numHashMap.get(key);
                int numOfoccurance = valueNode.numOfoccurance;
                
                ArrayList<Integer> indexArray = valueNode.indexArray;
                    
                if (numOfoccurance == 2) {
                    int[] result = new int[indexArray.size()];
                    for (int i = 0; i < result.length; i++)
                    {
                        result[i] = indexArray.get(i).intValue();
                    }

                    return result;
                } else {
                    continue;
                }                                        
            }
                
            if (numHashMap.containsKey(otherHalf)) {
                // return the index of key and otherHalf
                int[] result = new int[2];
                    
                Node nodeResult1 = numHashMap.get(key);
                ArrayList<Integer> indexArray1 = nodeResult1.indexArray;
                int positionKey1 = indexArray1.get(0);
                    
                Node nodeResult2 = numHashMap.get(otherHalf);
                ArrayList<Integer> indexArray2 = nodeResult2.indexArray;
                int positionKey2 = indexArray2.get(0);
                    
                result[0] = positionKey1;
                result[1] = positionKey2;
                    
                return result;                                                                                       
            } else {
                    continue;
            }                                               
        }        
    
        int[] result = new int[2];

        return result;
    }

    public static void main(String[] args) {
        // int[] nums1 = {2,7,11,15};
        // int target1 = 9;

        // twoSumQ test1 = new twoSumQ();

        // int[] result1 = test1.twoSum(nums1, target1);
        
        // System.out.println("[" + result1[0] + "," + result1[1] + "]");

        // int[] nums2 = {3,3};
        // int target2 = 6;

        // twoSumQ test2 = new twoSumQ();

        // int[] result2 = test2.twoSum(nums2, target2);

        int[] nums3 = {-1,-2,-3,-4,-5};
        int target3 = -8;

        twoSumQ test3 = new twoSumQ();

        int[] result3 = test3.twoSum(nums3, target3);
     
        System.out.println("[" + result3[0] + "," + result3[1] + "]");
	}
}
