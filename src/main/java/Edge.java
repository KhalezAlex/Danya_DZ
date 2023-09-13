import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Edge implements Cloneable {
    private int number; //номер по списку
    private Edge src; //откуда
    private ArrayList<Edge> dest; //куда
    private int length; //длина
    private int amount; //есть ли ягоды

    public Edge(int number, Edge src, ArrayList<Edge> dest, int length, int amount) {
        this.number = number;
        this.src = src;
        this.dest = dest;
        this.length = length;
        this.amount = amount;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public Edge getSrc() {
        return src;
    }

    public void setSrc(Edge src) {
        this.src = src;
    }

    public List<Edge> getDest() {
        return dest;
    }

    public void setDest(ArrayList<Edge> dest) {
        this.dest = dest;
    }

    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    @Override
    public String toString() {
        return "Edge{" +
                "number=" + number +
                ", src=" + src(src) +
                ", dest=" + dest(dest) +
                ", length=" + length +
                ", amount=" + amount +
                '}';
    }

    private String dest(ArrayList<Edge> children) {
        StringBuilder sb = new StringBuilder();
        for (Edge child: children) {
            sb.append(child.getNumber()).append(", ");
        }
        return sb.toString();
    }

    private String src(Edge src) {
        return src == null ? "0 " : src.getNumber() + " ";
    }

    public HashMap<Edge, Integer> dive(int hp) {
        HashMap<Edge, Integer> tmp = new HashMap<>();
        tmp.put(this.dest.get(0), hp - this.length);
        return tmp;
    }
}
