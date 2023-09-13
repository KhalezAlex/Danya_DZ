import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class Reader {
    public static Edge graph() throws IOException {
        BufferedReader br = new BufferedReader(new FileReader("test.txt"));
        ArrayList<String> list = new ArrayList<>();
        String str;
        br.readLine();
        while ((str = br.readLine()) != null) {
            list.add(str);
        }
        return getEdgeFromString(list, 0, null);
    }

    public static Edge getEdgeFromString(ArrayList<String> strArrList, int index, Edge src) {
        String[] string = strArrList.get(index).split(" ");
        int length = Integer.parseInt(string[0]);
        int number = index + 1;
        int amount = 0;
        Edge currentEdge = new Edge(number, src, new ArrayList<>(), length, amount);
        if (Integer.parseInt(string[1]) == 0) {
            currentEdge.setAmount(Integer.parseInt(string[2]));
        }
        else {
            for (int i = 2; i < string.length; i++) {
                currentEdge.getDest().add(getEdgeFromString(strArrList,
                        Integer.parseInt(string[i]) - 1, currentEdge));
            }
        }
        return currentEdge;
    }
}
