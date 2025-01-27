class Solution {
    public boolean mergeTriplets(int[][] triplets, int[] target) {
        int x = target[0], y = target[1], z = target[2];
        boolean foundX = false, foundY = false, foundZ = false;
        for (int[] triplet : triplets) {
            int a = triplet[0], b = triplet[1], c = triplet[2];
            if (a <= x && b <= y && c <= z) {
                if (a == x) foundX = true; 
                if (b == y) foundY = true; 
                if (c == z) foundZ = true; 
            }
        }
        return foundX && foundY && foundZ;
    }
}
