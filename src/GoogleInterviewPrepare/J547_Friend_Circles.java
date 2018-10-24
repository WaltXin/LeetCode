package GoogleInterviewPrepare;

public class J547_Friend_Circles {
    public int findCircleNum(int[][] M) {
        int[] uf = new int[M.length];
        for (int i = 0; i < M.length; i++) {
            uf[i] = i;
        }
        for (int i = 0; i < M.length; i++) {
            for (int j = 0; j < i; j++) {
                if (M[i][j] == 1) {
                    uf[root(j,uf)] = root(i,uf);
                }
            }
        }
        int count = 0;
        for (int i = 0; i < uf.length; i++) {
            if (uf[i] == i) {
                count++;
            }
        }
        return count;
    }

    public int root(int i, int[] uf) {
        while (uf[i] != i) {
            i = uf[i];
        }
        return i;
    }
}