public class FFT {
    //복소수 배열 x(실수부와 허수부로 나누어진)를 입력받아 FFT를 계산하는 fft 메소드.
    public static Complex[] fft(Complex[] x) {
        int N = x.length; //배열의 길이를 변수에 할당한다.


        // N==1인경우? DC성분인 주파수 성분이 하나만 있음을 의미한다. 이 값은 복소수성분이 없음.
        if (N == 1) {
            return new Complex[] { x[0] };
        }

        // 길이가 원래 배열의 N/2인 두 even배열과 odd 배열로 분리한 후, 재귀적으로 fft호출(분할정복)
        // 입력 배열의 짝수 인덱스 요소를 짝수배열에 할당하고, 입력배열의 홀수인덱스 요소를 홀수에 핡당한 다음
        //짝수 및 홀수 배열에서 재귀적으로 fft를 호출하여 DFT를 계산하고 결과를 각가 a 와 b에 할당
        Complex[] even = new Complex[N/2];
        Complex[] odd = new Complex[N/2];
        for (int r = 0; r < N/2; r++) {
            even[r] = x[2 * r];
            odd[r] = x[2 * r + 1];

        }
        Complex[] a = fft(even);
        Complex[] b = fft(odd);

        // a,b을 이용하여, x의 DFT를 계산한다.(결합)
        //even배열의 DFT인 a배열과 odd배열의 DFT인 b배열을 이용하여 입력배열 x의 DFT인 y를 계산한다.
        Complex[] y = new Complex[N];
        for (int k = 0; k < N/2; k++) {
            double angle = -2 * k * Math.PI / N;

            Complex Z = new Complex(Math.cos(angle), Math.sin(angle));
            //Z는 복소수 계수이다. e^(-2pik/N)


            y[k] = a[k].plus(Z.times(b[k]));
            //y[k]는 a[k]와 Z*b[k]의 합으로 계산된다. 이때 a[k]는 even 배열의 DFT값 , b[k]는 odd배열의 DFT값이다.

            y[k + N/2] = a[k].minus(Z.times(b[k]));

        }


        return y;
    }
    public static double Bandwidth(Complex[] spectrum, double sampleRate) {
        int N = spectrum.length;
        double[] magnitudes = new double[N];

        // 각 주파수 구성 요소의 크기를 계산한다.
        for (int i = 0; i < N; i++) {
            magnitudes[i] = spectrum[i].abs();
        }

        // 가장 큰 값을 갖는 인덱스를 찾는다.
        int max = 0;
        for (int i = 1; i < N; i++) {
            if (magnitudes[i] > magnitudes[max]) {
                max = i;
            }
        }

        // 최대 값을 갖는 인덱스에 해당하는 주파수를 계산한다.
        double maxFrequency = (double) max / N * sampleRate;

        // 대역폭 : 주파수분해능 / 2
        // 주파수분해능 : 샘플주파수 / N
        double frequencyResolution = sampleRate / N;
        double bandwidth = frequencyResolution / 2;

        return bandwidth;
    }

    public static void main(String[] args) {
        Complex[] x = new Complex[] {
                new Complex(1, 0),
                new Complex(1, 0),
                new Complex(0, 0),
                new Complex(0, 0)

        };

        Complex[] spectrum = fft(x);
        double sampleRate = 5000; // sample rate : 5000일때
        double bandwidth = Bandwidth(spectrum, sampleRate);
        System.out.println("Bandwidth: " + bandwidth); //주파수 대역폭 구하기
    }
}




class Complex {
    private double real;
    private double imag;

    public Complex(double real, double imag) {
        this.real = real;
        this.imag = imag;
    }

    public Complex plus(Complex other) {
        return new Complex(this.real + other.real, this.imag + other.imag);
    }

    public Complex minus(Complex other) {
        return new Complex(this.real - other.real, this.imag - other.imag);
    }

    public Complex times(Complex other) {
        double real = this.real * other.real - this.imag * other.imag;
        double imag = this.real * other.imag + this.imag * other.real;
        return new Complex(real, imag);
    }

    public double abs() {
        return Math.sqrt(real * real + imag * imag);
    }

    public double arg() {
        return Math.atan2(imag, real);
    }

    public double getReal() {
        return real;
    }

    public double getImag() {
        return imag;
    }

    public String toString() {
        return "(" + real + ", " + imag + ")";
    }
}

