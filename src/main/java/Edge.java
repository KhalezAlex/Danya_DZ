import java.util.ArrayList;
import java.util.List;

public class Edge {
    private int number; //номер по списку
    private Edge src; //откуда
    private ArrayList<Edge> dest; //куда
    private int length; //длина
    private int amount; //есть ли ягоды
    private int hp; //hp

    public Edge(int number, Edge src, ArrayList<Edge> dest, int length, int amount, int hp) {
        this.number = number;
        this.src = src;
        this.dest = dest;
        this.length = length;
        this.amount = amount;
        this.hp = hp;
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

    public int getHp() {
        return hp;
    }

    public void setHp(int hp) {
        this.hp = hp;
    }

    public Edge down() {
        Edge tmp = this.dest.get(0);
        tmp.setHp(this.hp - this.length);
        return tmp;
    }

    public Edge up() {
        Edge tmp = this.src;
        tmp.setHp(this.hp - this.length);
        return tmp;
    }


    @Override
    public String toString() {
        return "Edge{" +
                "number=" + number +
                ", src=" + src(src) +
                ", dest=" + dest(dest) +
                ", length=" + length +
                ", amount=" + amount +
                ", hp=" + hp +
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
}
