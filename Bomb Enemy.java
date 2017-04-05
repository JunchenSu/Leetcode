public class Solution {
    public int maxKilledEnemies(char[][] grid) {
        if (grid == null || grid.length == 0 || grid[0].length == 0) {
            return 0;
        }
        int max = 0;
        int rowCount = 0;
        int[] colCount = new int[grid[0].length];//列号
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 'W') continue;
                if (j == 0 || grid[i][j-1] == 'W') {
                    rowCount = findRowCount(grid,i,j); 
                }
                if (i == 0 || grid[i-1][j] == 'W') {
                    colCount[j] = findColCount(grid,i,j);
                }
                if (grid[i][j] == '0') {
                    max = Math.max(rowCount + colCount[j], max);
                }
            }
        }
        return max;
    }
    
    private int findRowCount(char[][] grid, int i, int j) {
        int count = 0;
        while (j < grid[0].length && grid[i][j] != 'W') {
            if (grid[i][j] == 'E') count++;
            j++;
        }
        return count;
    }
    
    private int findColCount(char[][] grid, int i, int j) {
        int count = 0;
        while (i < grid.length && grid[i][j] != 'W') {
            if (grid[i][j] == 'E') count++;
            i++;
        }
        return count;
    }
}
/*
这种解法比较省空间，写法也比较简洁，需要一个rowCnt变量，用来记录上一墙到下一个墙之前的敌人个数。
还需要一个数组colCnt，其中colCnt[j]表示第j列上一墙到下一个墙之前的敌人个数。
算法思路是遍历整个数组grid，对于一个位置grid[i][j]，对于水平方向，如果当前位置是开头一个或者前面一个是墙壁，
我们开始从当前位置往后遍历，遍历到末尾或者墙的位置停止，计算敌人个数。
对于竖直方向也是同样，如果当前位置是开头一个或者上面一个是墙壁，我们开始从当前位置向下遍历，遍历到末尾或者墙的位置停止，
计算敌人个数。有了水平方向和竖直方向敌人的个数，那么如果当前位置是0，表示可以放炸弹，我们更新结果res即可
*/
