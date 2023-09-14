import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        Graph graph = new Graph();

        Edge leaf = graph.listOfLeafs.get(4);
        int hp = -leaf.getHp();
        leaf.setHp(0);
        System.out.println(graph.eatAll(leaf));
    }
}
