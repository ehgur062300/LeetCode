class Solution {
    public boolean threeConsecutiveOdds(int[] arr) {
        boolean[] checker = new boolean[3];
        for (int i = 0; i<arr.length; i++) {
            if (arr[i] % 2 == 1) {
                checker[i%3] = true;
            } else {
                checker[i%3] = false;
            }
            
            if (checker[0] && checker[1] && checker[2]) {
                return true;
            }
        }
        return false;
    }
}