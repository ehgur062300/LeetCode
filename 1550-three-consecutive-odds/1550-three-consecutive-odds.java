class Solution {
    public boolean threeConsecutiveOdds(int[] arr) {
        int len = arr.length;
        for (int i = 2; i<len; i++) {
            if (arr[i-2] % 2 == 1 && arr[i-1] % 2 == 1 && arr[i] % 2 == 1) {
                return true;
            }
        }   
        return false;
    }
}