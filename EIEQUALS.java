import java.io.*;
import java.util.*;

class EIEQUALS {

    static InputReader sc;

    public static void main(String[] args) throws Exception {
        sc = new InputReader();
        int n = sc.nextInt();
        int allow = sc.nextInt();
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            int num = sc.nextInt();
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        for (int i = 0; i < n; i++) {
            int num = sc.nextInt();
            map.put(num, map.getOrDefault(num, 0) - 1);
            if (map.get(num) == 0) {
                map.remove(num);
            }
        }
        if (map.isEmpty()) {
            System.out.println("YES");
            return;
        }
        if (map.size() != 2) {
            System.out.println("NO");
            return;
        }
        Iterator<Map.Entry<Integer, Integer>> test = map.entrySet().iterator();
        Map.Entry<Integer, Integer> entry1 = test.next();
        Map.Entry<Integer, Integer> entry2 = test.next();
        int key1 = entry1.getKey();
        int key2 = entry2.getKey();
        int val1 = entry1.getValue();
        int val2 = entry2.getValue();
        if (val1 == 1 && val2 == -1 || val1 == -1 && val2 == 1) {
            if (Math.abs(key1 - key2) <= allow) {
                System.out.println("YES");
                return;
            }
        }
        System.out.println("NO");
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
