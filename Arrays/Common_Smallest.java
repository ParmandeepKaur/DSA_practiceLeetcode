class Solution {
    public int getCommon(int[] nums1, int[] nums2) {
        int i = 0;
        int j = 0;
        while (i<nums1.length && j<nums2.length){
            if(nums1[i]==nums2[j]){
                return nums1[i];
            }else if (nums1[i]>nums2[j]){
                j++;
            }else{
                i++;
            }
        }
        return -1;
        // int common_smallest = Integer.MAX_VALUE;
        // for (int i = 0; i < nums1.length; i++){
        //     for (int j = 0; j<nums2.length; j++){
        //         if (nums1[i]==nums2[j]){
        //             if (nums1[i]<common_smallest){
        //                 common_smallest = nums1[i];
        //             }
        //         }
        //     }
        // }
        // return common_smallest;
    }
}