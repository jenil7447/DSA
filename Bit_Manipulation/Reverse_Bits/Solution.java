class Solution {
    public int hammingWeight(int n) {
        int count = 0;
        while(n > 0){
            count += (n&1);
            n >>= 1;
        }
        return count;
    }
}
// class Solution{
//     public int hammingWeight(int n){
//         int count = 0;
//         while(n > 0){
//             n = n & (n-1);
//             count++;
//         }
//         return count;
//     }
// }
