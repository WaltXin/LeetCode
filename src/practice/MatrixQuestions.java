package practice;

import java.util.*;

public class MatrixQuestions {
    class Point {
        int x;
        int y;
        int distance;

        Point(int x, int y, int distance) {
            this.x = x;
            this.y = y;
            this.distance = distance;
        }
    }

    public void robotPath(int[][] arr) {
        //in arr there are some positions that robot cannot visit
        //value -1 represent forbidden area
        int[][] visited = new int[arr.length][arr.length];
        Point[][] from = new Point[arr.length][arr.length];
        from[0][0] = null;
        int jLength = arr[arr.length - 1].length;
        Point finalPoint = null;
        PriorityQueue<Point> pq = new PriorityQueue<>(Comparator.comparing(k -> k.distance));
        //start at position (0,0)
        pq.add(new Point(0,0,0));
        while (!pq.isEmpty()) {
            Point e = pq.poll();
            if (visited[e.x][e.y] == 1) {
                continue;
            }
            visited[e.x][e.y] = 1;
            //found target
            if (e.x == arr.length - 1 && e.y == jLength - 1) {
                finalPoint = e;
                break;
            }
            //get all neighbours
            int i = e.x;
            int j = e.y;
            if (i < arr.length - 1 && arr[i + 1][j] != -1) {
                if (visited[i + 1][j] != 1) {
                    from[i + 1][j] = e;
                    pq.add(new Point(i + 1, j, e.distance + 1));
                }
            }
            if (j < arr[i].length - 1 && arr[i][j + 1] != -1) {
                if (visited[i][j + 1] != 1) {
                    from[i][j + 1] = e;
                    pq.add(new Point(i, j + 1, e.distance + 1));
                }
            }
            if (i > 0 && arr[i - 1][j] != -1) {
                if (visited[i - 1][j] != 1) {
                    from[i - 1][j] = e;
                    pq.add(new Point(i - 1, j, e.distance + 1));
                }
            }
            if (j > 0 && arr[i][j - 1] != -1) {
                if (visited[i][j - 1] != 1) {
                    from[i][j - 1] = e;
                    pq.add(new Point(i, j - 1, e.distance + 1));
                }
            }
        }

        ArrayList<Point> res = new ArrayList<>();
        Point p = finalPoint;
        while (p != null) {
            res.add(p);
            p = from[p.x][p.y];
        }
        Collections.reverse(res);
        for (Point point : res) {
            System.out.println(point.x + " " + point.y);
        }

    }

    public static void main(String[] args) {
        int[][] arr = {{1,-1,1,1},
                      {1,-1,-1,1},
                      {1,1,1,1},
                      {1,-1,-1,1}};
        new MatrixQuestions().robotPath(arr);

        int[] sin = {1,2,3,4,5,6};
        for (int i = 0; i < sin.length; i++) {
            System.out.println("tttt " + sin[i]);
            int m = i;
            m++;
        }

    }

    public void setZeroes(int[][] matrix) {
        int row = 0, line = 0;
        if (matrix[0][0] == 0) {
            row = 1;
            line = 1;
        }
        //find any zero in matrix set top row and top column to zero
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if (matrix[i][j] == 0) {
                    matrix[0][j] = 0;
                    matrix[i][0] = 0;
                    if (i == 0) {
                        row = 1;
                    }
                    if (j == 0) {
                        line = 1;
                    }
                }
            }
        }

        //for any zero we found in matrix's first row and first column we set whole row and column to zero
        for (int i = 1; i < matrix.length; i++) {
            if (matrix[i][0] == 0) {
                for (int j = 0; j < matrix[i].length; j++) {
                    matrix[i][j] = 0;
                }
            }
        }

        for (int j = 1; j < matrix[0].length; j++) {
            if (matrix[0][j] == 0) {
                for (int i = 0; i < matrix.length; i++) {
                    matrix[i][j] = 0;
                }
            }
        }

        if (matrix[0][0] == 0) {
            if (line == 1) {
                for (int i = 0; i < matrix.length; i++) {
                    matrix[i][0] = 0;
                }
            }
            if (row == 1) {
                for (int j = 0; j < matrix[0].length; j++) {
                    matrix[0][j] = 0;
                }
            }
        }
    }
}
