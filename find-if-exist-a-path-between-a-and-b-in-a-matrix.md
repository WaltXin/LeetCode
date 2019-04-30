# Find If exist a path between A and B in a matrix

```text
[0, 0, 1, 1]    Asssume A[0,0] and B[3, 0] find If there is a path
[1, 0, 0, 0]
[1, 1, 0, 0]
[0, 0, 0, 1]
[1, 1, 1, 1]

int[][] matrix = {{0, 0, 1, 1}, {1, 0, 0, 0}, {1, 1, 0, 0}, {0, 0, 0, 1}, {1, 1 ,1, 1}};
```

```java
public boolean findPath(int[][] matrix, int[] A, int[] B) {
    //A[0,0]  B[3, 0]
    //start from A
    boolean[][] visited = new boolean[matrix.length][matrix[0].length];
    return dfs(matrix, A[0], A[1], B, visited);
}

private boolean dfs(int[][] matrix, int row, int column, int[] target, boolean[][] visited) {
    //check invalid
    if (row < 0 || row >= matrix.length || column < 0 || column >= matrix[0].length || matrix[row][column] == 1 || visited[row][column]) {
        return false;
    }
    visited[row][column] = true;
    if (row == target[0] && column == target[1]) {
        return true;
    }
    if (dfs(matrix, row + 1, column, target, visited) ||
        dfs(matrix, row - 1, column, target, visited) ||
        dfs(matrix, row, column + 1, target, visited) ||
        dfs(matrix, row, column - 1, target, visited))
    return true;
    else
        return false;
}
```



