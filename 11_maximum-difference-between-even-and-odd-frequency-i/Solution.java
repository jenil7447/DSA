class Solution {
    public int maxDifference(String s) {
        HashMap<Character,Integer> map = new HashMap<>();

        for(int  i = 0; i < s.length(); i++){
            map.put(s.charAt(i) , map.getOrDefault(s.charAt(i),0) + 1 );
        }

        int minEvenFre = Integer.MAX_VALUE;
        int maxOddFre = 0;

        for(int val : map.values()){
            if(val % 2 == 0){
                if( minEvenFre > val){
                    minEvenFre = val;
                }
                
            }
            else{
                    if(maxOddFre < val){
                        maxOddFre = val;
                    }
                }
        }

        return maxOddFre - minEvenFre;
    }
}
