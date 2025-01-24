import java.io.*;
import java.util.*;

public class EIUGIFTS {
    static InputReader sc;

    public static void main(String[] args) throws Exception {
        sc = new InputReader();
        int n = sc.nextInt();
        long money = sc.nextInt();
        long[] arr = new long[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextLong();
        }

        Arrays.sort(arr);
        int pt1 = 0;
        int pt2 = n - 1;
        long sum = -1;
        long min = Long.MAX_VALUE;
        while (pt1 < pt2) {
            long tmp = arr[pt1] + arr[pt2];
            long tmp2 = Math.abs(arr[pt1] - arr[pt2]);
            if (tmp > money) {
                pt2--;
                continue;
            }
            if (tmp < money) {
                pt1++;
            } else {
                pt1++;
                pt2--;
            }
            if (tmp >= sum) {
                sum = tmp;
                min = Math.min(min, tmp2);
            }
        }
        if (sum == -1) {
            min = -1;
        }
        System.out.println((sum) + " " + (min));
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
