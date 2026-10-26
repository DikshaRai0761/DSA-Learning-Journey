class Solution {
    public int characterReplacement(String s, int k) {
       int n=s.length();
       int low=0;
       int res=0;
       int[] f=new int[26];
       for(int high=0; high<n; high++){
        f[s.charAt(high)-'A']++;
        int len=high-low+1;
        int maxInt=find(f);
        int diff=len-maxInt;
        while(diff>k){
            f[s.charAt(low)-'A']--;
            low++;
             len=high-low+1;
             maxInt=find(f);
             diff=len-maxInt;
        }
        len=high-low+1;
        res=Math.max(res, len);
       } 
       return res;
    }
    public int find(int[] f){
        int max=0;
        for(int i=0; i<26; i++){
            max=Math.max(max, f[i]);
        }
        return max;
    }
}