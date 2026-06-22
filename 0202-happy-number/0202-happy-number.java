class Solution {
    public boolean isHappy(int n) {
        HashSet<Integer> set=new HashSet<>();
        while(n!=1 && !set.contains(n)){
            set.add(n);
            n=next(n);
        }
        return n==1;
    }
    public int next(int num){
        int sum=0;
        int rem=0;
        while(num>0){
            rem=num%10;
            num/=10;
            sum+=rem*rem;
        }
        return sum;
    }
}