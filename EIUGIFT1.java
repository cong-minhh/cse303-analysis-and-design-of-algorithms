import java.io.IOException;
import java.io.InputStream;
import java.util.Arrays;

public class EIUGIFT1 {

    static InputReader sc;

    public static void main(String[] args) throws Exception {
        sc = new InputReader();
        int n = sc.nextInt();
        int k = sc.nextInt();
        double[] arr = new double[n];
        double[] brr = new double[k];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextDouble();
        }
        for (int i = 0; i < k; i++) {
            brr[i] = sc.nextDouble();
        }

        Arrays.sort(arr);
        Arrays.sort(brr);

        int pt1 = n - 1;
        int pt2 = k - 1;
        long ans = 0;
        while (pt1 >= 0 && pt2 >= 0) {
            double ratio = brr[pt2] / arr[pt1];
            if (ratio > 3) {
                pt2--;
            } else if (ratio < 2) {
                pt1--;
            } else {
                pt1--;
                pt2--;
                ans++;
            }

        }
        System.out.println(ans);

    }

    static class InputReader {
        private int BUFFER_SIZE = 1 << 16;
        private byte[] buffer = new byte[BUFFER_SIZE];
        private int bufferPointer = 0,
                bytesRead = 0;
        private InputStream rd;

        public InputReader() {
            this.rd = System.in;
        }

        private int read() throws IOException {
            if (bufferPointer == bytesRead) {
                bufferPointer = 0;
                bytesRead = rd.read(buffer, bufferPointer, BUFFER_SIZE);
                if (bytesRead == -1) {
                    return -1;
                }
            }
            return buffer[bufferPointer++];
        }

        public int nextInt() throws IOException {
            int number = 0;
            int c = read();
            while (c <= ' ') {
                c = read();
            }
            boolean negative = (c == '-');
            if (negative) {
                c = read();
            }
            do {
                number = number * 10 + (c - '0');
                c = read();
            } while (c >= '0' && c <= '9');
            return negative ? -number : number;
        }

        public long nextLong() throws IOException {
            long number = 0L;
            int c = read();
            while (c <= ' ') {
                c = read();
            }
            boolean negative = (c == '-');
            if (negative) {
                c = read();
            }
            do {
                number = number * 10 + (c - '0');
                c = read();
            } while (c >= '0' && c <= '9');
            return negative ? -number : number;
        }

        public String next() throws IOException {
            int c = read();
            while (c <= ' ') {
                c = read();
            }
            StringBuilder t = new StringBuilder();
            do {
                t.append((char) c);
                c = read();
            } while (c > ' ');
            return t.toString();
        }

        public double nextDouble() throws IOException {
            return Double.parseDouble(next());
        }

        public char nextChar() throws IOException {
            int c = read();
            while (c <= ' ') {
                c = read();
            }
            return (char) c;
        }
    }
}
