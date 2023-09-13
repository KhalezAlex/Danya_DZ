import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        Graph graph = new Graph();

        Edge edge = graph.listOfLeafs.get(0);
        System.out.println(edge);
        edge = graph.getRestOfGraph(edge);
        System.out.println(edge);
    }
}
