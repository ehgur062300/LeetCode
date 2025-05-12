class Solution {
    public boolean threeConsecutiveOdds(int[] arr) {
        int cnt = 0;
        for (int n : arr) {
            if (cnt == 3) {
                return true;
            }

            if (n % 2 == 1){
                cnt++;
                continue;
            } 
            
            if (n % 2 == 0 && cnt > 0) {
                cnt = 0;
            } 
            
        }
        if(cnt == 3) {
            return true;
        }
        return false;
    }
}