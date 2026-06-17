class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> ans = new ArrayList<>();
        fnc(ans,n,0,0,"");
        return ans;
    }
    public void fnc(List<String>ans, int n, int open, int close, String curr){
        //base condition
        if(curr.length() == n*2){
            ans.add(curr);
            return;
        }
        if(open < n) fnc(ans,n,open+1,close,curr +'(');
        if(close < open) fnc(ans,n,open,close+1,curr +')');
    }
}
