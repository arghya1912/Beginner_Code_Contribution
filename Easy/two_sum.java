class Solution {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer,Integer> m=new HashMap<>();
        int arr[]=new int[2];
        int i=0;
        for(int x:nums){
            if(m.containsKey(target-x)){
                arr[0]=i;
                arr[1]=m.get(target-x);
                break;
            }
            m.put(x,i);
            i++;
        }
        return arr;
    }
}