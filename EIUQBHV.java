import java.io.*;
import java.util.*;

class EIUQBHV {

    static InputReader sc;

    public static void main(String[] args) throws Exception {
        sc = new InputReader();
        String str = sc.next();
        TreeSet<String> lst = new TreeSet<>();

        lst.add(String.valueOf(str.charAt(0)));
        for (int i = 0; i < str.length(); i++) {
            if (i == 0)
                continue;
            char c = str.charAt(i);
            TreeSet<String> lst2 = new TreeSet<>();
            for (String string : lst) {
                for (int j = 0; j <= string.length(); j++) {
                    StringBuilder sb = new StringBuilder();
                    sb.append(string.substring(0, j)).append(c).append(string.substring(j));
                    // System.out.println(sb.toString());
                    lst2.add(sb.toString());
                }
            }
            lst = lst2;
        }
        StringBuilder res = new StringBuilder();
        res.append(lst.size()).append("\n");
        for (String ans : lst) {
            res.append(ans).append("\n");
        }
        System.out.println(res.toString());
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