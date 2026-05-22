class Solution {
    private int count = 0;
    
    public boolean isPrime(int num) {
        for(int i = 2; i < num; i++) {
            if(num % i == 0) return false;
        }
        return true;
    }
    
    public int solution(int[] nums) {
        int len = nums.length;
        for(int i = 0; i < len; i++) {
            for(int j = i + 1; j < len; j++) {
                for(int k = j + 1; k < len; k++) {
                    int curr = nums[i] + nums[j] + nums[k];
                    
                    if(isPrime(curr)) {
                        count++;
                    }
                }
            }
        }
        
        return count;
    }
}