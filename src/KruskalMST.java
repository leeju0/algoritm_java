import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;

public class KruskalMST {


    public static void main(String[] args) {
//        Edge e1 = new Edge(1,'B','C');
//        Edge e2 = new Edge(1,'C','F');
//        Edge e3 = new Edge(2,'B','F');
//        Edge e4 = new Edge(2,'A','D');
//        Edge e5 = new Edge(3,'D','E');
//        Edge e6 = new Edge(4,'A','E');
//        Edge e7 = new Edge(4,'B','D');
//        Edge e8 = new Edge(7,'D','F');
//        Edge e9 = new Edge(8,'A','B');
//        Edge e10 = new Edge(9,'E','F');

        int[] weights = {1, 1, 2, 2, 3, 4, 4, 7, 8, 9};
        char[] v1s = {'B', 'C', 'B', 'A', 'D', 'A', 'B', 'D', 'A', 'E'};
        char[] v2s = {'C', 'F', 'F', 'D', 'E', 'E', 'D', 'F', 'B', 'F'};

        HashSet<Character> vertics = new HashSet<Character>();
        for(int i=0;i<v1s.length;i++){
            vertics.add(v1s[i]);
            vertics.add(v2s[i]);
        }
        System.out.println(vertics.size());
        System.out.println(vertics);

        ArrayList<Edge> edges = new ArrayList<>();
        for (int i = 0; i < weights.length; i++) {
            edges.add(new Edge(weights[i], v1s[i], v2s[i]));
        }
//집합은 중복이 안된다.!!
        //comparator 말고도 set을 사용할수도있음,,ㅅㅂ

        //수업준비를 안해옴,, 수업시간에 즉석에서 코드를 짬
        //잘하시는건 알겠으나 무슨내용인지 정말 이해하기어려웠음
        //수업 자체에 질이 좋은건아님,, 알아서 해보라 이런식
        //그럴거면 수업을 안듣고 혼자하지 수강하는 이유가뭔지는 잘 모르겠음
        HashSet<Edge> T = new HashSet<Edge>();
        while(T.size() <vertics.size() -1){
            Edge tmp = edges.remove(0);
            if(isNotCyclic(T, tmp)){
                  T.add(tmp);
                  }
         }
        System.out.println(T);
        Comparator<Edge> comparator = new Comparator<Edge>() {
            @Override
            public int compare(Edge o1, Edge o2) {
                return o1.weight - o2.weight;
            }
        };//tlqkf
        Collections.sort(edges,comparator);
        System.out.println(edges);
    }

    private static boolean isNotCyclic(HashSet<Edge> t, Edge tmp) {
        return !(t.contains(tmp.v1)&&t.contains(tmp.v2));

    }
}
class Edge{
    int weight;
    char v1, v2;

    Edge(int weight, char v1, char v2) {
        this.weight = weight;
        this.v1 =v1;
        this.v2 =v2;
    }
    @Override
    public String toString(){
        return String.format("%c - (%02d) - %c", v1, weight, v2);
    }

}
