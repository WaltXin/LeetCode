package GraphPac;

public class TestClass {
    public static void main(String[] args) {
        SparseGraph g = new SparseGraph(9, false);
        g.addEdge(0,1);
        g.addEdge(0,2);
        g.addEdge(0,5);
        g.addEdge(0,6);
        g.addEdge(3,5);
        g.addEdge(3,4);
        g.addEdge(4,5);
        g.addEdge(4,6);
        g.addEdge(7,8);

        Component c = new Component(g);
        System.out.println("Component number: " + c.count());

        GraphDepthFirstSearch gdfs = new GraphDepthFirstSearch(g);
        System.out.println("Graph depth first search sequence: " + gdfs.getDFSSeq());

        GraphDepthFirstSearchPath gdfsp = new GraphDepthFirstSearchPath(g,0);
        System.out.print("Graph depth first search path: ");
        gdfsp.showPath(6);

        GraphBreadthFirstSearch gbfs = new GraphBreadthFirstSearch(g);
        System.out.println("Graph breadth first search sequence: " + gbfs.getBFSSeq());

        GraphBreadthFirstSearchPath gbfsp = new GraphBreadthFirstSearchPath(g,0);
        System.out.print("Graph breadth first search path: ");
        gbfsp.showPath(3);

    }
}
