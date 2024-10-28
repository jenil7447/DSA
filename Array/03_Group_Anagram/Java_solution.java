class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        if(strs.length == 0 || strs==null)return new ArrayList<>();
        HashMap<String, List<String>> map = new HashMap<>();
            for(String str : strs){
            char[] charArray = str.toCharArray();
            Arrays.sort(charArray);
            String sorted =new String(charArray);

            if(!map.containsKey(sorted)){
            map.put(sorted,new ArrayList<>());
            }
            map.get(sorted).add(str);
        }
    return  new ArrayList<>(map.values());

    }
}
