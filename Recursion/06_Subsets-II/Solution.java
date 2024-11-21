class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums); 
        generateSubsets(0, nums, new ArrayList<>(), result);
        return result;
    }

    private void generateSubsets(int index, int[] nums, List<Integer> current, List<List<Integer>> result) {
        result.add(new ArrayList<>(current)); 

        for (int i = index; i < nums.length; i++) {
            if (i > index && nums[i] == nums[i - 1]) continue;
            current.add(nums[i]);
            generateSubsets(i + 1, nums, current, result);
            current.remove(current.size() - 1);
        }
    }
}
