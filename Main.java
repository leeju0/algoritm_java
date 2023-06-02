class Main {
    int genetic(int[] x,int n,Evaluator e, Selector s, CrossOver c, Mutator m){
        for(int i=0;i<n;i++){
            int[] f = e.evaluate(x);
            int[] wx = s.select(x,f);
            int[] ngx = c.crossover(wx);
            x = m.mutate(ngx);
        }
    }
    public static void main(String[] args) {
        //문제생성
        //적합도계산
        //선택연산
        //교차연산
        //돌연변이연산
        Main m = new Main();
        int[] is = {1,29,3,10};

        m.genetic(is,new XEvaluator(),)
    }
}

class XEvaluator implements Evaluator{
    public int[] evaluate(int[] x){
        int[] f = new int[x.length];
        for(int i=0;i<x.length;i++){
            f[i] = -x[i]*x[i] + 38*x[i] +80;
        }
        retunr f;
    }
}
class XMutator implements Mutator{
    public int[]
}
class RoulletSelector implements Selector{
    public 
}
interface Evaluator {
    int[] evaluate(int[] x);
}

interface Selector{
    int[] select(int[] x, int[] f);
}

interface CrossOver{
    int[] crossover(int[] x);

}
interface Mutator{
    int[] mutate(int[] x);
}
