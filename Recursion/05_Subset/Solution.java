class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        generateSubsets(0,nums,new ArrayList<>(),result);
        return result;
    }
    public void generateSubsets(int index, int[] nums, List<Integer> current, List<List<Integer>> result){
       if(index == nums.length){
        result.add(new ArrayList<>(current));
        return;
       }
        generateSubsets(index + 1,nums,current,result);

        current.add(nums[index]);
        generateSubsets(index + 1,nums,current,result);

        current.remove(current.size()-1);
        }
}
