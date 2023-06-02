public class FFTcount {
    public static int fft(Complex[] x) {
        int N = x.length;
        int cnt = 0;
        if (N == 1) {
            return 0;
        }

        Complex[] even = new Complex[N/2];
        Complex[] odd = new Complex[N/2];
        for (int r = 0; r < N/2; r++) {
            even[r] = x[2*r];
            odd[r] = x[2*r + 1];
            cnt += 2;
        }
//        Complex[] a = fft(even);
//        Complex[] b = fft(odd);


        Complex[] y = new Complex[N];
        for (int k = 0; k < N/2; k++) {
            double angle = -2 * k * Math.PI / N;
            Complex Z = new Complex(Math.cos(angle), Math.sin(angle));
            y[k] = even[k].plus(Z.times(odd[k]));
            y[k + N/2] = even[k].minus(Z.times(odd[k]));
            cnt += 2;
        }
        return cnt;
    }

    public static void main(String[] args) {
        Complex[] x = new Complex[] {
                new Complex(1, 0),
                new Complex(1, 0),
                new Complex(0, 0),
                new Complex(0, 0)
        };
        int cnt = fft(x);
        System.out.println("총 계산 횟수 " + cnt);
    }

}
