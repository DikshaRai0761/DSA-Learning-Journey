class Solution {
    public void solve(int open,int close,String op, List<String> ans){
    if(open==0 && close==0){
        ans.add(op);
        return;
    }
    if(open!=0){
        solve(open-1,close,op+"(",ans);
    
    }
    if(close>open){
        solve(open,close-1,op+")",ans);
    }

    }
    public List<String> generateParenthesis(int n) {
         List<String> ans=new ArrayList<>();
        solve(n,n,"",ans);
      return ans;  
    }
}