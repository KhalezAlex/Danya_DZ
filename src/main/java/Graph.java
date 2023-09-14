import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class Graph {
    public Edge edge;
    public ArrayList<Edge> listOfLeafs;


    public Graph() throws IOException {
        this.listOfLeafs = new ArrayList<>();
        this.edge = graph();
    }

    private Edge graph() throws IOException {
        BufferedReader br = new BufferedReader(new FileReader("test.txt"));
        ArrayList<String> list = new ArrayList<>();
        String str;
        br.readLine();
        while ((str = br.readLine()) != null) {
            list.add(str);
        }
        return getEdgeFromString(list, 0, null);
    }

    private Edge getEdgeFromString(ArrayList<String> strArrList, int index, Edge src) {
        String[] string = strArrList.get(index).split(" ");
        int number = index + 1;
        int length = Integer.parseInt(string[0]);
        int amount = 0;
        int hp = src == null ? -length : src.getHp() - length;
        Edge currentEdge = new Edge(number, src, new ArrayList<>(), length, amount, hp);
        if (Integer.parseInt(string[1]) == 0) {
            currentEdge.setAmount(Integer.parseInt(string[2]));
            listOfLeafs.add(currentEdge);
        }
        else {
            for (int i = 2; i < string.length; i++) {
                currentEdge.getDest().add(getEdgeFromString(strArrList,
                        Integer.parseInt(string[i]) - 1, currentEdge));
            }
        }
        return currentEdge;
    }

    public Edge getRestOfGraph(Edge leaf) {
        leaf.eat();
        //пока не найдем разветвление, возвращаемся назад и удаляем грань, попутно теряя hp
        while (leaf.getDest().size() == 0) {
            Edge e = leaf;
            leaf = leaf.up();
            if (leaf.getDest().size() != 0) {
                leaf.getDest().remove(e);
            }
            else break;
        }
        return leaf;
    }

    public void getNextLeaf() {
        while (this.edge.getDest().size() != 0) {
            this.edge = this.edge.down();
        }
    }

    public int eatAll(Edge leaf) {
        this.edge = leaf;
        while (this.edge.getSrc() != null) {
            this.edge = getRestOfGraph(leaf);
            if (this.edge.getHp() < 0)
                return -1;
            getNextLeaf();
            leaf = this.edge;
            if (this.edge.getHp() < 0)
                return -1;
        }
        return this.edge.getHp();
    }
}
