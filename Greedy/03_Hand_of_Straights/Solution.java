class Solution {
    public boolean isNStraightHand(int[] hand, int groupSize) {
        if (hand.length % groupSize != 0) return false; // T
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int card : hand) {
            map.put(card, map.getOrDefault(card, 0) + 1);
        }
        Arrays.sort(hand);
        for (int card : hand) {
            if (!map.containsKey(card)) {
                continue;
            }
            for (int i = 0; i < groupSize; i++) {
                int currentCard = card + i;
                if (!map.containsKey(currentCard)) return false;
                map.put(currentCard, map.get(currentCard) - 1);
                if (map.get(currentCard) == 0) {
                    map.remove(currentCard);
                }
            }
        }
        return true; 
    }
}
class Solution {
    public boolean isNStraightHand(int[] hand, int groupSize) {
        TreeMap<Integer,Integer> map = new TreeMap<>();
        for(int i = 0; i < hand.length; i++){
            map.put(hand[i],map.getOrDefault(hand[i],0)+1);
        }
        while(map.size() > 0){
             int firstCard = map.firstKey();
            for(int i = 0; i < groupSize; i++){
               int currentCard = firstCard + i;

               if(!map.containsKey(currentCard)) return false;

               map.put(currentCard,map.get(currentCard)-1);
               if(map.get(currentCard) == 0){
                map.remove(currentCard);
               }
            }
        }
        return true;
    }
}
