import java.io.*;
import java.util.Arrays;

class EIFLIP {

    static InputReader sc;
    static int[] brr;

    public static void main(String[] args) throws Exception {
        sc = new InputReader();
        StringBuilder res = new StringBuilder();
        int t = sc.nextInt();
        while (t-- > 0) {
            char[] arr = new char[10];
            for (int i = 1; i <= 9; i++) {
                arr[i] = sc.nextChar();
            }
            long ans = 0;
            for (int i = 0; i < 512; i++) {
                brr = new int[10];
                for (int j = 0; j < 9; j++) {
                    if ((i & (1 << j)) != 0) {
                        modify(brr, j + 1);
                    }
                }
                char[] crr = Arrays.copyOf(arr, 10);
                for (int j = 1; j <= 9; j++) {
                    crr[j] = (brr[j] & 1) == 0 ? crr[j] : reverse(crr[j]);
                }
                if (check(crr)) {
                    ans = Integer.bitCount(i);
                    break;
                }
            }
            res.append(ans).append("\n");

        }
        System.out.println(res.toString());
    }

    static char reverse(char c) {
        return c == '.' ? '*' : '.';
    }

    static boolean check(char[] arr) {
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] != '.') {
                return false;
            }
        }
        return true;
    }

    static void modify(int[] arr, int num) {
        int left = (num - 1) % 3 == 0 ? -1 : num - 1;
        int right = num % 3 == 0 ? -1 : num + 1;
        int top = num <= 3 ? -1 : num - 3;
        int bottom = num >= 7 ? -1 : num + 3;

        if (left != -1) {
            arr[left]++;
        }
        if (right != -1) {
            arr[right]++;
        }
        if (top != -1) {
            arr[top]++;
        }
        if (bottom != -1) {
            arr[bottom]++;
        }
        arr[num]++;
    }

    static String leftPad(String str, int length) {
        if (str.length() == length) {
            return str;
        }
        StringBuilder res = new StringBuilder();
        for (int i = 0; i < length - str.length(); i++) {
            res.append(0);
        }
        res.append(str);
        return res.toString();
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
