class Solution {
    public int[] findMissingAndRepeatedValues(int[][] grid) {
        int n = grid.length;
        int r = 0 ;
        int m = 0;
        for (int num = 1; num <= n * n; num++) {
    int count = 0;

    for (int i = 0; i < n; i++) {
        for (int j = 0; j < n; j++) {
            if (grid[i][j] == num) {
                count++;
            }
        }
    }

    if (count == 2) {
        r = num;
    }

    if (count == 0) {
        m = num;
    }
}
return new int[]{r, m};
    }
}