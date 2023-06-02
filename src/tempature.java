import java.util.*;
//모의 담금질 알고리즘
public class tempature {
    //초기온도설정
    //초기해선택
    // costfunction 계산<- f(초기해)
    //while(특정조건 만족할때까지 -> 수행)
    //for(n번 수행)
    //이웃해 <- perturbation(섭동) -> 비트열 표현
    //costfunction 계산 <-f(이웃해)
    //d=f(이웃해) -f(후보해)
    //f(이웃해) 더 좋은 경우 ( 선택: 후보해 <- 이웃해)
    //f(이웃해) 안좋은 경우
    //  그럼에도 불구하고 선택(후보해 <- 이웃해)
    //  그래서 선택 안함( 후보해 <- 후보해)
    //초기온도 감소
    public static int fit(int x){
        return -x*x + 38*x + 80;
    }

    public static int annealing(int n, float a, float t0){
        Random r = new Random();
        float t = t0;
        int x = r.nextInt(32);//[0, 31] x=후보해 r.nextInt(32)= 초기해
        int prev = fit(x);

        for (int i = 0; i < 100; i++) { //while
            for (int j = 0; j < n; j++) {
                //섭동
                int tmp = perturb(x);
                int curr = fit(tmp);
                int d = curr - prev;

                float q = r.nextFloat();
                if(q <= Math.exp((float)+d/t)){
                    x = tmp;
                    prev = curr;
                    }
                }
            }

            t *= a;

        return x;
    }

    private static int perturb(int x) {
        String str = String.format("%5s",Integer.toBinaryString(x)).replaceAll(" ","0");

        Random r = new Random();
        int idx = r.nextInt(str.length());

        StringBuilder sb = new StringBuilder(str);
        char[] tmp = str.toCharArray();
        tmp[idx] = (tmp[idx] == '0')? '1' :'0';
        String y = new String(tmp);

        return Integer.parseInt(y,2);
    }

    public static void main(String[] args) {
         int x = annealing(1000, 0.9f, 100);
         System.out.println(x); //expected: 19
         System.out.println(fit(x)); //expected: 441

    }
}
