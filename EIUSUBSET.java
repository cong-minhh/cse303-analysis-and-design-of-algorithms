import java.io.*;

public class EIUSUBSET {

    static InputReader sc;

    public static void main(String[] args) throws Exception {
        sc = new InputReader();
        StringBuilder res = new StringBuilder();

        int n = sc.nextInt();

        double[] arr = new double[n];

        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextDouble();
        }

        int size = (1 << n) - 1;
        res.append(size).append("\n");

        for (int i = 1; i <= size; i++) {
            String str = Integer.toBinaryString(i);
            str = leftPad(str, n);
            for (int j = 0; j < str.length(); j++) {
                if (str.charAt(j) == '1') {
                    res.append((long) arr[j]).append(" ");
                }
            }
            res.append("\n");
        }

        System.out.println(res.toString());
    }

    static String leftPad(String str, int length) {
        if (str.length() == length) {
            return str;
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < length - str.length(); i++) {
            sb.append("0");
        }
        sb.append(str);
        return sb.toString();
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
