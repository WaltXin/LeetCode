package GraphPac;

public class Edge<Weight> {
    int a,b;
    Weight weight;

    public Edge(int a, int b, Weight weight) {
        this.a = a;
        this.b = b;
        this.weight = weight;
    }

    public Weight getWeight() {
        return weight;
    }

    public int getOther(int x) {
        return x == a ? b : a;
    }
}
