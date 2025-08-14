package LeetCode_Hard;

class Solution {
    private int count = 0;

    public int countArrangement(int n) {
        int[] arr = new int[n];
        for(int i = 1; i <= n; i++) arr[i - 1] = i;

        solve(arr, 0);
        return count;
    }

    private void solve(int[] arr, int idx) {
        if(idx == arr.length) {
            count++;
            return;
        }

        for(int i = idx; i < arr.length; i++) {
            if(arr[i] % (idx + 1) == 0 || (idx + 1) % arr[i] == 0) {
                swap(arr, idx, i);
                solve(arr, idx + 1);
                swap(arr, i, idx);
            }
        }
    }
    
    private void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
