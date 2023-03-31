
import java.util.Scanner;


public class CoinChange {

    //int 값을 받아서 ,, int형을 리턴한다.
    public int changecoin(int change) {
        int[] coins = {500, 100, 50, 10, 1};
        int[] n = new int[coins.length];

        for(int i = 0;i<coins.length;i++) {
            while (change >= coins[i]) {
                change -= coins[i];
                n[i] += 1;
            }
        }
        for(int i = 0;i<coins.length;i++) {
            System.out.printf("%d원짜리: %d\n", coins[i], n[i]);
        }

        int nSum =0;
        for(int i=0;i<coins.length;i++){
            nSum += n[i];
        }
        return nSum;

    }
    public static void main(String[] args){
        System.out.printf("거스름돈 입력: ");
        Scanner scanner = new Scanner(System.in);
        //사용자로부터 입력을 받는다. System.in 키보드(입력 버퍼)로 받겠다.
        int change = scanner.nextInt(); //int형 사이즈 만큼 버퍼에서 가져와 w변수에 저장함

        CoinChange c = new CoinChange();
        System.out.println("총 동전의 수는 "+c.changecoin(change)+"개 입니다.");
        }






}
