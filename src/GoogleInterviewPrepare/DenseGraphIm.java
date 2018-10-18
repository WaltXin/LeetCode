package GoogleInterviewPrepare;

public class DenseGraphIm {
    //nodes count
    int n;
    //graph edge
    int m;
    //direction
    boolean directed;
    //graph
    int[][] adMatrix;

    public DenseGraphIm(int capacity, boolean directed) {
        this.n = capacity;
        this.m = 0;
        this.directed = directed;
        adMatrix = new int[n][n];
    }

    //connect v, w
    public void addEdge(int v, int w) {
        if (hasEdge(v, w))
            return;
        adMatrix[v][w] = 1;
        if (!directed)
            adMatrix[w][v] = 1;
        m++;
    }

    public boolean hasEdge(int v, int w) {
        return adMatrix[v][w] == 1;
    }
}
