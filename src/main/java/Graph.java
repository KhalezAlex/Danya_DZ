import java.util.HashMap;
import java.util.LinkedList;

public class Graph {
    public Edge edge;
    public LinkedList<Integer> listOfVisitedHP;


    public Graph(Edge edge, LinkedList<Integer> listOfVisitedHP) {
        this.edge = edge;
        this.listOfVisitedHP = listOfVisitedHP;
    }

    HashMap<Integer, Edge> getHP(Edge root) {
        int hp = 0;
        //пока есть дочерние ребра, спускаемся вниз, убавляя hp
        while (root.getDest().size() != 0) {
            hp -= root.getLength();
            root = (Edge) root.dive(hp).keySet().toArray()[0];
        }
        // спкускаемся вниз по последнему ребру
        hp -= root.getLength();
        HashMap<Integer, Edge> tmp = new HashMap<>();
        tmp.put(hp, root);
        //возвращаемся до первого разветвления
        getRestOfGraph(tmp);
        return tmp;
    }

    private Edge getRestOfGraph(HashMap<Integer, Edge> leaf) {
        int hp = (int) leaf.keySet().toArray()[0];
        Edge edge = leaf.get(hp);
        hp += edge.getAmount();
        while (edge.getDest().size() == 0) {
            hp -= edge.getLength();
            edge = edge.getSrc();
        }
        edge.getDest().remove(0);
        return null;
    }
}
