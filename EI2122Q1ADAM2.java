import java.io.*;
import java.util.*;

public class EI2122Q1ADAM2 {

    static InputReader sc;

    public static void main(String[] args) throws Exception {
        sc = new InputReader();
        int n = sc.nextInt();
        int m = sc.nextInt();
        int x = sc.nextInt();
        long[] arr = new long[n];
        long[] brr = new long[m];

        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextLong();
        }
        for (int i = 0; i < m; i++) {
            brr[i] = sc.nextLong();
        }
        Arrays.sort(arr);
        Arrays.sort(brr);
        long lowerBound = 0;
        long upperBound = Math.max(Math.abs(brr[m - 1] - arr[0]), Math.abs(arr[n - 1] - brr[0]));
        long res = Integer.MAX_VALUE;
        while (lowerBound <= upperBound) {
            long mid = (lowerBound + upperBound) >> 1;
            int i = 0, j = 0;
            long numPair = 0;
            while (i < n && j < m) {
                if (Math.abs(arr[i] - brr[j]) <= mid) {
                    numPair++;
                    i++;
                    j++;
                } else if (arr[i] < brr[j]) {
                    i++;
                } else {
                    j++;
                }
            }
            if (numPair >= x) {
                upperBound = mid - 1;
                res = Math.min(res, mid );
            } else {
                lowerBound = mid + 1;
            }
        }
        System.out.println(res);

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
