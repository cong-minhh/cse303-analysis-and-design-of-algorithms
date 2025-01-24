import java.io.*;
import java.util.*;

public class EIQUEENS {

    static InputReader sc;

    public static void main(String[] args) throws Exception {
        sc = new InputReader();
        char[][] arr = new char[8][8];
        Map<Integer, Integer> map = new HashMap<>();
        int size = arr.length;
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                char c = sc.nextChar();
                arr[i][j] = c;
                if (c == '*')
                    map.put(i, j);
            }
        }

        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            int i = entry.getKey();
            int j = entry.getValue();
            for (int j2 = 0; j2 < size; j2++) {
                if (arr[i][j2] == '*' && j2 != j) {
                    System.out.println("invalid");
                    return;
                }
            }

            // check column
            for (int j2 = 0; j2 < size; j2++) {
                if (arr[j2][j] == '*' && j2 != i) {
                    System.out.println("invalid");
                    return;
                }
            }

            // y = -x
            for (int j2 = i + 1, j3 = j + 1; j2 < size && j3 < size; j2++, j3++) {
                if (arr[j2][j3] == '*') {
                    System.out.println("invalid");
                    return;
                }
            }
            for (int j2 = i - 1, j3 = j - 1; j2 >= 0 && j3 >= 0; j2--, j3--) {
                if (arr[j2][j3] == '*') {
                    System.out.println("invalid");
                    return;
                }
            }

            // y = x
            for (int j2 = i - 1, j3 = j + 1; j2 >= 0 && j3 < size; j2--, j3++) {
                if (arr[j2][j3] == '*') {
                    System.out.println("invalid");
                    return;
                }
            }
            for (int j2 = i + 1, j3 = j - 1; j2 < size && j3 >= 0; j2++, j3--) {
                if (arr[j2][j3] == '*') {
                    System.out.println("invalid");
                    return;
                }
            }
        }
        System.out.println(map.size() != 8 ? "invalid" : "valid");

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
