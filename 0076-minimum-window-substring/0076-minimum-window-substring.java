class Solution {
    public String minWindow(String s, String t) {
      int have[]=new int[128];
      int needed[]=new int[128];
      for(int i=0; i<t.length();i++){
        char ch=t.charAt(i);
        needed[ch]++;
      }  
      int low=0;
      int high=0;
      int res=Integer.MAX_VALUE;
      int start=0;
      while(high<s.length()){
        have[s.charAt(high)]++;
        while(sahi(have, needed)){
            int len=high-low+1;
            if(res>len){
                res=len;
                start=low;
            }
            have[s.charAt(low)]--;
            low++;
        }
        high++;
      }
      if(res==Integer.MAX_VALUE){
        return "";
      }
      return s.substring(start, start+res);
    }
     public boolean sahi(int[] have, int[] needed) {
        for (int i = 0; i < 128; i++) {
            if (have[i] < needed[i]) {
                return false;
            }
        }

        return true;
}
}